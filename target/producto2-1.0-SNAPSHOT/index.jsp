<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sopa de letras</title>
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
</head>
<body>
<h1><%= "Inicio de sesión LDAP" %>
</h1>
<br/>
<form name="form1" method="post" action="login">

    <table witdh="200" id="one-column-emphasis">
        <caption>
            Formulario de Autenticación LDAP
        </caption>
        <tr>
            <td class="oce-first">
                Usuario:
            </td>
            <td>
                <input class="default" type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td class="oce-first">
                Contraseña:
            </td>
            <td>
                <input class=default type="password" name="password"/>
            </td>
        </tr>
        <tr style="text-align: center;">
            <td>
                <input type="submit" value="Login" class="default"/>
            </td>
            <td>
                <input type="reset" value="Limpiar" class="default"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>