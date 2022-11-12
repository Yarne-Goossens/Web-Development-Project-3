package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorkorderDeleteProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException {
        int deleteId = Integer.parseInt(request.getParameter("workorderid"));
        service.deleteWorkorder(deleteId);
        response.sendRedirect("Controller?command=WorkorderOverview");
        return "Controller?command=WorkorderOverview";
    }
}
