package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexBBDD {

    public static Connection createConnection() {
        // Use DRIVER and DBURL to create a connection
        // Recommend connection pool implementation/usage
        Connection conexion=null;
        try{
            String URL = "jdbc:mysql://localhost:8889/producto7";
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");


            conexion = DriverManager.getConnection(URL, "root", "root");

            System.out.println("Conectado correctamente a la Base de Datos");

        } catch (SQLException e) {
            System.out.println("Error de conexion: "+e);
        } catch (Exception e) {
            System.out.println("Error desconocido: "+e);
        }

        return conexion;
    }

    public static void closeConnection(Connection conexion)throws SQLException
    {
        if(conexion != null)
        {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("Error cerrando base de datos: "+e);
            }
        }
    }

}
