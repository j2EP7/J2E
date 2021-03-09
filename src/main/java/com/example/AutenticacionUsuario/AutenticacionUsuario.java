package com.example.AutenticacionUsuario;

import java.io.*;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/AutenticacionUsuario")
public class AutenticacionUsuario extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticacionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub

        DirContext connection;

        try {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
            env.put(Context.SECURITY_PRINCIPAL, "cn=" + request.getParameter("usuario") + ",ou=users,ou=system");
            env.put(Context.SECURITY_CREDENTIALS, request.getParameter("password"));
            DirContext con = new InitialDirContext(env);
            con.close();
            response.sendRedirect("loginCorrecto.jsp");
        } catch (Exception e) {
            response.sendRedirect("loginIncorrecto.jsp");
        }
    }

}