/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import com.sun.xml.ws.runtime.dev.SessionManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Vaidehi Soni
 */
@ServerEndpoint("/hello")
public class SocketEndPoint {

    
    private static Set<Session> socketSessions;

    @OnOpen
    public void onopen(Session session) {

        socketSessions = session.getOpenSessions();
        System.out.println("Session opened, id: "+ session.getId());
        
        for(Session s: socketSessions){
            System.out.println(s.getId());
        }
        
    }

    @OnMessage
    public void onmessage(String message, Session session) {
        System.out.println("Message received. Session id:"+session.getId()+" Message: " + message);
        socketSessions = session.getOpenSessions();
        try {
            for(Session s: socketSessions){
                if(!s.getId().equals(session.getId())){
                    s.getBasicRemote().sendText(message);
                }
                
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnError
    public void onerror(Throwable e) {
        e.printStackTrace();
    }

    @OnClose
    public void onclose(Session session) {
        socketSessions = session.getOpenSessions();
        
        for(Session s: socketSessions){
            System.out.println(s.getId());
        }
        System.out.printf("Session closed with id: %s%n", session.getId());
    }
}
