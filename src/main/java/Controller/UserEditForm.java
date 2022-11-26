package Controller;

import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);

            int id = Integer.parseInt(request.getParameter("userid"));
            User tobeEdited = service.getUserWithId(id);

            Utility.checkIfUserAuthorizedByUser(request,Role.EMPLOYEE,tobeEdited);

            request.setAttribute("tobeEdited", tobeEdited);
            return "userEditForm.jsp";
        }
        catch(NotAuthorizedException n){
            return "notAuthorized.jsp";
        }

    }
}