package dao.mysql;


import controller.ConexBBDD;
import dao.DAOException;
import dao.GameDao;
import model.Game;


import java.sql.*;
import java.util.List;


public class MySQLGameDAO implements GameDao {

    Connection conexion;

    //Usamos las columnas creadas en la base de datos para recuperar el parameter asociado a ellas
    final static String MAXTIME = "max_time";
    final static String NUMBERWORDS = "words"; //indica el numero de palabras que habrá en la sopa de letras

    Game objConfig;


    public MySQLGameDAO() {
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

    @Override //!!!!!!!!!!!!!!!!!!!Cambiada parametrización en interfaz!!!!!!!!!!!!!!!!!
    public Game read(String parameterr) throws DAOException {

        //GameModel

        try {

            //Usamos clase ConexBDD para crear la conexión según lo que hemos establecido en aquella clase
            conexion = ConexBBDD.createConnection();

            //Preparemos la Query con el ?
            String query = "select * from game where parameter=?";

            //Creamos el PreparedStatment para cargar la consulta preparada
            PreparedStatement st = conexion.prepareStatement(query);

            //¿Qué valor de qué parámetro quiere leer en la consulta SQL? -- En función de "parameterr" que indica el parámetro que se va a settear
            if (parameterr.equals(NUMBERWORDS)) {
                //Establecemos valor de tiempo como parameter de la consulta preparada
                st.setString(1, NUMBERWORDS);
            } else if (parameterr.equals(MAXTIME)) {
                //Establecemos la cantidad de palabras como parameter en el primer interrogante de la consulta preparada
                st.setString(1, MAXTIME);
            }
                // Ejecutamos la consulta
                ResultSet result = st.executeQuery();

                //Variable para almacenar el valor recuperado al parametro asociado que hemos pasado por consulta
                String valueTemp = "";

                while (result.next()) { //¿Haría falta el while si el resultSet solo tendría un registro?
                    //Guardamos el valor asociado al parámetro pasado por consulta
                    if (parameterr.equalsIgnoreCase(MAXTIME)) {
                        //Recuperamos los valores id y value en relación al parameterr
                        int gameId = result.getInt("id");
                        valueTemp = result.getString("value");
                        //Creamos el objeto que será retornado como resultado de la consulta
                        objConfig = new Game();
                        objConfig.setParameter(parameterr);
                        objConfig.setValue(valueTemp);
                        objConfig.setId(gameId);
                    } else if (parameterr.equalsIgnoreCase(NUMBERWORDS)) {
                        //
                        int gameId = result.getInt("id");
                        valueTemp = result.getString("value");
                        //
                        objConfig = new Game();
                        objConfig.setParameter(parameterr);
                        objConfig.setValue(valueTemp);
                        objConfig.setId(gameId);
                    }
                }
        } catch (SQLException e) {
            System.out.println("error SQL " + e.getMessage());
        } catch (Exception e) {
            System.out.println("error desconocindo " + e.getMessage());
        } finally {
            return objConfig;
        }


    }
}
