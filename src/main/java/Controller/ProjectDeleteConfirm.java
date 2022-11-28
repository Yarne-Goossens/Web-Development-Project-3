package Controller;


import Controller.RequestHandler;
import domain.model.Project;
import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectDeleteConfirm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR};
            Utility.checkRole(request, roles);
            int id = Integer.parseInt(request.getParameter("projectid"));
            Project tobeDeleted = service.getProjectWithId(id);
            request.setAttribute("tobeDeleted", tobeDeleted);
            return "projectDeleteConfirm.jsp";
        } catch (NotAuthorizedException n) {
            return "notAuthorized.jsp";
        }
    }
}