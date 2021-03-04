<%-- 
    Document   : index
    Created on : 1 mar. 2021, 13:55:35
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="logica.gestion" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Formulario de acceso</h1>
        <form method="POST" action="gestion">
            <label>Nombre<input  name="nombre" type="text"></label><br>
            <label>PassWord<input name="password" type="password"></label>
            <input type="submit">
        </form>
    </body>
</html>
