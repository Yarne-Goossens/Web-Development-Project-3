package Controller;

import domain.model.Role;
import domain.model.Workorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderDeleteConfirm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException {

        Role[] roles = {Role.DIRECTOR};
        Utility.checkRole(request, roles);
        int id = Integer.parseInt(request.getParameter("workorderid"));
        Workorder tobeDeleted = service.getWorkorderWithId(id);
        request.setAttribute("tobeDeleted", tobeDeleted);
        return "workorderDeleteConfirm.jsp";

    }
}
