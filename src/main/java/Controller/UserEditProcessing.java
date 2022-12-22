package Controller;

import domain.model.Role;
import domain.model.User;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserEditProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException, IOException {

        int id = Integer.parseInt(request.getParameter("userid"));
        User editUser = service.getUserWithId(id);
        User edit = new User();

        ArrayList<String> errors = new ArrayList<String>();

        request.setAttribute("userid", id);
        request.setAttribute("tobeEdited", editUser);

        edit.setEmailRequest(request, errors);
        edit.setFirstNameRequest(request, errors);
        edit.setLastNameRequest(request, errors);

        if (Utility.checkRoleBoolean(request, Role.EMPLOYEE)) {
            edit.setRole(editUser.getRole());
            edit.setTeam(editUser.getTeam());
        } else if (Utility.checkRoleBoolean(request, Role.TEAMLEADER)) {
            if (request.getParameter("role").compareTo("director") == 0) {
                throw new NotAuthorizedException();
            } else {
                edit.setRoleRequest(request, errors);
                edit.setTeamRequest(request, errors);
            }
        } else if (Utility.getUserLoggedIn(request).getUserid() == editUser.getUserid() && Utility.getUserLoggedIn(request).getRole() == Role.DIRECTOR) {
            edit.setTeamRequest(request, errors);
            edit.setRole(editUser.getRole());
        } else if (Utility.checkRoleBoolean(request, Role.DIRECTOR)) {
            edit.setRoleRequest(request, errors);
            edit.setTeamRequest(request, errors);
        }


        if (errors.size() == 0) {
            try {
                Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
                Utility.checkRole(request, roles);
                User loggedIn = Utility.getUserLoggedIn(request);
                Utility.checkIfUserAuthorizedByUser(request, Role.EMPLOYEE, editUser);

                if (Utility.checkRoleBoolean(request, Role.TEAMLEADER)) {
                    if (editUser.getTeam() != loggedIn.getTeam()) {
                        throw new NotAuthorizedException();
                    }
                }

                service.updateUser(id, edit);
                response.sendRedirect("Controller?command=UserOverview");
                return "Controller?command=UserOverview";
            } catch (DbException d) {
                errors.add(d.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=UserEditForm";
    }
}