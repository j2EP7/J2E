package dao.hibernate;


import dao.DAOException;
import dao.GameDao;
import model.Game;

import java.util.List;

public class HibernateGameDAO implements GameDao {

    public HibernateGameDAO() {
    }

    @Override
    public void create(Game a) throws DAOException {

    }

    @Override
    public void update(String parameter, Game a) throws DAOException {

    }

    @Override
    public void delete(String parameter) throws DAOException {

    }

    @Override
    public List<Game> readAll() throws DAOException {
        return null;
    }

    @Override
    public Game read(String parameter) throws DAOException {
        return null;
    }
}
