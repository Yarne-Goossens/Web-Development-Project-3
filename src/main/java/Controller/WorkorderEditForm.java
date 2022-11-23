package Controller;

import domain.model.Role;
import domain.model.Workorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);
            int id = Integer.parseInt(request.getParameter("workorderid"));
            Workorder tobeEdited = service.getWorkorderWithId(id);
            request.setAttribute("tobeEdited", tobeEdited);

            return "workorderEditForm.jsp";
        } catch(NotAuthorizedException n){
            return "notAuthorized.jsp";
        }
    }
}
