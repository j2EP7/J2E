package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "play", value = "/play")
public class play extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // obtener configuración de palabras (número de palabras) del juego
        // obtener listado de palabras
        // sacar de ese listado X palabras al azar
        // generar estructura de sopa de letras
        // devolver
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("sopa de letras");
    }
}
