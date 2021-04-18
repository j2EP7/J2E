package controller;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

public class Utilities {

    // Función para abrir conexión en la base de datos
    public static Connection createConnection() {
        // Use DRIVER and DBURL to create a connection
        // Recommend connection pool implementation/usage
        Connection conexion=null;
        try{
            String URL = "jdbc:mysql://localhost:8889/producto7";
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

    // Función para cerrar conexión en la base de datos
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


    // Función para conectar al servidor LDAP Apache Directory Studio
    public String LdapConnection(String username, String password){
        // Return value
        String value = "";
        // Generamos tabla hash
        Hashtable<String, String> environment = new Hashtable<String, String>();
        // Seteamos la configuración LDAP
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, "uid=" + username + ",ou=users,ou=system");
        environment.put(Context.SECURITY_CREDENTIALS, password);
        // Conectamos LDAP
        try
        {
            DirContext context = new InitialDirContext(environment);
            // Confirmamos conexión por terminal
            value = "Connected";
            System.out.println(value);
            System.out.println(context.getEnvironment());
            context.close();
        }
        // Excepción
        catch (AuthenticationNotSupportedException exception)
        {
            value = "The authentication is not supported by the server";
            System.out.println(value);
        }
        // Excepción
        catch (AuthenticationException exception)
        {
            value = "Error! Usuario o contraseña incorrectos.";
            System.out.print(value);
        }
        // Excepción
        catch (NamingException exception)
        {
            value = "Error when trying to create the context";
            System.out.println(value);
        }
        // Excepción
        catch(Exception e){
            System.out.println(e);
        }
        return value;
    }

}
