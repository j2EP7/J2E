package dao.mysql;


import dao.DAOException;
import dao.GameDao;
import model.GameModel;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MySQLGameDAO implements GameDao {
    public MySQLGameDAO() {
    }

    @Override
    public void create(GameModel a) throws DAOException {

    }

    @Override
    public void update(Integer id, GameModel a) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {

    }

    @Override
    public List<GameModel> readAll() throws DAOException {
        return null;
    }

    @Override
    public GameModel read(Integer id) throws DAOException {

    /*    conexion = Utility.conectar(conexion);

        //Preparemos la Query con el ?

        String query = "select * from ingresos where id = ?" ;

        //Creamos el Statment
        PreparedStatement st = conexion.prepareStatement(query);


        //Setemoas el valor asegurando que pasan un long y solo aceptamos el primer tramo

        st.setLong(1, id);

        //ejecutar el la Query en execute porque es un select

        ResultSet result = st.executeQuery();*/

        return null;
    }
}
