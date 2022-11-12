package Controller;

import domain.model.Workorder;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class WorkorderRegisterProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException {
        ArrayList<String> errors = new ArrayList<String>();

        Workorder workorder = new Workorder();
        workorder.setEmployeeRequest(request, errors);
        workorder.setWorkorderTeamRequest(request,errors);
        workorder.setDescriptionRequest(request, errors);
        workorder.setWorkorderDateRequest(request, errors);
        workorder.setStartTimeRequest(request, errors);
        workorder.setEndTimeRequest(request, errors);

        if (errors.size() == 0) {
            try {
                service.addWorkorder(workorder);
                response.sendRedirect("Controller?command=WorkorderOverview");
                return "Controller?command=WorkorderOverview";
            } catch (DbException d) {
                errors.add(d.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=WorkorderRegister";
    }
}
