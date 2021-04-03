<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controller.game" %>
<%@ page import="model.Word" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.GameDao" %>
<%@ page import="dao.FactoryDAO" %>
<%@ page import="model.Game" %>
<%@ page import="controller.game" %>
<%--
  Created by IntelliJ IDEA.
  User: esteb
  Date: 21/03/2021
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>∫
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>

${example}

    <% List<Word> words = new controller.game().printAllWords(); %>
<c:forEach var="wordValue" items="${words}">
        <li>
                ${wordValue.id}<br>
                ${wordValue.word}<br>
                ${wordValue.description}<br>
        </li>
    </c:forEach>


    <%
        GameDao gameDAO = FactoryDAO.getGameDAO();
        Game gamemodel = gameDAO.read("max_time");
        Game paramWords = gameDAO.read("words");
    %>
    <%= gamemodel %>
    Número de palabras: <%= paramWords.getValue() %>

</ul>

</body>
</html>
