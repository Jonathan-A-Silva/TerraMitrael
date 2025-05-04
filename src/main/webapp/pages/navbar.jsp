<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
            <title>Navbar</title>
        </head>

        <body>
            <div class="navbar">

                <button type="button" class="menu">☰</button>

                <div class="login">
                    <c:choose>
                        <c:when test="${not empty sessionScope.User}">
                            <a href="${pageContext.request.contextPath}/perfil">
                                <img src="${pageContext.request.contextPath}/show-user-image" alt="User-Image">
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/login">Login</a>
                            <a href="${pageContext.request.contextPath}/register">Cadastro</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <div class="menu-hamburger">
                <ul>
                    
                    <li><a href="${pageContext.request.contextPath}">Home</a></li>
                    
                    <c:choose>
                        <c:when test="${not empty sessionScope.User}">
                            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        </c:when>
                    </c:choose>

                </ul>
                
            </div>

            <script src="${pageContext.request.contextPath}/recursos/scripts/navbar.js"></script>

        </body>

        </html>