<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Autenticacion Usuario</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Autenticación Usuario</h1>
<br/>
<form name="form1" method="post" action="AutenticacionUsuario">
    <input type="hidden" name="oculto" value="valorOculto">
    <table witdh="200" id="one-column-emphasis">
        <caption>
            Formulario de Autenticación
        </caption>
        <tr>
            <td class="oce-first">
                Usuario:
            </td>
            <td>
                <input class="default" type="text" name="usuario"/>
            </td>
        </tr>
        <tr>
            <td class="oce-first">
                Password:
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