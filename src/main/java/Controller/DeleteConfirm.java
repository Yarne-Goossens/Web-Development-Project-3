package Controller;


import domain.model.User;
import domain.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteConfirm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("userid"));
        User tobeDeleted=service.get(id);
        request.setAttribute("tobeDeleted",tobeDeleted);

        return "deleteConfirm.jsp";
    }
}