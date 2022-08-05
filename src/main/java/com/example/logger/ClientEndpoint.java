package com.example.logger;

import java.util.logging.Logger;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;

@javax.websocket.ClientEndpoint
public class ClientEndpoint {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @OnOpen
    public String onOpen(Session session) {
        logger.info("Connected!");

        try {
            session.getBasicRemote().sendText("start");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Connected!";
    }


//    @OnMessage
//    public String onMessage(String message, Session session) {
//        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            logger.info("Received ...." + message);
//            String userInput = bufferRead.readLine();
//            return userInput;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//    @OnClose
//    public void onClose(Session session, CloseReason closeReason) {
//        logger.info(String.format("Session %s close because of %s", session.getId(), closeReason));
//    }
}
