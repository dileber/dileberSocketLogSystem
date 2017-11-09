package com.drcosu.mianbaopai.scoket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mr.Yangxiufeng on 2016/5/30.
 * Time:14:01
 * ProjectName:SpringWebApp
 */
public class WebSocketSessionUtils {
    private static Map<String,WebSocketSession> clients = new ConcurrentHashMap<String, WebSocketSession>();

    /**
     * <p>记录一个连接</p>
     * @param userId
     * @param webSocketSession
     */
    public static void add(String userId,WebSocketSession webSocketSession){
        if (clients.containsKey(userId)){
            clients.remove(userId);
        }
        clients.put(userId, webSocketSession);
    }

    /**
     * <p>通过id获取连接</p>
     * @param userId
     * @return
     */
    public static WebSocketSession get(String userId){
        return clients.get(userId);
    }

    /**
     * <p>移除连接</p>
     * @param userId
     */
    public static void remove(String userId){
        if(clients.containsKey(userId)){
            clients.remove(userId);
        }
    }
    public static int size(){
        return clients.size();
    }
    public static void sendMessageToTarget(String userId,TextMessage message){
        WebSocketSession webSocketSession = clients.get(userId);
        sendMessage(message, webSocketSession);
    }

    public static void sendMessageToLog(String userId,TextMessage message){
        if(clients.containsKey("log"+userId)){
            WebSocketSession webSocketSession = clients.get("log"+userId);
            sendMessage(message, webSocketSession);
        }else {
            System.out.println("无法获取日志，未注册");
        }

    }

    private static void sendMessage(TextMessage message, WebSocketSession webSocketSession) {
        if (webSocketSession != null){
            if (webSocketSession.isOpen()){
                try {
                    webSocketSession.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendMessageToAllTarget(TextMessage message){
        Iterator iterator = clients.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry enter = (Map.Entry) iterator.next();
            WebSocketSession ws = clients.get(enter.getKey());
            sendMessage(message,ws);
        }
    }

    public static Map<String, String> toMap(String url) {
        Map<String, String> map = new HashMap<String, String>();
        String[] qs = url.split("=");
        map.put(qs[0], qs[1]);
        return map;
    }

    public static String getUserId(WebSocketSession session) {
        if(session instanceof StandardWebSocketSession){
            StandardWebSocketSession s = (StandardWebSocketSession)session;
            javax.websocket.Session m =  s.getNativeSession();

            String queryString =m.getQueryString();
            String qs = toMap(queryString).get("userId");
            return qs;
        }
        return null;
    }




}
