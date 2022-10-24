package Controller;


import domain.service.UserServiceDBSQL;
import domain.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    protected UserServiceDBSQL service;
    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public UserServiceDBSQL getService() {
        return service;
    }

    public void setService(UserServiceDBSQL service) {
        this.service = service;
    }
}