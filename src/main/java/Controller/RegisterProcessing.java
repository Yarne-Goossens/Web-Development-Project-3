package Controller;

import domain.model.Role;
import domain.model.User;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RegisterProcessing extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String>errors=new ArrayList<String>();

        User user= new User();
        setFirstName(user,request,errors);
        setLastName(user,request,errors);
        setEmail(user,request,errors);
        setPassword(user,request,errors);
        setTeam(user,request,errors);

        if(errors.size()==0) {
            try {
                user.setRole(Role.DIRECTOR);
                service.add(user);
                request.setAttribute("useroverview", service.getAll());
                return "useroverview.jsp";
            }
            catch (DbException d) {
                errors.add(d.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "register.jsp";
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

    private void setPassword(User u, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("password");
        boolean passwordHasErrors = false;
        try {
            request.setAttribute("passwordPreviousValue", name);
            u.setPassword(name);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            passwordHasErrors = true;
        } finally {
            request.setAttribute("passwordHasErrors", passwordHasErrors);
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

}