package Controller;

import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectSearchProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
            Utility.checkRole(request, roles);
            String projectName = request.getParameter("projectName");
            request.setAttribute("foundProject", service.getProjectWithName(projectName));
            return "projectSearchResult.jsp";
        } catch (NotAuthorizedException n) {
            return "notAuthorized.jsp";
        }
    }
}