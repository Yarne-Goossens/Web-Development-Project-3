package Controller;

import domain.model.Role;
import domain.model.Workorder;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class WorkorderRegisterProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws NotAuthorizedException {
        ArrayList<String> errors = new ArrayList<String>();

        Workorder workorder = new Workorder();
        workorder.setEmployeeRequest(request, errors);
        workorder.setWorkorderTeamRequest(request, errors);
        workorder.setDescriptionRequest(request, errors);
        workorder.setWorkorderDateRequest(request, errors);
        workorder.setStartTimeRequest(request, errors);
        workorder.setEndTimeRequest(request, errors);
        workorder.setUserIdRequest(request,errors);

        if (request.getParameter("date").isEmpty()) {
            errors.add("Work order date is empty.");
        }
        if (request.getParameter("startTime").isEmpty()) {
            errors.add("Work order start time is empty.");
        }
        if (request.getParameter("endTime").isEmpty()) {
            errors.add("Work order end time is empty.");
        }

        if (errors.size() == 0) {
            try {
                Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
                Utility.checkRole(request, roles);
                service.addWorkorder(workorder);

                return "Controller?command=WorkorderOverview";
            } catch (DbException d) {
                errors.add(d.getMessage());

            }
        }


        request.setAttribute("errors", errors);
        return "Controller?command=WorkorderRegister";
    }
}
