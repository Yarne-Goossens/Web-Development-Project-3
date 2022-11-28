package Controller;

import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws NotAuthorizedException {

            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);
            User loggedIn=Utility.getUserLoggedIn(request);

            int id = Integer.parseInt(request.getParameter("userid"));
            User tobeEdited = service.getUserWithId(id);

            Utility.checkIfUserAuthorizedByUser(request,Role.EMPLOYEE,tobeEdited);
            if(Utility.checkRoleBoolean(request,Role.TEAMLEADER)){
                if(tobeEdited.getTeam()!=loggedIn.getTeam()){
                    throw new NotAuthorizedException();
                }
            }
            request.setAttribute("tobeEdited", tobeEdited);
            return "userEditForm.jsp";


    }
}