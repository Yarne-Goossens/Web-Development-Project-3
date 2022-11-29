package Controller;

import domain.service.AppService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HandlerFactory handlerFactory = new HandlerFactory();
    private AppService service = new AppService();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty())
            action = "Home";
        RequestHandler handler = handlerFactory.getHandler(action,service);

        try {
            destination = handler.handleRequest(request, response);
        } catch (NotAuthorizedException e) {
            // alle handlers gooien een NotAuthorizedException als gebruiker niet de juiste rechten heeft
            // zodat authorization altijd op dezelfde manier afgehandeld wordt
            //request.setAttribute("notAuthorized", "You have insufficient rights to have a look at the requested page.");
            destination = "Controller?command=NotAuthorizedExceptionPage";
        }
        if (!response.isCommitted()) {
            request.getRequestDispatcher(destination).forward(request, response);
        }
    }

}