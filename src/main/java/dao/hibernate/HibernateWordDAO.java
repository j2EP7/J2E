package dao.hibernate;


import dao.DAOException;
import dao.WordDAO;
import model.Word;

import java.util.List;

public class HibernateWordDAO implements WordDAO {

    public HibernateWordDAO() {
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
        return null;
    }

    @Override
    public Word read(Integer id) throws DAOException {
        return null;
    }
}
