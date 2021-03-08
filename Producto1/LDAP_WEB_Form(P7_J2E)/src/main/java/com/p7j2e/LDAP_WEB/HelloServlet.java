package com.p7j2e.LDAP_WEB;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


//Librerias LDAP

import javax.naming.ldap.LdapContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.directory.SearchResult;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String DC;
    private String user;
    private String userDomain;
    private String password;
    private String ip;
    private String usuario;
    private String dc1;
    private String dc2;
    private String dc3;


    public void init() {

    }


    public void destroy() {
    }

    public void dataToShowComplete(String s){
        this.message=message+s;


    }

    public void conect(){
        Auth auth = new Auth(this.userDomain,this.password,this.ip);
        LdapContext ctx = null;
        try {
            ctx = new InitialLdapContext(auth.env,null);


            //objeto SearchCOntrol que busca en el scope del arbol la entidad root del nombre del objeto
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            //Cadena de filtro para decir que estamos buscando un usuario con nombre de cuenta tal
            String searchFilter = "(&(objectClass=user)(sAMAccountName="+usuario+"))";
            //Cadena de dominio a conectar
            String ldapSearchBase = "DC="+dc1+", "+"DC="+dc2+", "+"DC="+dc3;



            //Enumeracion de tipo SearchResult donde le decimos que busque en la conexión LDAP con dominio, usuario filtrado, en ese árbol
            NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);
            //reservamos variable
            SearchResult searchResult = null;
            while (results.hasMoreElements()) {
                // Guardamos un elemento y
                searchResult = (SearchResult) results.nextElement();

                //Generamos une enumeracion NAMING parametrizada con String del elemento iterado obteniendo de sus atributos su ID
                NamingEnumeration<String> var = searchResult.getAttributes().getIDs();

                String prop;
                String looking_user="displayName";
                String looking_DC="objectCategory";
                //Mientrsa la enumeración de NAMING tenga elementos...
                while (var.hasMoreElements()) {
                    /* Guardar como String ese elemento iterado de la enumeración parametriza <String> como una cadena */
                    prop = var.next();

                    /*Buscamos en la salida completa los datos de usuario y el Dominio de conexión */
                   if (prop.contains(looking_user)){
                        //usuario
                        this.showUser("Nombre de usuario: "+ searchResult.getAttributes().get(prop).get());
                    }
                    if (prop.contains(looking_DC)){
                        //dominio
                        this.showDC("Dominio: "+ searchResult.getAttributes().get(prop).get());
                    }
                    this.dataToShowComplete(prop+" %" + searchResult.getAttributes().get(prop).get()+"\n");
                }
            }

        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//conect()

    private void showUser(String s) {
        this.user = s;
    }
    private void showDC(String s) {
        this.DC = s;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        this.userDomain=request.getParameter("user");
        this.password=request.getParameter("password");
        this.ip=request.getParameter("ip");
        this.usuario=request.getParameter("usuario");
        this.dc1=request.getParameter("dc1");
        this.dc2=request.getParameter("dc2");
        this.dc3=request.getParameter("dc3");

        conect();

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                    "<meta charset="+"utf-8" + "</meta>"+
                    "<title>Servlet LDAP P7-J2E</title>" +
                "</head>" +
                "<body>");
        out.println("<h1> Servlet de Conexión LDAP _ FORM </h1>");
        out.println("<h4>Datos introducidos en formulario: </h4>");
        out.println("<p>Dominio LDAP: "+this.userDomain+" </p>");
        out.println("<p>Password del usuario: "+this.password+"</p>");
        out.println("<p>Nombre de Usuario: "+this.usuario+"</p>");
        out.println("<p>dc1: "+this.dc1+"</p>");
        out.println("<p>dc2: "+this.dc2+"</p>");
        out.println("<p>dc3: "+this.dc3+"</p>");
        if(this.message !=null) {
            out.println("<h3> Conectado: </h3>");
            out.println("<p>"+this.user + "</p>");
            out.println("<p>"+this.DC+"</p>");
            out.println("<br><br><br><br><hr>");
            out.println("<h4>Datos globales de conexión</h4>");
            out.println(this.message);//faltaría dar formato correcto de salida printf
        }else{
            out.println("<h4> No ha sido posible la conexión: </h4>" +
                    "<p>Pruebe desplegando nuevamente la aplicación e introducciendo nuevos datos</p>");
        }
    }

}