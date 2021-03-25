package dao.hibernate;


import dao.DAOException;
import dao.GameDao;
import model.GameModel;

import java.util.List;

public class HibernateGameDAO implements GameDao {

    public HibernateGameDAO() {
    }

    @Override
    public void create(GameModel a) throws DAOException {

    }

    @Override
    public void update(Integer id, GameModel a) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {

    }

    @Override
    public List<GameModel> readAll() throws DAOException {
        return null;
    }

    @Override
    public GameModel read(Integer id) throws DAOException {
        return null;
    }
}
