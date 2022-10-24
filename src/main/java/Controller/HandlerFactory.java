package Controller;

import domain.service.UserServiceDBSQL;
import domain.service.UserService;

public class HandlerFactory {

    public RequestHandler getHandler(String command, UserServiceDBSQL service) {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("Controller." + command);
            Object objectHandler = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) objectHandler;
            handler.setService(service);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!");
        }
        return handler;
    }
}