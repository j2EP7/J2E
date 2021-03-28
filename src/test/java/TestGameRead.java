import dao.DAOException;
import dao.FactoryDAO;
import dao.GameDao;
import model.Game;
import org.junit.jupiter.api.Test;

public class TestGameRead{

    @Test
    public void readGame() throws DAOException {
        GameDao gameDAO = FactoryDAO.getGameDAO();
        Game gamemodel = gameDAO.read("max_time");
        System.out.println(gamemodel.toString());
    }

}

