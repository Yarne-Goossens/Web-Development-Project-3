package Controller;


import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectDeleteProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws NotAuthorizedException {

            Role[] roles = {Role.DIRECTOR};
            Utility.checkRole(request, roles);
            int deleteId = Integer.parseInt(request.getParameter("projectid"));
            service.deleteProject(deleteId);
            return "Controller?command=ProjectOverview";

    }
}