
<%
    // Si el usuario no está logueado redirigimos a la portada
    session=request.getSession(false);
    if(session.getAttribute("login")==null)
    {
        response.sendRedirect("index.jsp");
    }

%>

<jsp:include page="templates/template.jsp">
    <jsp:param name="content" value="play"/>
    <jsp:param name="title" value="Sopa de letras"/>
</jsp:include>