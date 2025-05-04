<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:url value="/" var="baseHref" />

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Cadastro</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/cadastro.css">
        </head>

        <body>
            <div class="pagina">
                <h1>Cadastro</h1>

                <form id="cadastro">
                    <div class="credenciais">
                        <input type="text" name="nickname" placeholder="Apelido" />
                        <input type="password" name="password" placeholder="Senha" />
                    </div>

                    <div id="mensagem"></div>

                    <input type="submit" value="Cadastrar" />
                </form>

                <script src="${pageContext.request.contextPath}/recursos/scripts/register.js"></script>
            </div>
        </body>

        </html>