package Controller;

import domain.model.Workorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderDeleteConfirm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("workorderid"));
        Workorder tobeDeleted=service.getWorkorderWithId(id);
        request.setAttribute("tobeDeleted",tobeDeleted);
        return "workorderDeleteConfirm.jsp";
    }
}
