package Controller;


import Controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int deleteId=Integer.parseInt(request.getParameter("userid"));
        service.deleteUser(deleteId);
        return "Controller?command=Overview";
    }
}