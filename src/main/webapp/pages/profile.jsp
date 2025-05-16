<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Profile</title>
        </head>

        <body>

            <header>
                <jsp:include page="navbar.jsp" />
            </header>

            <div class="pagina">

                <div class="profile">
                    
                    <div class="profile-img">
                        <img src="${pageContext.request.contextPath}/show-user-image-nickname?nickname=${user.nickname}" alt="profile">
                    </div>

                    <p>${user.nickname}</p>

                </div>

            </div>

        </body>

        </html>