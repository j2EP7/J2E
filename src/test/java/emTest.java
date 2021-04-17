import dao.DAOException;
import dao.FactoryDAO;
import dao.WordDAO;
import model.Game;
import model.Word;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class emTest {


    @Test
    public void readGameEntityById(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Game result = entityManager.find(Game.class, 1);
        String name = result.getParameter();
        String value = result.getValue();
        System.out.println(name + ": " + value);
    }

    @Test
    public void readWordEntityById(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Word result = entityManager.find(Word.class, 1);
        String word = result.getWord();
        String description = result.getDescription();
        System.out.println(word + ": " + description);
    }

    @Test
    public void readAllWords() throws DAOException {
        WordDAO wordDAO = FactoryDAO.getWordDAO();
        List<Word> words = wordDAO.readAll();
        for (Word word:words
             ) {
            String palabra = word.getWord();
            System.out.println(palabra);
        }
    }

}
