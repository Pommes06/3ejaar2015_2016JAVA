package be.groept;


import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

//@MessageDriven
public class MessageBean implements MessageListener{

    @Override
    public void onMessage(Message message) {
        //hier referentie injecteren naar onze chatserver
    }
}
