package net.atos.sample.json;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonPerf1 {

	public static Map<String, Object> getMapData(Map<String, Object> map, int count) {
		for (int i = 0; i < count; i++) {
			map.put("a" + i, i);
		}
		return map;
	}

//	// Spring 中默认用到的是Jackson 在框架搭建的时候一般都改用fastJson
//	@SuppressWarnings("static-access")
//	public static void main(String[] str) {
//		Map<String, Object> map = new HashMap<>();
//		map = getMapData(map, 1000000);
//		long fastJsonBegin = System.currentTimeMillis();
//		JSONObject fastJson = new JSONObject();
//		// fastJson
//		System.out.println("fastJson----------------------------------------");
//		// System.out.println("fastJson"+fastJson.toJSONString(map));
//		fastJson.toJSONString(map);
//		long fastJsonEnd = System.currentTimeMillis();
//		System.out.println("fastJson-------------time------------------------" + (fastJsonEnd - fastJsonBegin));
//
//		// jackson
//		long jacksonBegin = System.currentTimeMillis();
//		ObjectMapper jackson = new ObjectMapper();
//		try {
//			System.out.println("jackson--------------------------------------");
//			// System.out.println("jackson"+jackson.writeValueAsString(map));
//			jackson.writeValueAsString(map);
//			long jacksonEnd = System.currentTimeMillis();
//			System.out.println("jackson-------------time---------------------" + (jacksonEnd - jacksonBegin));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//	}

	
	//Spring 中默认用到的是Jackson   在框架搭建的时候一般都改用fastJson
    public static void main(String [] str) {
        Map map = new HashMap<String,Object>();
        map = getMapData(map,1000000);
        JSONObject fastJson = new JSONObject();
       long fastJsonBegin =  System.currentTimeMillis();

       //fastJson
        System.out.println("fastJson-------------------------------------------------");
       // System.out.println("fastJson"+fastJson.toJSONString(map));
        fastJson.toJSONString(map);
        long fastJsonEnd =  System.currentTimeMillis();
        System.out.println("fastJson-------------time------------------------------------"+(fastJsonEnd-fastJsonBegin));
        //jackson
        ObjectMapper jackson = new ObjectMapper();
        long jacksonBegin =  System.currentTimeMillis();

        try {
            System.out.println("jackson-------------------------------------------------");
            //System.out.println("jackson"+jackson.writeValueAsString(map));
            jackson.writeValueAsString(map);
            long jacksonEnd =  System.currentTimeMillis();
            System.out.println("jackson-------------time------------------------------------"+(jacksonEnd-jacksonBegin));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
