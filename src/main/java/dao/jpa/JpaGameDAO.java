package dao.jpa;


import dao.DAOException;
import dao.GameDao;
import model.Game;

import java.util.List;

public class JpaGameDAO implements GameDao {

    // https://xebia.com/blog/jpa-implementation-patterns-data-access-objects/
    // https://stackoverflow.com/questions/24572092/using-java-generics-for-jpa-findall-query-with-where-clause

    public JpaGameDAO() {
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
