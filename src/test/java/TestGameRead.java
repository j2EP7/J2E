import dao.DAOException;
import dao.FactoryDAO;
import dao.WordDAO;
import dao.GameDao;
import dao.mysql.MySQLGameDAO;
import model.GameModel;
import org.junit.jupiter.api.Test;
import controller.game;

import java.util.List;
import controller.game;

public class TestGameRead{

    @Test
    public void readGame() throws DAOException {
        GameDao gameDAO = FactoryDAO.getGameDAO();
        GameModel gamemodel = gameDAO.read("max_time");
        System.out.println(gamemodel.toString());
    }

}

