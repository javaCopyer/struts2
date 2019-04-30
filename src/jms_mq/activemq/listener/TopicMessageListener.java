package jms_mq.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
        try {
        	tm.acknowledge();
        	Thread.sleep(5000);
            System.out.println("TopicMessageListener监听到了文本消息：\t"
                    + tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
