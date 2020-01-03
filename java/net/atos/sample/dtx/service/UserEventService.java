package net.atos.sample.dtx.service;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import net.atos.sample.dtx.constant.EventProcess;
import net.atos.sample.dtx.constant.EventType;
import net.atos.sample.dtx.dao.UserEventDao;
import net.atos.sample.dtx.exception.BusinessException;
import net.atos.sample.dtx.model.Event;

@Service
public class UserEventService {

	@Resource
	private UserEventDao userEventDao;

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	@Resource(name = "topicDistributedTransaction")
	private Destination topic;

	public int newEvent(Event event) {
		if (event != null) {
			return userEventDao.insert(event);
		} else {
			throw new BusinessException("入参不能为空！");
		}
	}

	public List<Event> getNewEventList() {
		return userEventDao.getByProcess(EventProcess.NEW.getValue());
	}

	public void executeEvent(Event event) {
		if (event != null) {
			String eventProcess = event.getProcess();
			if ((EventProcess.NEW.getValue().equals(eventProcess))
					&& (EventType.NEW_USER.getValue().equals(event.getType()))) {
				String messageContent = event.getContent();
				jmsTemplate.send(topic, (Session session) -> {
					TextMessage msg = session.createTextMessage();
					// 设置消息内容
					msg.setText(messageContent);
					return msg;
				});

				event.setProcess(EventProcess.PUBLISHED.getValue());
				userEventDao.updateProcess(event);
			}
		}
	}

}
