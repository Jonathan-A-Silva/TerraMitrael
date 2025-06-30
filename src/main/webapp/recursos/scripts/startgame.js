document.addEventListener("DOMContentLoaded", function () {
    const socket = new WebSocket("ws://localhost:8080/TerrasMitrael/game");

    socket.onopen = () => {
        console.log("✅ Conectado ao WebSocket /game");
    };

    socket.onmessage = (event) => {
        console.log("📨 Mensagem do servidor:", event.data);
    };

    socket.onclose = () => {
        console.log("🔌 WebSocket desconectado.");
    };

    socket.onerror = (err) => {
        console.error("❌ Erro no WebSocket:", err);
    };

});