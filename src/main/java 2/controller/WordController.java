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
        //Creamos array donde guardaremos las palabras seleccionadas
        List<Word> selectWords = new ArrayList<Word>(configNumberWords);
        // Obtenemos todas las palabras
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        // Instanciamos la clase Random
        Random random = new Random();
        // Array de valores de index vacío
        List<Integer> arrayIndex = new ArrayList<>();
        // Mientras el array no tenga el mismo número de elementos que palabras a encontrar
        while(arrayIndex.size() != configNumberWords){
            // Generamos aleatoriamente un valor de index entre el mínimo (0) y el máximo del array de palabras
            int index = random.nextInt(words.size() - 0 + 1) + 0;
            // Si ese valor no está dentro del array lo añadimos
            if(!arrayIndex.contains(index)) {
                arrayIndex.add(index);
            }
        }
        // Recorremos array de valores de index para recoger las palabras
        for(int i = 0; i < configNumberWords;i++){
            selectWords.add(words.get(arrayIndex.get(i)));
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
