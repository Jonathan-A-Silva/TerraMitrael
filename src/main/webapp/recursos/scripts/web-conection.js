function getWebSocketProtocol() {
    return location.protocol === 'https:' ? 'wss' : 'ws';
}

function getBasePath() {
    const segments = location.pathname.split('/');
    return segments.length > 1 ? `/${segments[1]}` : '';
}

export function getWebSocketUrl() {
    const protocol = getWebSocketProtocol();
    const host = location.host;
    const basePath = getBasePath();
    return `${protocol}://${host}${basePath}/game`;
}