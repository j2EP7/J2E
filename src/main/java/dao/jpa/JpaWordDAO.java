package dao.jpa;


import dao.DAOException;
import dao.WordDAO;
import model.Word;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaWordDAO implements WordDAO {

    public JpaWordDAO() {
    }

    @Override
    public void create(Word a) throws DAOException {

    }

    @Override
    public void update(Integer id, Word a) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {

    }

    @Override
    public List<Word> readAll() throws DAOException {
        // https://stackoverflow.com/questions/24572092/using-java-generics-for-jpa-findall-query-with-where-clause
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Word> cq = cb.createQuery(Word.class);
        Root<Word> rootEntry = cq.from(Word.class);
        CriteriaQuery<Word> all = cq.select(rootEntry);
        TypedQuery<Word> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Word read(Integer id) throws DAOException {
        return null;
    }
}
