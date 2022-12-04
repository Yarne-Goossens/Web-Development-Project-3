package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorkorderDeleteProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException, IOException {

        Role[] roles = {Role.DIRECTOR};
        Utility.checkRole(request, roles);
        int deleteId = Integer.parseInt(request.getParameter("workorderid"));
        service.deleteWorkorder(deleteId);

        response.sendRedirect("Controller?command=WorkorderOverview");
        return "Controller?command=WorkorderOverview";

    }
}
