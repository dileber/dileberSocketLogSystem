package com.drcosu.mianbaopai.scoket;

import org.apache.commons.collections.MapUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.mail.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.Yangxiufeng on 2016/5/27.
 * 09
 * 23
 * SpringWebApp
 */
public class AnalysisWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        //记录连接的session
        if(userId!=null){
            WebSocketSessionUtils.add(userId,session);
        }else{
            WebSocketSessionUtils.add(WebSocketSessionUtils.getUserId(session),session);
        }

    }




    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        System.out.println("handleTextMessage");
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        if(userId==null){
            userId = WebSocketSessionUtils.getUserId(session);
        }
        String partnerInfo = MapUtils.getString(session.getAttributes(),"partnerInfo");
        if (null != partnerInfo){
            //TODO 进行配对
        }else{
            //TODO 处理其他消息
            TextMessage returnMessage = new TextMessage("日志:"+userId+":"+message.getPayload());
            WebSocketSessionUtils.sendMessageToLog(userId,returnMessage);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
        System.out.println("handleTransportError");
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        if(userId==null){
            userId = WebSocketSessionUtils.getUserId(session);
        }
        WebSocketSessionUtils.remove(userId);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("afterConnectionClosed");
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        if(userId==null){
            userId = WebSocketSessionUtils.getUserId(session);
        }
        WebSocketSessionUtils.remove(userId);
    }
}
