package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderDeleteProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
            Utility.checkRole(request, roles);
            int deleteId = Integer.parseInt(request.getParameter("workorderid"));
            service.deleteWorkorder(deleteId);
            return "Controller?command=WorkorderOverview";
        } catch(NotAuthorizedException n){
            return "notAuthorized.jsp";
        }
    }
}
