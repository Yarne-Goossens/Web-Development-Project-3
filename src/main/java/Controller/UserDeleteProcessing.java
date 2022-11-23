package Controller;


import Controller.RequestHandler;
import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException {
        try {
            Role[] roles = {Role.DIRECTOR,Role.TEAMLEADER,Role.EMPLOYEE};
            Utility.checkRole(request, roles);

            request.setAttribute("useroverview",service.getAllUsers());
            int deleteId = Integer.parseInt(request.getParameter("userid"));
            service.deleteUser(deleteId);
            return "Controller?command=UserOverview";
        }
        catch (NotAuthorizedException n){
            return "notAuthorized.jsp";
        }

    }
}