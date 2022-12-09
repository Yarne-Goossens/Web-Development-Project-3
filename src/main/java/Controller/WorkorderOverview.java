package Controller;

import domain.model.Role;
import domain.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkorderOverview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws NotAuthorizedException {

            Role[] roles = {Role.DIRECTOR, Role.TEAMLEADER, Role.EMPLOYEE};
            Utility.checkRole(request, roles);
            User loggedIn = Utility.getUserLoggedIn(request);

            if (Utility.checkIfUserRoleSame(request, Role.EMPLOYEE) || Utility.checkIfUserRoleSame(request, Role.TEAMLEADER)) {
                request.setAttribute("workorderoverview", service.getAllWorkordersRestrictedByTeam(loggedIn.getTeam()));
                return "workorderOverview.jsp";
            }

            request.setAttribute("workorderoverview", service.getAllWorkorders());
            return "workorderOverview.jsp";

    }
}