package net.atos.sample.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Topic1Listener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				TextMessage txtMsg = (TextMessage) message;
				String messageStr = txtMsg.getText();
				System.out.println("主题监听器1 接收到文本消息：" + messageStr);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("只支持 TextMessage 类型消息！");
		}
	}
}
