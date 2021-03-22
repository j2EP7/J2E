package dao;

import java.util.List;


public interface DAO<T, K> {

    void insertar(T a) throws DAOException;

    void modificar(K id, T a) throws DAOException;

    void eliminar(K id) throws DAOException;

    List<T> ObtenerTodos() throws DAOException;

    T obtener(K id) throws DAOException;

}
