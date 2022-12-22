package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderByNameProject extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException {

        Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
        Utility.checkRole(request, roles);
        request.setAttribute("projectoverview", service.getAllProjectsOrderedByName());
        return "projectOverview.jsp";

    }
}