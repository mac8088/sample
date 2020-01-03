package net.atos.sample.dtx.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import net.atos.sample.dtx.model.Event;
import net.atos.sample.dtx.service.PointEventService;

@Component
public class PointScheduled {

	@Autowired
	private PointEventService pointEventService;

	@Scheduled(cron = "*/5 * * * * *")
	public void executeEvent() {
		List<Event> eventList = pointEventService.getPublishedEventList();
		if (!CollectionUtils.isEmpty(eventList)) {
			System.out.println("已发布的积分事件记录总数：" + eventList.size());

			for (Event event : eventList) {
				pointEventService.executeEvent(event);
			}
		} else {
			System.out.println("待处理的事件总数：0");
		}

	}
}
