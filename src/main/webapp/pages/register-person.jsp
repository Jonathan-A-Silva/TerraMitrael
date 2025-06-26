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
            <form id ="register-persom>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" required /><br /><br />

                <label for="classe">Classe:</label>
                <div>
                    <label>Classe:</label><br />
                    <input type="checkbox" id="classe-guerreiro" name="classe" value="Guerreiro" />
                    <label for="classe-guerreiro">Guerreiro</label><br />
                    <input type="checkbox" id="classe-mago" name="classe" value="Mago" />
                    <label for="classe-mago">Mago</label><br />
                    <input type="checkbox" id="classe-arqueiro" name="classe" value="Arqueiro" />
                    <label for="classe-arqueiro">Arqueiro</label><br /><br />
                </div>
                <div>
                    <label>Raça:</label><br />
                    <input type="checkbox" id="raca-humano" name="raca" value="Humano" />
                    <label for="raca-humano">Humano</label><br />
                    <input type="checkbox" id="raca-elfo" name="raca" value="Elfo" />
                    <label for="raca-elfo">Elfo</label><br />
                    <input type="checkbox" id="raca-anao" name="raca" value="Anão" />
                    <label for="raca-anao">Anão</label><br /><br />
                </div>

                <label for="raca">Raça:</label>
                <input type="text" id="raca" name="raca" required /><br /><br />

                <input type="submit" value="Criar Personagem" />
            </form>
        </body>
        </html>