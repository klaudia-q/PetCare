package com.pracazaliczeniowa.pracazaliczeniowa.config;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

public class NotificationHandler extends TextWebSocketHandler {

    private static final Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        session.sendMessage(new TextMessage(" Połączono z WebSocket!"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Odbieranie wiadomości od klienta
        System.out.println(" Otrzymano wiadomość: " + message.getPayload());

        // Wysyłanie odpowiedzi do wszystkich klientów
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage(" Nowa wiadomość: " + message.getPayload()));
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }

    public static void sendNotification(String notification) throws Exception {
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage(" Powiadomienie: " + notification));
            }
        }
    }
}
