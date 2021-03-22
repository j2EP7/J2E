package dao.mysql;


import dao.DAOException;
import dao.GameDao;
import model.GameModel;


import java.util.List;

public class MySQLGameDAO implements GameDao {
    public MySQLGameDAO() {
    }

    @Override
    public void insertar(GameModel a) throws DAOException {

    }

    @Override
    public void modificar(Integer id, GameModel a) throws DAOException {

    }

    @Override
    public void eliminar(Integer id) throws DAOException {

    }

    @Override
    public List<GameModel> ObtenerTodos() throws DAOException {
        return null;
    }

    @Override
    public GameModel obtener(Integer id) throws DAOException {
        return null;
    }
}
