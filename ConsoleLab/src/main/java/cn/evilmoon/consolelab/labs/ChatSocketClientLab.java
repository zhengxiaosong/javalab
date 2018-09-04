package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * cn.evilmoon.springlab.websocket.ChatSocket 的客户端
 */
@TimeTag("2018-09-04 21:16")
public class ChatSocketClientLab implements Lab {
    @Override
    public void run(String[] args) {
        try {
            client = new WebSocketClient(new URI("ws://localhost:8080/chat"),new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("握手成功");
                }

                @Override
                public void onMessage(String msg) {
                    System.out.println("收到消息=========="+msg);
                    if(msg.equals("over")){
                        client.close();
                    }

                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("链接已关闭");
                }

                @Override
                public void onError(Exception e){
                    e.printStackTrace();
                    System.out.println("发生错误已关闭");
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        client.connect();
        System.out.println(client.getDraft());
        while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            System.out.println("正在连接...");
        }
        //连接成功,发送信息
        client.send("哈喽,连接一下啊");

    }

    private WebSocketClient client;
}
