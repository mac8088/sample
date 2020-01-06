package net.atos.sample.dtm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.sample.dtm.dao.PointDao;
import net.atos.sample.dtm.exception.BusinessException;
import net.atos.sample.dtm.model.Point;

import javax.annotation.Resource;

@Service
public class PointService {

    @Resource
    private PointDao dao;

    @Transactional(rollbackFor = Exception.class)
    public String savePoint(Point point) {
        if ((point != null) && (point.getUserId() != null)) {
            Point queryPoint = dao.getByUserId(point.getUserId());
            if (queryPoint != null) {
                return queryPoint.getId();
            } else {
                return dao.insert(point);
            }
        } else {
			throw new BusinessException("入参不能为空！");
		}
    }

}
