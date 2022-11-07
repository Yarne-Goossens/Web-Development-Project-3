package Controller;

import domain.model.Workorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderEditForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("workorderid"));
        Workorder tobeEdited = service.getWorkorderWithId(id);
        request.setAttribute("tobeEdited", tobeEdited);

        return "workorderEditForm.jsp";
    }
}
