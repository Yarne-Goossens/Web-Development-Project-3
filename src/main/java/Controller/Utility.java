package Controller;

import domain.model.Role;
import domain.model.User;

import javax.servlet.http.HttpServletRequest;

public class Utility {
    /**
     * Checks if the role of the user stored in request.getSession() has one of the given roles
     * @param request The request object to get user in session attribute
     * @param roles Array of alowed roles for the given request
     * @throws NotAuthorizedException if the role of the user in session does not correspond with one of the given roles
     */
    public static void checkRole(HttpServletRequest request, Role[] roles) {
        // read user from session
        // if users role is different from given roles
        //      throw NotAuthorizedException
        boolean found = false;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
            for (Role role : roles) {
                if (user.getRole().equals(role)) {
                    found = true;
                    break;
                }
            }
        if (!found)
            throw new NotAuthorizedException();
    }

    public static boolean checkRoleBoolean(HttpServletRequest request,Role role) {

        boolean found = false;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            if (user.getRole().equals(role)) {
                found = true;
            }
        }
        return found;
    }

    public static User getUserLoggedIn(HttpServletRequest request){
        return  (User) request.getSession().getAttribute("user");
    }

    public static void checkIfUserAuthorizedByUser(HttpServletRequest request, Role expectedRole, User expectedUser){
        if(Utility.checkRoleBoolean(request,expectedRole)){
            if(expectedUser.getUserid()!=Utility.getUserLoggedIn(request).getUserid()){
                throw new NotAuthorizedException();
            }
        }
    }


    public static boolean checkIfUserRoleSame(HttpServletRequest request, Role expectedRole){
        User loggedIn= (User) request.getSession().getAttribute("user");
        return loggedIn.getRole().equals(expectedRole);
    }

}