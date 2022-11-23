package Controller;

import domain.model.Role;
import domain.model.User;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class UserRegisterProcessing extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String>errors=new ArrayList<String>();

        User user= new User();
        user.setFirstNameRequest(request,errors);
        user.setLastNameRequest(request,errors);
        user.setEmailRequest(request,errors);
        user.setPasswordRequest(request,errors);
        user.setTeamRequest(request,errors);

        if(errors.size()==0) {
            try {
                    Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
                    Utility.checkRole(request, roles);
                service.addUser(user);
                return "Controller?command=UserOverview";
            }
            catch (DbException d) {
                errors.add(d.getMessage());
            }
            catch (NotAuthorizedException n){
                return "notAuthorized.jsp";
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=UserRegister";
    }

}