package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProjectSearchProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String projectName=request.getParameter("projectName");

        HttpSession session = request.getSession();
        session.setAttribute("foundProjectSession", service.getProjectWithName(projectName));

        response.sendRedirect("projectSearchResult.jsp");
        return "projectSearchResult.jsp";
    }
}