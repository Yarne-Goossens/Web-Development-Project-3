package Controller;


import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderOverview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);
            request.setAttribute("workorderoverview", service.getAllWorkorders());
            return "workorderOverview.jsp";
        } catch(NotAuthorizedException n){
                return "notAuthorized.jsp";
        }
    }
}