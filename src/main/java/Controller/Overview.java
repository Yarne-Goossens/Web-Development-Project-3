package Controller;


import domain.service.UserServiceI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Overview extends RequestHandler {
    private final UserServiceI db=new UserServiceI();
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("useroverview",service.getAll());
        return "useroverview.jsp";
    }
}