package net.atos.sample.dtx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import net.atos.sample.dtx.constant.EventProcess;
import net.atos.sample.dtx.constant.EventType;
import net.atos.sample.dtx.dao.PointEventDao;
import net.atos.sample.dtx.exception.BusinessException;
import net.atos.sample.dtx.model.Event;
import net.atos.sample.dtx.model.Point;

@Service
public class PointEventService {

	@Resource
	private PointEventDao pointEventDao;

	@Resource
	private PointService pointService;

	public int newEvent(Event event) {
		if (event != null) {
			return pointEventDao.insert(event);
		} else {
			throw new BusinessException("入参不能为空！");
		}
	}

	public List<Event> getPublishedEventList() {
		return pointEventDao.getByProcess(EventProcess.PUBLISHED.getValue());
	}

	public void executeEvent(Event event) {
		if (event != null) {
			String eventProcess = event.getProcess();
			if ((EventProcess.PUBLISHED.getValue().equals(eventProcess))
					&& (EventType.NEW_POINT.getValue().equals(event.getType()))) {
				Point point = JSON.parseObject(event.getContent(), Point.class);
				pointService.newPoint(point);

				event.setProcess(EventProcess.PROCESSED.getValue());
				pointEventDao.updateProcess(event);
			}
		}
	}
}
