package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderByEmployee extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("workorderoverview",service.getAllWorkordersOrderedByEmployee());
        return "workorderOverview.jsp";
    }
}