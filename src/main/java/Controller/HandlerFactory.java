package Controller;

public class HandlerFactory {

    public RequestHandler getHandler(String command) {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("Controller." + command);
            Object objectHandler = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) objectHandler;
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!");
        }
        return handler;
    }
}