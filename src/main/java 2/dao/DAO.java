package dao;

import java.util.List;


public interface DAO<T, K> {

    void create(T a) throws DAOException;

    T read(K id) throws DAOException;

    List<T> readAll() throws DAOException;

    void update(K id, T a) throws DAOException;

    void delete(K id) throws DAOException;

}
