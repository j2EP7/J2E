import dao.DAOException;
import model.Word;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSelectWord {

    @Test
    public void selectWords() throws DAOException {
        controller.SelectWords obj = new controller.SelectWords();
        List<Word> words = new ArrayList<>();
        words = obj.selectWord();
        for (Word word: words
             ) {
            System.out.println(word.toString());
        }
    }
}
