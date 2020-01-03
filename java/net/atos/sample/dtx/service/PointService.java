package net.atos.sample.dtx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.atos.sample.dtx.dao.PointDao;
import net.atos.sample.dtx.exception.BusinessException;
import net.atos.sample.dtx.model.Point;

@Service
public class PointService {

	@Resource
	private PointDao dao;

	public String newPoint(Point point) {
		if (point != null) {
			return dao.insert(point);
		} else {
			throw new BusinessException("入参不能为空！");
		}
	}

}
