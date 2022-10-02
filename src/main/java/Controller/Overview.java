package Controller;


import domain.db.UserDB;
import domain.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Overview extends RequestHandler {
    UserService userDB=new UserService();
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("useroverview",userDB.getAll());
        return "useroverview.jsp";
    }
}