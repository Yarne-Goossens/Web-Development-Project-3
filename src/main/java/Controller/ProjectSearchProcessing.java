package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectSearchProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String projectName=request.getParameter("projectName");
        request.setAttribute("foundProject",service.getProjectWithName(projectName));
        return "projectSearchResult.jsp";
    }
}