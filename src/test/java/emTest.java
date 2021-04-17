import model.GameEntity;
import model.Word;
import model.WordsEntity;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class emTest {


    @Test
    public void readGameEntityById(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        GameEntity result = entityManager.find(GameEntity.class, 1);
        String name = result.getParameter();
        String value = result.getValue();
        System.out.println(name + ": " + value);
    }

    @Test
    public void readWordEntityById(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        WordsEntity result = entityManager.find(WordsEntity.class, 1);
        String word = result.getWord();
        String description = result.getDescription();
        System.out.println(word + ": " + description);
    }

}
