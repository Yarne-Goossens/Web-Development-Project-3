package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorkorderSearchProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException, IOException {

        Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
        Utility.checkRole(request, roles);

        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("foundWorkorder", service.getWorkorderWithId(id));

        //response.sendRedirect("workorderSearchResult.jsp");
        return "workorderSearchResult.jsp";
    }
}