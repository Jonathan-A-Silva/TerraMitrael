package control.websockt.game;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.entities.persistence.user.User;
import model.enums.Materials.Presence;
import util.HttpSessionConfigurator;

@ServerEndpoint(value = "/game", configurator = HttpSessionConfigurator.class)public class GameWebSocket {
    private static final Map<String, Session> sessions = Collections.synchronizedMap(new HashMap<>());
    private static final Gson gson = new Gson();
    private static UserDAO userDAO = new UserDAOImpl();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSessionConfigurator.HTTP_SESSION);

        if (httpSession == null
                || httpSession.getAttribute("User") == null) {
            return;
        }

        User user = (User) httpSession.getAttribute("User");
        user.setPresence(Presence.ONLINE);
        userDAO.updateUser(user);
        sessions.put(String.valueOf(user.getId()), session);
        session.getUserProperties().put("userId", user.getId());

    }

    @OnClose
    public void onClose(Session session) {
        String userId = (String) session.getUserProperties().get("userId");
        if (userId != null) {
            User user = userDAO.getUserForId(Long.valueOf(userId));
            if (user != null) {
                user.setPresence(Presence.AWAY);
                userDAO.updateUser(user);
            }
            sessions.remove(userId);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try {

        } catch (Exception e) {

        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        sessions.values().remove(session);
        throwable.printStackTrace();
    }

    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}