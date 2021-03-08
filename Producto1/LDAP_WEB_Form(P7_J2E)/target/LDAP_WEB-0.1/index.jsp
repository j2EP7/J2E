<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body{
            margin-left:35%;
            background: wheat;
        }
        input[type="text"],input[type="password"]{
            background: azure;
            border: none;
            border-bottom: 1px;
            color:#000078;
            font-family: Arial;
            font-weight: bold;
            margin: 4px;
        }
        label{
            font-weight: bolder;
            margin-right: 11%;
        }
        hr{
            width: 30%;
            margin-left:-0.1%;
        }
        h1{
            margin-left: -9%;
        }

    </style>
</head>
<body>
    <h1><%= "LDAP_JavaEE_P7_J2E_Form" %>
    </h1>

    <form method="post" action="hello-servlet">
        <label>Nombre de Usuario</label><p></p><input type="text" name="usuario"></p>
        <label>Domain\user (ejemplo => uoc\arrojorge</label><p><input type="text" name="user"></p>
        <label>Password LDAP del Usuario</label><p><input type="password" name="password"></p>
        <label>IP:Puerto (ejemplo 192.168.1.14:389</label><p><input type="text" name="ip"></p>
        <label>dc1(dominio inferior)</label><p><input type="text" name="dc1"></p>
        <label>dc2(dominio intermedio)</label><p><input type="text" name="dc2"></p>
        <label>dc3(dominio superior)</label><p><input type="text" name="dc3"></p>
        <hr>
        <input type="submit">
    </form>

</body>
</html>