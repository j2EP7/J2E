<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>
<%@ page import="controller.FillLetters" %>


<%--<c:set value="0" var="contador"></c:set>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <%
        int contador = 0;
        FillLetters objFill = new FillLetters();
        Random random = new Random();
        for (int i=0; i<4;i++){
    %>
    <div class="row"><%
        for (int z=0; z<12; z++){
            objFill.buffer.append(objFill.chars[random.nextInt(objFill.chars.length)]);
    %>
        <div id="<%=contador%>" class="col-1">
            <%=objFill.buffer.toString()%>
            <% contador++;%>

        </div>
        <% objFill.buffer.delete(0,objFill.buffer.length());
        }%>
    </div>
    <% } %>
</div>