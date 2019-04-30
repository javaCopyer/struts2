package jms_mq.activemq.service;


import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
@Service
public class ProducerService {
	@Resource
	private JmsTemplate jmsTemplate;
	/**
	 * 向队列发送消息 
	 * @param destination queue或topic， 根据目的地发送消息
	 * @param msg
	 * @author sky
	 * @date 2018-2-20 上午11:22:40
	 */
	 public void sendMessage(Destination destination,final String msg){
	        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
	        jmsTemplate.send(destination, new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	                return session.createTextMessage(msg);
	            }
	        });
	    }
	 
	 	/**
	 	 * 向队列发送消息， 使用默认方式
	 	 * @param msg
	 	 * @author sky
	 	 * @date 2018-2-20 上午11:23:28
	 	 */
	    public void sendMessage(final String msg){
	        String destination = jmsTemplate.getDefaultDestinationName();
	        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
	        jmsTemplate.send(new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	                return session.createTextMessage(msg);
	            }
	        });
	    }

		public JmsTemplate getJmsTemplate() {
			return jmsTemplate;
		}

		public void setJmsTemplate(JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
		}
	    
	    
}
