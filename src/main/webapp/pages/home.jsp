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

<c:if test="${not empty sessionScope.User}">
    <script>
        const socket = new WebSocket("ws://localhost:8080/TerrasMitrael/game");

        socket.onopen = () => {
            console.log("✅ Conectado ao WebSocket /game");
        };

        socket.onmessage = (event) => {
            console.log("📨 Mensagem do servidor:", event.data);
            if (event.data.startsWith("REDIRECT:")) {
                window.location.href = event.data.replace("REDIRECT:", "");
            }
        };

        socket.onclose = () => {
            console.log("🔌 WebSocket desconectado.");
        };

        socket.onerror = (err) => {
            console.error("❌ Erro no WebSocket:", err);
        };
    </script>
</c:if>

            </div>

        </body>

        </html>