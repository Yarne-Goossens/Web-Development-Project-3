package Controller;

import domain.model.Project;
import domain.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectRegisterProcessing extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws NotAuthorizedException, IOException {
        ArrayList<String> errors = new ArrayList<String>();

        Project project = new Project();
        project.setProjectNameRequest(request, errors);
        project.setProjectTeamRequest(request, errors);
        project.setProjectStartDate(request, errors);
        project.setProjectEndDate(request, errors);

        if (request.getParameter("start").isEmpty()) {
            errors.add("Project start date is empty.");
        }
        if (request.getParameter("end").isEmpty()) {
            errors.add("Project end date is empty.");
        }

        if (errors.size() == 0) {
            try {
                Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER};
                Utility.checkRole(request, roles);
                service.addProject(project);

                response.sendRedirect("Controller?command=ProjectOverview");
                return "Controller?command=ProjectOverview";
            } catch (IllegalArgumentException d) {
                errors.add(d.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=ProjectRegister";
    }

}