package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Utilities;

// @WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Response type html
        response.setContentType("text/html");
        // Out
        PrintWriter out = response.getWriter();
        // Intentamos inicio de sesión en LDAP
        String ldapResult = new Utilities().LdapConnection(username,password);
        // Si ha ido bien redirigimos a play
        if(ldapResult == "Connected"){
            response.sendRedirect("play.jsp");
        }else {
            // En caso contrario login
            response.sendRedirect("index.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hacemos que el método doPost llame al doGet
        doGet(request, response);
    }


    public void destroy() {
    }
}