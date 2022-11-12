package Controller;

import domain.model.Project;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectRegisterProcessing extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException {
        ArrayList<String>errors=new ArrayList<String>();

        Project project= new Project();
        project.setProjectNameRequest(request,errors);
        project.setProjectTeamRequest(request,errors);
        project.setProjectStartDate(request,errors);
        project.setProjectEndDate(request,errors);

        if(errors.size()==0) {
            try {
                service.addProject(project);
                response.sendRedirect("Controller?command=ProjectOverview");
                return "Controller?command=ProjectOverview";
            }
            catch (IllegalArgumentException d) {
                errors.add(d.getMessage());
                return "Controller?command=ProjectRegister";
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=ProjectRegister";
    }

}