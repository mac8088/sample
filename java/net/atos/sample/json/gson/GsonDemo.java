package net.atos.sample.json.gson;

import java.util.Date;

import com.google.gson.Gson;

import net.atos.sample.json.User;

public class GsonDemo {

	public GsonDemo() {
	}

	public static void main(String[] args) {
		System.out.println(toJson(new User(1, "张三", "男", new Date())));
	}

	public static String toJson(Object obj) {
		String re = null;
		Gson gson = new Gson();
		re = gson.toJson(obj);
		return re;
	}

}
