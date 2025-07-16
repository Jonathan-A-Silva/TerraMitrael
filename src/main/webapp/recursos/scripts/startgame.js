import { getWebSocketUrl } from './websocket-utils.js';

document.addEventListener("DOMContentLoaded", function () {
    
    const socket = new WebSocket(getWebSocketUrl());

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