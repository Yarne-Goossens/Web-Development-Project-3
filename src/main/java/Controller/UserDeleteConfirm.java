package Controller;


import Controller.RequestHandler;
import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteConfirm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
            Utility.checkRole(request, roles);


            int id = Integer.parseInt(request.getParameter("userid"));
            User tobeDeleted = service.getUserWithId(id);
            request.setAttribute("tobeDeleted", tobeDeleted);
            return "userDeleteConfirm.jsp";
        } catch (NotAuthorizedException n) {
            return "notAuthorized.jsp";
        }

    }
}