package jms_mq.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class QueueMessageListener implements javax.jms.MessageListener{

	@Override
	public void onMessage(Message message) {
		  TextMessage tm = (TextMessage) message;
	        try {
	        	tm.acknowledge();
	        	Thread.sleep(5000);
	            System.out.println("QueueMessageListener监听到了文本消息：\t"
	                    + tm.getText());
	            //do something ...
	        } catch (JMSException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}
