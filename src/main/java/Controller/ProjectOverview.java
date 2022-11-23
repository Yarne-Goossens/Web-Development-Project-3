package Controller;


import Controller.RequestHandler;
import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectOverview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);
            request.setAttribute("projectoverview", service.getAllProjects());
            return "projectOverview.jsp";
        }
        catch (NotAuthorizedException n){
            return "notAuthorized.jsp";
        }
    }
}