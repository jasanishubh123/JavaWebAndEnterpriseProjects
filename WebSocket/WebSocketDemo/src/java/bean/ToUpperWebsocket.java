/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;




import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;

@ServerEndpoint("/toUpper")
public class ToUpperWebsocket {

        private static Set<Session> socketSessions;


  @OnOpen
  public void onOpen(Session session) {
//    LOGGER.debug(String.format("WebSocket opened: %s", session.getId()));
  }

  @OnMessage
  public void onMessage(String txt, Session session) throws IOException {
//    LOGGER.debug(String.format("Message received: %s", txt));
    //session.getBasicRemote().sendText(txt.toUpperCase());
    socketSessions = session.getOpenSessions();
        try {
            for(Session s: socketSessions){
//                if(!s.getId().equals(session.getId())){
//                    s.getBasicRemote().sendText(txt);
//                }
               s.getBasicRemote().sendText(txt);

                
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
  }

  @OnClose
  public void onClose(CloseReason reason, Session session) {
//    LOGGER.debug(String.format("Closing a WebSocket (%s) due to %s", session.getId(), reason.getReasonPhrase()));
  }

  @OnError
  public void onError(Session session, Throwable t) {
      t.printStackTrace();
//    LOGGER.error(String.format("Error in WebSocket session %s%n", session == null ? "null" : session.getId()), t);
  }
}