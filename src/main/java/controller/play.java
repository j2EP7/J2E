package controller;

import dao.DAOException;
import dao.FactoryDAO;
import dao.WordDAO;
import model.Word;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "play", value = "/play")
public class play extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
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
        out.println("<h1>sopa de letras</h1>");
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        try {
            List<Word> words = wordDAO.readAll();
            for (Word var:words) {
                out.println("<p>Palabra: "+var.getWord()+"</p>");
                out.println("<p>Text: "+var.getDescription()+"</p>");
            }
        }catch (Exception e){
            System.out.println(e);
        }




    }

    public void printAllWords() throws DAOException {

    }
}
