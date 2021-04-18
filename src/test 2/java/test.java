import controller.WordController;
import dao.DAOException;
import model.Word;
import org.junit.jupiter.api.Test;
import controller.GameController;

import java.util.ArrayList;
import java.util.List;

public class test {

  /*  @Test
    public void printAllWords() throws DAOException {
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        System.out.println(words);
    }*/

    @Test
    public void generateCasillero() throws DAOException {
        // Listado de palabras
        List<Word> words = new WordController().selectRandomWords();
        for (Word word:words){
            System.out.println(word.getWord());
        }
        // Listado de palabras con posiciones
        List<Word> wordsPositions = new GameController().setWordLetters(words);
        for (Word word:words){
            System.out.print(word.getLetters());
        }
        // Casillero
        // String casillero = new GameController().renderCasillero(wordsPositions);
        //System.out.println(casillero);



    }

}
