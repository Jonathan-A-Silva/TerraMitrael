<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Profile</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/profile.css">
        </head>

        <body>

            <header>
                <jsp:include page="navbar.jsp" />
            </header>

            <div class="pagina">

                <div class="profile">

                    <c:choose>
                        <c:when
                            test="${not empty sessionScope.User && sessionScope.User.nickname == userprofile.nickname}">
                            <input type="button" value="Edit" id="edit-button">
                        </c:when>
                    </c:choose>

                    <form id="profile-form" enctype="multipart/form-data" method="post">
                        <div class="profile-layout">
                            <div id="mensagem"></div>
                            <img src="${pageContext.request.contextPath}/show-user-image-nickname?nickname=${userprofile.nickname}" alt="profile">
                            <input type="file" id="image" name="profile-image" style="visibility: hidden;">
                            <input type="text" id="p-ninkname" name="profile-nickname" value="${userprofile.nickname}" readonly>
                            <input type="text" id="input-ninkname" name="profile-nickname-edit" value="${userprofile.nickname}">
                        </div>
                    </form>

                </div>

            </div>

            <script src="${pageContext.request.contextPath}/recursos/scripts/profile.js"></script>

        </body>

        </html>