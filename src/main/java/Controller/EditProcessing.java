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

        setFirstName(edited,request,errors);
        setLastName(edited,request,errors);
        setEmail(edited,request,errors);
        setTeam(edited,request,errors);
        setRole(edited,request,errors);

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


    private void setFirstName(User u, HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        boolean firstnameHasErrors = false;
        try {
            request.setAttribute("firstnamePreviousValue", firstName);
            u.setFirstName(firstName);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            firstnameHasErrors = true;
        } finally {
            request.setAttribute("firstnameHasErrors", firstnameHasErrors);
        }
    }

    private void setLastName(User u, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("lastName");
        boolean nameHasErrors = false;
        try {
            request.setAttribute("namePreviousValue", name);
            u.setLastName(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            nameHasErrors = true;
        } finally {
            request.setAttribute("nameHasErrors", nameHasErrors);
        }
    }

    private void setEmail(User u, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("email");
        boolean emailHasErrors = false;
        try {
            request.setAttribute("emailPreviousValue", name);
            u.setEmail(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            emailHasErrors = true;
        } finally {
            request.setAttribute("emailHasErrors", emailHasErrors);
        }
    }


    private void setTeam(User u, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("team");
        boolean teamHasErrors = false;
        try {
            request.setAttribute("teamPreviousValue", name);
            u.setTeam(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            teamHasErrors = true;
        } finally {
            request.setAttribute("teamHasErrors", teamHasErrors);
        }
    }

    private void setRole(User u, HttpServletRequest request, ArrayList<String> errors) {
        String r = request.getParameter("role");

        boolean roleHasErrors = false;
        try {
            request.setAttribute("rolePreviousValue", r);
            u.setRole(r);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            roleHasErrors = true;
        } finally {
            request.setAttribute("roleHasErrors", roleHasErrors);
        }
    }

}