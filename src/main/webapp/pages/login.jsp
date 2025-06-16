<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login</title>
            <link rel="stylesheet" href="recursos/css/login.css">
        </head>

        <body>

            <div class="pagina">

                <h1>Login</h1>

                <form id="login">

                    <img src="${pageContext.request.contextPath}/recursos/imagens/user.png">

                    <div class="credenciais">
                        <input type="text" name="nickname" placeholder="Apelido" required>
                        <input type="password" name="password" placeholder="Senha" required>
                    </div>

                    <div id="mensagem"></div>

                    <input type="submit" value="Login">

                </form>

                <script src="${pageContext.request.contextPath}/recursos/scripts/login.js"></script>

            </div>

        </body>

        </html>