<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Profile</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/register-person.css">
        </head>

        <body>

            <header>
                <jsp:include page="navbar.jsp" />
            </header>

            <form>
                <h2>Cadastro de Personagem</h2>

                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" placeholder="Nome" required />

                <label for="sobrenome">Sobrenome:</label>
                <input type="text" id="sobrenome" name="sobrenome" placeholder="Sobrenome" />

                <div class="menu-classes">
                    <h3>Classes:</h3>

                    <c:forEach var="classe" items="${classes}">
                        <div class="classe-tab">
                            <label for="classe">${classe.getNome()}</label>
                            <div>
                                <label for="classe-descricao">Descrição da Classe</label>
                                <p>${classe.getDescricao()}</p>
                            </div>
                        </div>
                    </c:forEach>

                    <script src="${pageContext.request.contextPath}/recursos/scripts/register-person.js"></script>
                </div>

                <div>
                    <h3>Raça:</h3>

                    <c:forEach var="race" items="${races}">
                        <label for="race">${race.getNome()}</label>
                        <div>
                            <label for="classe-descricao">Descrição da Raça</label>
                            <p>${race.getDescricao()}</p>
                        </div>
                    </c:forEach>
                </div>

                <input type="submit" value="Criar Personagem" />
            </form>

        </body>

        </html>