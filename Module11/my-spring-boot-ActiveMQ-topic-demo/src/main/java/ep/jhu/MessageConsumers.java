package ep.jhu;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumers {

    @JmsListener(destination = "784.topic.example", containerFactory = "topicListenerFactory")
    public void receiveMessage1(String message) {System.out.println("Received message on Subscriber 1: " + message);}

    @JmsListener(destination = "784.topic.example", containerFactory = "topicListenerFactory")
    public void receiveMessage2(String message) {System.out.println("Received message on Subscriber 2: " + message);}

    @JmsListener(destination = "784.topic.example", containerFactory = "topicListenerFactory")
    public void receiveMessage3(String message) {System.out.println("Received message on Subscriber 3: " + message);}
}
