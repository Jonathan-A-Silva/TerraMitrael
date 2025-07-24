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
            
            <div class="pagina">

                <form action="${pageContext.request.contextPath}/register-user-person" method="post">
                    <h2>Cadastro de Personagem</h2>

                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="first-name" placeholder="Nome" />
                    <label for="sobrenome">Sobrenome:</label>
                    <input type="text" id="sobrenome" name="last-name" placeholder="Sobrenome" />

                    <div class="classe-form">
                        <h3>Classes</h3>

                        <c:forEach var="classe" items="${classes}">
                            <div class="classe-tab">
                                <label for="classe">${classe.getNome()}</label>
                                <div>
                                    <label for="classe-descricao">Descrição da Classe</label>
                                    <p>${classe.getDescricao()}</p>
                                </div>
                            </div>
                        </c:forEach>

                        <input type="hidden" name="person-classe" id="classe" value="${classes[0].name()}"/>

                        <div class="botoes-classes">
                            <button type="button" class="volta-classe">Voltar</button>
                            <button type="button" class="proxima-classe">Avançar</button>
                        </div>
                    </div>

                    <div class="menu-races">
                        <h3>Raça</h3>
                        <c:forEach var="race" items="${races}">
                            <div class="race-tab">
                                <label for="race">${race.getNome()}</label>
                                <div>
                                    <label for="classe-descricao">Descrição da Raça</label>
                                    <p>${race.getDescricao()}</p>
                                </div>
                            </div>
                        </c:forEach>

                        <input type="hidden" name="person-race" id="race" value="${races[0].name()}"/>

                        <div class="botoes-race">
                            <button type="button" class="volta-race">Voltar</button>
                            <button type="button" class="proxima-race">Avançar</button>
                        </div>

                    </div>

                    <script src="${pageContext.request.contextPath}/recursos/scripts/register-person.js"></script>

                    <input type="submit" value="Criar Personagem" />
                </form>

            </div>
        </body>

        </html>