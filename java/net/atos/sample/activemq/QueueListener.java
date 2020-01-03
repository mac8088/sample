package net.atos.sample.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				TextMessage txtMsg = (TextMessage) message;
				String messageStr = txtMsg.getText();
				System.out.println("���м��������յ��ı���Ϣ��" + messageStr);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("ֻ֧�� TextMessage ������Ϣ��");
		}
	}
}
