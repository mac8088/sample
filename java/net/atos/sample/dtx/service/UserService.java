package net.atos.sample.dtx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import net.atos.sample.dtx.constant.EventProcess;
import net.atos.sample.dtx.constant.EventType;
import net.atos.sample.dtx.dao.UserDao;
import net.atos.sample.dtx.model.Event;
import net.atos.sample.dtx.model.Point;

@Service
public class UserService {

	@Resource
	private UserDao userDao;

	@Resource
	private UserEventService userEventService;

	@Transactional
	public void newUser(String userName, Integer pointAmount) {
		// 1.保存用户
		String userId = userDao.insert(userName);

		// 2.新增事件
		Event event = new Event();
		event.setType(EventType.NEW_USER.getValue());
		event.setProcess(EventProcess.NEW.getValue());
		Point point = new Point();
		point.setUserId(userId);
		point.setAmount(pointAmount);

		// 3.将对象转成 JSON 字符串存到事件的内容字段中
		event.setContent(JSON.toJSONString(point));
		userEventService.newEvent(event);
	}

}
