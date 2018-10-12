package com.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JSonUtils {
	//½«JSon×Ö·û´®×ªÎªMap
	public static Map<String, Object> json2Map(String jsonString) throws UnsupportedEncodingException
	{
		jsonString = URLDecoder.decode(jsonString, "utf-8");
		return (Map<String, Object>)JSON.parse(jsonString.substring(
					jsonString.indexOf('{'),jsonString.indexOf('}')+1));
	}
	
	
	
}
