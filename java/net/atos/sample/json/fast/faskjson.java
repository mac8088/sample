package net.atos.sample.json.fast;

import java.util.Date;

import com.alibaba.fastjson.JSON;

import net.atos.sample.json.User;

public class faskjson {

	public faskjson() {
	}

	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(new User(1, "张三", "男", new Date())));
	}

}
