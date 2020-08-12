package net.atos.sample.json.jack;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.atos.sample.json.User;

public class JacksonDemo {

	public static void main(String[] args) {
		System.out.println(toJson(new User(1, "张三", "男", new Date())));
	}

	public static String toJson(Object obj) {
		String re = null;
		// 对象映射
		ObjectMapper objectMapper = new ObjectMapper();
		// 设置时间格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(dateFormat);
		try {
			re = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return re;
	}

}
