package Controller;


import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("userid"));
        User tobeEdited=service.getUserWithId(id);
        request.setAttribute("tobeEdited",tobeEdited);

        return "editForm.jsp";
    }
}