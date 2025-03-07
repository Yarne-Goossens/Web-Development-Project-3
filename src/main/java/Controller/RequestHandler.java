package Controller;


import domain.service.AppService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {
    protected AppService service;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException;

    public AppService getService() {
        return service;
    }

    public void setService(AppService service) {
        this.service = service;
    }
}