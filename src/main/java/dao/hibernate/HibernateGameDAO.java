package dao.hibernate;


import dao.DAOException;
import dao.GameDao;
import model.Game;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class HibernateGameDAO implements GameDao {

    // https://xebia.com/blog/jpa-implementation-patterns-data-access-objects/
    // https://stackoverflow.com/questions/24572092/using-java-generics-for-jpa-findall-query-with-where-clause

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
