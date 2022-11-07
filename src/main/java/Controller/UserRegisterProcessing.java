package Controller;

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
                service.addUser(user);
                return "Controller?command=UserOverview";
            }
            catch (DbException d) {
                errors.add(d.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=UserRegister";
    }

}