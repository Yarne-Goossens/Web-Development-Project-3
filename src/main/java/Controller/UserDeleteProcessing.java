package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException, IOException {

        Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
        Utility.checkRole(request, roles);


        request.setAttribute("useroverview", service.getAllUsers());
        int deleteId = Integer.parseInt(request.getParameter("userid"));
        service.deleteUser(deleteId);

        response.sendRedirect("Controller?command=UserOverview");
        return "Controller?command=UserOverview";


    }
}