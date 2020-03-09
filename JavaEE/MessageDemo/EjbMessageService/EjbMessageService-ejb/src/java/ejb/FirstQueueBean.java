/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.*;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/itqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FirstQueueBean implements MessageListener {
    
    private static final Logger LOG=Logger.getLogger(FirstQueueBean.class.getName());
    public FirstQueueBean() {
        
    }
    
    @Override
    public void onMessage(Message message) {
        
        if(message instanceof TextMessage){
            try{
                String content = (String)((TextMessage) message).getText();
                System.out.println("The Queue message is ="+ content);
                LOG.fine(content);
            
            }catch(JMSException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
