package dao.hibernate;


import dao.DAOException;
import dao.WordDAO;
import model.Word;

import java.util.List;

public class HibernateWordDAO implements WordDAO {

    public HibernateWordDAO() {
    }

    @Override
    public void insertar(Word a) throws DAOException {

    }

    @Override
    public void modificar(Integer id, Word a) throws DAOException {

    }

    @Override
    public void eliminar(Integer id) throws DAOException {

    }

    @Override
    public List<Word> ObtenerTodos() throws DAOException {
        return null;
    }

    @Override
    public Word obtener(Integer id) throws DAOException {
        return null;
    }
}
