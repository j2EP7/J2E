<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controller.game" %>
<%@ page import="model.Word" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.GameDao" %>
<%@ page import="dao.FactoryDAO" %>
<%@ page import="model.Game" %>
<%@ page import="controller.game" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Container -->
<div class="container-fluid h-100">
    <!-- Row -->
    <div class="row h-100">
        <!-- First Column -->
        <div class="col-12 col-md-8 align-self-center">
            <!-- H1 -->
            <h1>${param.title}</h1>
            <!-- Conten -->
            <br>

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

            <div id="game"></div>

            <!-- Cargamos funciones js -->
            <script src="${pageContext.request.contextPath}/assets/js/functions.js" /></script>

            <!-- botón jugar que dispara función js para cargar la sopa de letras -->
            <button type="button" class="btn btn-primary" onclick="play()">Jugar</button>


        </div>
        <!-- Second Column -->
        <div class="col-12 col-md-4 align-self-end vh-100 sidebar-bg-color">
            Listado de palabras a encontrar
            <div id="listLetters"></div>
        </div>
        <!-- End Row -->
    </div>
    <!-- End Container -->
</div>

