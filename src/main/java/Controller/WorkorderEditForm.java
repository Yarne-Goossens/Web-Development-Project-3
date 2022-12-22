package Controller;

import domain.model.Role;
import domain.model.Workorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException {

        Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
        Utility.checkRole(request, roles);

        int id = Integer.parseInt(request.getParameter("workorderid"));
        Workorder tobeEdited = service.getWorkorderWithId(id);

        if (Utility.checkRoleBoolean(request, Role.EMPLOYEE)) {
            if (tobeEdited.getUserId() != Utility.getUserLoggedIn(request).getUserid()) {
                throw new NotAuthorizedException();
            }
        }

        if (Utility.checkRoleBoolean(request, Role.TEAMLEADER)) {
            if (tobeEdited.getTeam() != Utility.getUserLoggedIn(request).getTeam()) {
                throw new NotAuthorizedException();
            }
        }
        request.setAttribute("tobeEdited", tobeEdited);
        return "workorderEditForm.jsp";

    }
}
