package Controller;


import domain.db.UserDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Overview extends RequestHandler {
    UserDB userDB=new UserDB();
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("useroverview",userDB.getAlle());
        return "useroverview.jsp";
    }
}