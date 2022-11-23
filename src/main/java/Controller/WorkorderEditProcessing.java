package Controller;

import domain.model.Role;
import domain.model.Workorder;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class WorkorderEditProcessing extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("workorderid"));
        Workorder editWorkorder = service.getWorkorderWithId(id);
        Workorder edit = new Workorder();

        ArrayList<String> errors = new ArrayList<String>();

        request.setAttribute("workorderid", id);
        request.setAttribute("tobeEdited", editWorkorder);
        edit.setEmployee(editWorkorder.getEmployee());
        edit.setDescriptionRequest(request, errors);
        edit.setWorkorderDateRequest(request, errors);
        edit.setTeam("ALPHA");
        edit.setStartTimeRequest(request, errors);
        edit.setEndTimeRequest(request, errors);

        if (errors.size() == 0) {
            try {
                    Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
                    Utility.checkRole(request, roles);
                service.updateWorkorder(id,edit);

                return "Controller?command=WorkorderOverview";
            } catch (DbException d) {
                errors.add(d.getMessage());
            }
        catch(NotAuthorizedException n){
            return "notAuthorized.jsp";
        }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=WorkorderEditForm";
    }
}
