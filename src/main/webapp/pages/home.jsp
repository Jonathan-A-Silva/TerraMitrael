<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Inicio</title>
            <link rel="stylesheet" href="recursos/css/home.css">
        </head>

        <body>

            <header>
                <jsp:include page="navbar.jsp" />
            </header>

            <div class="pagina">

            </div>

            <c:if test="${not empty sessionScope.User}">
                <script src="${pageContext.request.contextPath}/recursos/scripts/startgame.js"></script>
            </c:if>

        </body>

        </html>