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
import model.enums.Presence;
import util.HttpSessionConfigurator;

@ServerEndpoint(value = "/game", configurator = HttpSessionConfigurator.class)
public class GameWebSocket {
    private static final Map<String, Session> sessions = Collections.synchronizedMap(new HashMap<>());
    private static final Gson gson = new Gson();
    private static final UserDAO userDAO = new UserDAOImpl();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSessionConfigurator.HTTP_SESSION);

        if (httpSession == null || httpSession.getAttribute("User") == null) {
            session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "Usuário não autenticado"));
            return;
        }

        User sessionUser = (User) httpSession.getAttribute("User");
        User user = userDAO.getUserForId(sessionUser.getId());

        if(!user.credentialsEquals(sessionUser)){
            session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "Violação de integridade detectada."));
            return;
        }

        user.setPresence(Presence.ONLINE);
        userDAO.updateUser(user);
        session.getUserProperties().put("userId", user.getId());
    }

    @OnClose
    public void onClose(Session session) {
        Long userId = (Long) session.getUserProperties().get("userId");
        if (userId != null) {
            User user = userDAO.getUserForId(userId);
            if (user != null) {
                user.setPresence(Presence.OFFLINE);
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

    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        sessions.values().remove(session);
        throwable.printStackTrace();
    }
}