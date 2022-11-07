package Controller;


import Controller.RequestHandler;
import domain.model.Project;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectDeleteConfirm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("projectid"));
        Project tobeDeleted=service.getProjectWithId(id);
        request.setAttribute("tobeDeleted",tobeDeleted);
        return "projectDeleteConfirm.jsp";
    }
}