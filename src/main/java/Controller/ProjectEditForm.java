package Controller;

import domain.model.Project;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("projectid"));
        Project tobeEdited=service.getProjectWithId(id);
        request.setAttribute("tobeEdited",tobeEdited);

        return "projectEditForm.jsp";
    }
}