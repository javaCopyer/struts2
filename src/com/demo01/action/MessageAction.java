package com.demo01.action;

import java.io.IOException;

import javax.jms.Destination;

import org.apache.struts2.ServletActionContext;

import jms_mq.activemq.service.ConsumerService;
import jms_mq.activemq.service.ProducerService;

public class MessageAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6585369684300181151L;
	private String msg;
	private Destination demoQueueDestination;  //通道(queue)
	private Destination topicDestination;	   //topic
	private ProducerService producerService;   //生产者
	private ConsumerService consumerService;  //消费者
	public String sendQueue() throws IOException {
		producerService.sendMessage(demoQueueDestination, msg);
		getResponse().getWriter().print("队列消息发送成功");
		return null;
	}
	
	public String sendTopic() throws IOException {
		producerService.sendMessage(topicDestination, msg);
		getResponse().getWriter().print("订阅发送成功");
		return null;
	}
	public String receive() throws IOException {
		consumerService.receive(demoQueueDestination);
		getResponse().getWriter().print("接收成功");
		return null;
	}
	
	
	
	public Destination getDemoQueueDestination() {
		return demoQueueDestination;
	}
	public void setDemoQueueDestination(Destination demoQueueDestination) {
		this.demoQueueDestination = demoQueueDestination;
	}


	public ProducerService getProducerService() {
		return producerService;
	}


	public void setProducerService(ProducerService producerService) {
		this.producerService = producerService;
	}


	public ConsumerService getConsumerService() {
		return consumerService;
	}


	public void setConsumerService(ConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Destination getTopicDestination() {
		return topicDestination;
	}

	public void setTopicDestination(Destination topicDestination) {
		this.topicDestination = topicDestination;
	}
	
	
	
	
}
