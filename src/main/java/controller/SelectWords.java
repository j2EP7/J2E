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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "SelectWords", value = "/SelectWords")
public class SelectWords extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        try{
            List<Word> wordList= this.selectWord();
            for (Word word : wordList
                 ) {
                out.println("<p> Palabra: "+word.getWord()+"</p>");
                //Solo se muestra la descripción si se gana
               //debug out.println(request.getParameter("palabra"));
                if(request.getParameter("palabra").equals(word.getWord())) {
                    out.println("<p> Descripción: " + word.getDescription() + "</p>");
                }else{
                    out.println("<p> no existe esa palabra </p>");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Word> selectWord() throws DAOException {
        boolean noExiste;

        //Creamos array donde guardaremos las palabras seleccionadas
        List<Word> selectWords = new ArrayList<>(6); //La capacidad inicial vendrá dada por el número de palabras recuperadas del objeto Game de configuración de la base de datos.

        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();

        // Instanciamos la clase Random
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            noExiste = true;
            // Elegimos un índice al azar, entre 0 y el número de tamaño del array de words.
            int randomIndex = random.nextInt(words.size());
            while (noExiste){
                //si la palabra no se encuentra en el array añadimos.
                if (!selectWords.contains(words.get(randomIndex))) {
                    selectWords.add(words.get(randomIndex));
                } else {
                    noExiste = false;
                }
            }
        }
        return selectWords;
    }
}
