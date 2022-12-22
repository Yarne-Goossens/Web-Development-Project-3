package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProjectSearchProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException, IOException {

        Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
        Utility.checkRole(request, roles);
        String projectName = request.getParameter("projectName");
        request.setAttribute("foundProject", service.getProjectWithName(projectName));

        //response.sendRedirect("projectSearchResult.jsp");
        return "projectSearchResult.jsp";

    }
}