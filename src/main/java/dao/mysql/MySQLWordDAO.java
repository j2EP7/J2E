package dao.mysql;


import dao.DAOException;
import dao.WordDAO;
import model.Word;
import controller.ConexBBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLWordDAO implements WordDAO {

    Connection conexion;

    public MySQLWordDAO() {
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
    public List<Word> readAll() throws DAOException{
        List<Word> lista = new ArrayList<>();
        try {
            conexion = ConexBBDD.createConnection();
            Statement st = conexion.createStatement();
            String query = "select * from words where 1";
            ResultSet result = st.executeQuery(query);
            System.out.println("readAll done");
            // Recorremos las palabras seleccionadas
            while (result.next())
            {
                // Recuperamos los valores de la fila en cada iteración
                int word_id = result.getInt("id");
                String word_text = result.getString("word");
                String word_description = result.getString("description");
                // Creamos un objeto del modelo Word y seteamos los valores
                Word word = new Word();
                word.setId(word_id);
                word.setWord(word_text);
                word.setDescription(word_description);
                // Añadimos objeto a la lista
                lista.add(word);
            }
        } catch (SQLException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            return lista;
        }
    }

    @Override
    public Word read(Integer id) throws DAOException {
        return null;
    }

}
