<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controller.game" %>
<%@ page import="model.Word" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.GameDao" %>
<%@ page import="dao.FactoryDAO" %>
<%@ page import="model.Game" %>
<%@ page import="controller.game" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
<div id="config"></div>

<div id="game"></div>

<h2 id="uno"></h2>

<!-- Cargamos funciones js -->
<script src="${pageContext.request.contextPath}/assets/js/functions.js" /></script>

<!-- botón jugar que dispara función js para cargar la sopa de letras -->
<input type="button" value="Jugar" onclick="play()">

