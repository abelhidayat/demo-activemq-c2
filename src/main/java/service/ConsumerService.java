package service;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerService {
    private static long count = 0;

    public ConsumerService() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

        //Create Connection
        Connection connection = factory.createConnection();

        // Start the connection
        connection.start();

        // Create Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination queue = session.createQueue("FooQueue");

//        Destination topic = session.createTopic("fooTopic");

        MessageConsumer consumer = session.createConsumer(queue);
//        MessageConsumer consumerTopic = session.createConsumer(topic);

        consumer.setMessageListener(new HelloWorldListener());
    }

    private static class HelloWorldListener implements MessageListener {

        @Override
        public void onMessage(Message message) {
            TextMessage textMessage = (TextMessage) message;
            try {
                Thread.sleep(5000);
                System.out.println("Consumer " + Thread.currentThread().getName() + " received message: " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
