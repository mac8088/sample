package net.atos.sample.activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

@Service
public class MessageService {

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	@Resource(name = "testQueue")
	private Destination testQueue;

	@Resource(name = "testTopic")
	private Destination testTopic;

	// ����з�����Ϣ
	public void sendQueueMessage(String messageContent) {
		jmsTemplate.send(testQueue, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				// ������Ϣ����
				msg.setText(messageContent);
				return msg;
			}
		});

	}

	// �����ⷢ����Ϣ
	public void sendTopicMessage(String messageContent) {
		jmsTemplate.send(testTopic, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				// ������Ϣ����
				msg.setText(messageContent);
				return msg;
			}
		});
	}
}
