package controller;

import dao.DAOException;
import dao.FactoryDAO;
import dao.WordDAO;
import model.Letter;
import model.Word;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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

    }

    public List<Word> selectWord() throws DAOException {
        boolean noExiste;

        //Creamos array donde guardaremos las palabras seleccionadas
        List<Word> selectWords = new ArrayList<Word>(7);

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

        // Generamos propiedad letras de palabras
        for (Word word:words
             ) {
            String palabra = word.getWord();
            List<Letter> letters = new ArrayList<>();
            for (int i=0; i < palabra.length(); i++){
                Letter letter = new Letter();
                letter.setLetter(palabra.charAt(i));
                letters.add(letter);
            }
            word.setLetters(letters);
        }

        return selectWords;
    }
}
