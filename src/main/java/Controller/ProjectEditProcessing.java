package Controller;

import domain.model.Project;
import domain.service.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.DateTimeException;
import java.util.ArrayList;

public class ProjectEditProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("projectid"));
        Project editProject = service.getProjectWithId(id);
        Project edit = new Project();

        ArrayList<String> errors = new ArrayList<String>();

        request.setAttribute("projectid", id);
        request.setAttribute("tobeEdited", editProject);

        edit.setProjectNameRequest(request,errors);
        edit.setProjectStartDate(request,errors);
        edit.setProjectEndDate(request,errors);
        edit.setProjectTeamRequest(request,errors);

        if (errors.size() == 0) {
            try {
                service.updateProject(id,edit);

                return "Controller?command=ProjectOverview";
            } catch (DbException d) {
                errors.add(d.getMessage());
            } catch (NumberFormatException n) {
                errors.add(n.getMessage());
            } catch (IllegalArgumentException n) {
                errors.add(n.getMessage());
            }
            catch (DateTimeException n) {
                errors.add(n.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=ProjectEditForm";
    }
}