package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectSearch extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
            Utility.checkRole(request, roles);
            return "projectSearch.jsp";
        } catch(NotAuthorizedException n){
            return "notAuthorized.jsp";
        }
    }
}