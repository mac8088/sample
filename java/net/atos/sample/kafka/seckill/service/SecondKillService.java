﻿package net.atos.sample.kafka.seckill.service;

import com.alibaba.fastjson.JSONObject;

import net.atos.sample.kafka.seckill.config.Constants;
import net.atos.sample.kafka.seckill.redis.RedisOperate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SecondKillService {

	public static final String goodsId = "123456";// 初始化商品ID

	public static final String goodsStock = "10";// 初始化商品库存数量

	@Autowired
	private RedisOperate redisOperate;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void initStock() {
		// 初始化商品库存
		redisOperate.set(goodsId, goodsStock);
	}

	public boolean buy() {
		/**
		 * 预先减去 REDIS 中的库存，如果库存数量足够减，则表示当前用户秒到了该商品，如果不够则表示没有秒到
		 */
		Long stock = redisOperate.decr(goodsId);
		if (stock < 0) {
			return false;
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("goodsId", goodsId);
		jsonObject.put("goodsStock", stock);

		/**
		 * 将业务数据写入消息队列
		 */
		kafkaTemplate.send(Constants.TOPIC_SECOND_KILL, jsonObject.toJSONString());

		return true;
	}
}
