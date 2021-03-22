package com.p7.web.ldaplogin.servlet;

import java.io.IOException;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LdapLogin
 */

public class LdapLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LdapLogin() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Hashtable<String, String> environment = new Hashtable<String, String>();

	        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	        environment.put(Context.PROVIDER_URL, "ldap://localhost:10389");
	        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
	        environment.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
	        environment.put(Context.SECURITY_CREDENTIALS, "secret");

	        try 
	        {
	            DirContext context = new InitialDirContext(environment);
	            System.out.println("Connected");
	    		response.getWriter().append("Conectado en: ").append(request.getContextPath());

	            System.out.println(context.getEnvironment());
	            context.close();
	        } 
	        catch (AuthenticationNotSupportedException exception) 
	        {
	            System.out.println("The authentication is not supported by the server");
	        }

	        catch (AuthenticationException exception)
	        {
	            System.out.println("Incorrect password or username");
	        }

	        catch (NamingException exception)
	        {
	            System.out.println("Error when trying to create the context");
	        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
