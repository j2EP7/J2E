import dao.DAOException;
import dao.FactoryDAO;
import dao.WordDAO;
import model.Word;
import org.junit.jupiter.api.Test;
import controller.game;

import java.util.List;
import controller.game;

public class test {

    @Test
    public void printAllWords() throws DAOException {
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        System.out.println(words);
    }

}
