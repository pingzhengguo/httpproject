package com.pzg.code.httpproject.test;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.Socket;
import java.net.URI;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestWebSocket {


    public WebSocketClient client;

    @Test
    public void test() throws Exception {
        URI uri = new URI("http://api.91ganlu.com/webSocket/msg?accessToken=a9c8866a8b4b4e3480dcffc2cdcb39fb&sn=BB0201C0010C3107");
        // {"accessToken":"a9c8866a8b4b4e3480dcffc2cdcb39fb","sn":"BB0201C0010C3107"}
        client = new WebSocketClient(uri, new Draft_6455()) {//
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("握手成功");
            }

            @Override
            public void onMessage(String msg) {
                System.out.println("收到消息:" + msg);
                if (msg.equals("over")) {
                    client.close();
                }
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("连接已经关闭");


            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
                System.out.println("发生错误,连接关闭");
            }
        };

        Socket socket = new Socket();

        client.setSocket(socket);

        client.connect();
        System.out.println("draft:" + client.getDraft());
        int i = 0;
        while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
            System.out.println("正在连接:" + i);
            i++;
        }

        //连接成功,//发送信息


    }


}
