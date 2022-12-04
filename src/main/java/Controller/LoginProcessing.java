package Controller;

import Controller.RequestHandler;
import domain.model.User;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoginProcessing extends RequestHandler {
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException {
        ArrayList<String> errors = new ArrayList<String>();
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User loginUser = service.checkRealUserAndPassword(email, password);

            request.setAttribute("loginUser", loginUser);
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);

            response.sendRedirect("Controller?command=Home");
            return "Controller?command=Home";
        } catch (DbException e) {
            errors.add(e.getMessage());
        }
        request.setAttribute("errors", errors);
        return "index.jsp";
    }
}
