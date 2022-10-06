package Controller;


import domain.model.Role;
import domain.model.User;
import domain.service.DbException;
import domain.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class EditProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("userid"));
        User edited=service.get(id);

        ArrayList<String> errors=new ArrayList<String>();

        request.setAttribute("userid",id);
        request.setAttribute("tobeEdited",edited);
        edited.setFirstNameRequest(request,errors);
        edited.setLastNameRequest(request,errors);
        edited.setEmailRequest(request,errors);
        edited.setTeamRequest(request,errors);
        edited.setRoleRequest(request,errors);

        if(errors.size()==0) {
            try {
                service.update(edited);

                request.setAttribute("useroverview", service.getAll());
                return "useroverview.jsp";
            }
            catch (DbException d) {
                errors.add(d.getMessage());
            }
            catch (NumberFormatException n) {
                errors.add(n.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "editForm.jsp";
    }













}