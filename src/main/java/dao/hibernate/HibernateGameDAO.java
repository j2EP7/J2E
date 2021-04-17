package dao.hibernate;


import dao.DAOException;
import dao.GameDao;
import model.Game;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
/*        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("select value from ");
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

 */
        return null;
    }
}
