<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controller.GameController" %>
<%@ page import="model.Word" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.GameDao" %>
<%@ page import="dao.FactoryDAO" %>
<%@ page import="model.Game" %>
<%@ page import="controller.GameController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Container -->
<div class="container-fluid">
    <!-- Row -->
    <div class="row">
        <!-- First Column -->
        <div class="col-12 col-md-8 d-flex flex-column min-vh-100 justify-content-center align-items-center">
            <!-- H1 -->
            <h1>${param.title}</h1>


            <!-- Pruebas -->
 <%--           <br>
            <ul>
                ${example}
                <% List<Word> words = new GameController().printAllWords(); %>
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
            </ul>--%>

            <!-- Casillero -->
            <div id="game"></div>

            <!-- Cargamos funciones js -->
            <script src="${pageContext.request.contextPath}/assets/js/functions.js" /></script>

            <!-- botón jugar que dispara función js para cargar la sopa de letras -->
            <button id="play" type="button" class="btn btn-primary" onclick="play()">Jugar</button>



        <%-- <jsp:include page="copyright.jsp">
            </jsp:include>--%>


            <!-- End column -->
        </div>

        <!-- Second Column -->
        <div class="col-12 col-md-4 sidebar-bg-color d-flex flex-column min-vh-100 justify-content-center align-items-center">
            <div>
                <p>Aprende un poco más de Java jugando</p>
                <div id="gameInfo" class="esconder">
                    <div id="parentTime">
                        <h2>Tiempo restante</h2>
                        <div id="time"></div>
                    </div>
                    <br><br>
                    <h2>Palabras</h2>
                    <div id="words"></div>
                </div>
                <br><br>
                <div id="gameInstructions">
                    <h2>Instrucciones</h2>
                    <ul>
                        <li>Busca las palabras</li>
                        <li>Vigila el tiempo</li>
                        <li>Pulsa en las letras</li>
                        <li>No te rindas</li>
                        <li>Encuéntralas todas</li>
                        <li>¡Hay recompensa!</li>
                    </ul>
                </div>
                <!-- Copyright -->
                <p class="copyright">Hecho con amor y café por J2E</p>
            </div>
            <!-- End column -->
        </div>
        <!-- End Row -->
    </div>
    <!-- End Container -->
</div>

