import dao.DAOException;
import dao.FactoryDAO;
import dao.WordDAO;
import model.Word;
import org.junit.jupiter.api.Test;
import controller.game;
import controller.SelectWords;

import java.util.ArrayList;
import java.util.List;
import controller.game;

public class test {

  /*  @Test
    public void printAllWords() throws DAOException {
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        System.out.println(words);
    }*/

    @Test
    public void generateCasillero(){
        List<Word> words = new ArrayList<>();
        try{
            words = new SelectWords().selectWord();
            for (Word word:words) {
                System.out.println(word.getWord());
            }
            List<Word> results = new game().setWordLetters(words);
            for (Word result:results
                 ) {
                System.out.println(result.getWord());
                System.out.print(result.getLetters().toString());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }



    }

}
