package controller;

import dao.DAOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.*;
import javax.naming.ldap.*;
import javax.naming.directory.*;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.println(request.getParameter("username"));

        Hashtable<String, String> environment = new Hashtable<String, String>();

        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, "uid=" + request.getParameter("username") + ",ou=users,ou=system");
        environment.put(Context.SECURITY_CREDENTIALS, request.getParameter("password"));

        try
        {
            DirContext context = new InitialDirContext(environment);

            System.out.println("Connected");
            // out.println("Conectado usuario " + request.getParameter("username"));
            // response.getWriter().append("Conectado en: ").append(request.getContextPath());

            // Attributes attrs = context.getAttributes("dc=example,dc=com");
            // System.out.println("ALL Data: " + attrs.toString());

            System.out.println(context.getEnvironment());
            context.close();
            /*request.setAttribute("words", new controller.game().printAllWords());
            request.getRequestDispatcher("game.jsp").forward(request, response);*/
       /*     RequestDispatcher rd=request.getRequestDispatcher("servlet2");
            rd.forward(request, response);*/
            response.sendRedirect("play.jsp");

        }
        catch (AuthenticationNotSupportedException exception)
        {
            System.out.println("The authentication is not supported by the server");
        }

        catch (AuthenticationException exception)
        {

            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
            out.print("Error! Usuario o contraseña incorrectos.");
            rd.include(request, response);
            //response.sendRedirect("index.jsp?result=failed");
            // System.out.println("Incorrect password or username");
        }

        catch (NamingException exception)
        {
            System.out.println("Error when trying to create the context");
        } /*catch(ServletException e) {
            e.printStackTrace();
        }catch (DAOException e) {
            e.printStackTrace();
        }*/catch(Exception e){
            System.out.println(e);
        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


    public void destroy() {
    }
}