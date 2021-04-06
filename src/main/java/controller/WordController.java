package controller;

import dao.DAOException;
import dao.FactoryDAO;
import dao.GameDao;
import dao.WordDAO;
import model.Game;
import model.Letter;
import model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordController {

    // Función para generar palabras aleatorias para el casillero del juego
    public List<Word> selectRandomWords() throws DAOException {
        // Variable de número de palabras a generar
        int configNumberWords;
        // Booleano
        boolean noExiste;
        // Obtenemos el parámetro de configuración de palabras
        GameDao gameDAO = FactoryDAO.getGameDAO();
        Game paramWords = gameDAO.read("words");
        String paramWordsValue = paramWords.getValue();
        // Seteamos valor convirtiendo string a integer
        configNumberWords = Integer.parseInt(paramWordsValue);
        configNumberWords = 3;
        //Creamos array donde guardaremos las palabras seleccionadas
        List<Word> selectWords = new ArrayList<Word>(configNumberWords);
        // Obtenemos todas las palabras
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        // Instanciamos la clase Random
        Random random = new Random();
        // Recorremos hasta X número de palabras
        for (int i = 0; i < configNumberWords; i++) {
            noExiste = true;
            // Elegimos un índice al azar, entre 0 y el número de tamaño del array de words.
            int randomIndex = random.nextInt(words.size());
            while (noExiste){
                // Si la palabra no se encuentra en el array añadimos.
                if (!selectWords.contains(words.get(randomIndex))) {
                    selectWords.add(words.get(randomIndex));
                } else {
                    noExiste = false;
                }
            }
        }
        // Recorremos las palabras seleccionadas
        // Generamos propiedad letras de palabras
        // Seteamos la propiedad en la palabra
        // Así podremos más tarde asignar la posición a cada letra
        for (Word word:words) {
            String palabra = word.getWord();
            List<Letter> letters = new ArrayList<>();
            for (int i=0; i < palabra.length(); i++){
                Letter letter = new Letter();
                letter.setLetter(palabra.charAt(i));
                letters.add(letter);
            }
            word.setLetters(letters);
        }
        // Return de palabras seleccionadas
        return selectWords;
    }

}
