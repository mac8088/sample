package net.atos.sample.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartApplication {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context-activemq.xml");
		MessageService messageService = (MessageService) ctx.getBean("messageService");
		messageService.sendQueueMessage("我的测试消息1");
		messageService.sendQueueMessage("我的测试消息2");
		messageService.sendQueueMessage("我的测试消息3");
	}

}
