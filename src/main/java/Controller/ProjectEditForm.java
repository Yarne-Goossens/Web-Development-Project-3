package Controller;

import domain.model.Project;
import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);
            int id = Integer.parseInt(request.getParameter("projectid"));
            Project tobeEdited = service.getProjectWithId(id);
            request.setAttribute("tobeEdited", tobeEdited);

            return "projectEditForm.jsp";
        } catch (NotAuthorizedException n) {
            return "notAuthorized.jsp";
        }
    }
}