package com.example.logger;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.websocket.Session;
import java.net.http.WebSocket;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoggerApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Test
    public void Connect_Websocket_return_OK() {
        String username = "Getsby";
        String expected = "Connected!";

        ClientEndpoint clientEndpoint = new ClientEndpoint();
        Session session = null;
        String answer = clientEndpoint.onOpen(session);

        assert answer.equals(expected);
    }
}
