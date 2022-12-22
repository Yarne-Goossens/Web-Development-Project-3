package Controller;

import domain.model.Project;
import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException {

        Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
        Utility.checkRole(request, roles);
        int id = Integer.parseInt(request.getParameter("projectid"));
        Project tobeEdited = service.getProjectWithId(id);

        if (Utility.checkRoleBoolean(request, Role.TEAMLEADER)) {
            if (tobeEdited.getTeam() != Utility.getUserLoggedIn(request).getTeam()) {
                throw new NotAuthorizedException();
            }
        }

        request.setAttribute("tobeEdited", tobeEdited);

        return "projectEditForm.jsp";

    }
}