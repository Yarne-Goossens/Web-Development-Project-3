package Controller;


import Controller.RequestHandler;
import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectOverview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws NotAuthorizedException {

            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);
            User loggedIn=Utility.getUserLoggedIn(request);

            if(Utility.checkIfUserRoleSame(request,Role.EMPLOYEE)){
                request.setAttribute("projectoverview", service.getAllProjectsRestrictedByTeam(loggedIn.getTeam()));
                return "projectOverview.jsp";
            }

            request.setAttribute("projectoverview", service.getAllProjects());
            return "projectOverview.jsp";


    }
}