package com.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class Utils {
	//private static String appID = "wx125ca331b58f7896";//appID
	//private static String secret = "e7ac594400e78556500eb656d7b07555";//SECRET
	
	private static String appID = "wx581eddc17c7be1d1";//appID
	private static String secret = "e745e908edad2f469e29b335202ffb9d";//SECRET
	
	private static String getAqrURL = "https://api.weixin.qq.com/wxa/getwxacode?access_token=";
	private static String getAccessTokenURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+secret;
	
	public static String getAppID(){
		return appID;
	}
	
	public static String getSecret(){
		return secret;
	}
	
	public static String getAqrURL(){
		return getAqrURL;
	}
	
	//发起get请求的方法。
		public static String GET(String url) {
			
		        String result = "";
		        BufferedReader in = null;
		        try {
		            String urlNameString = url;
		            //System.out.println(urlNameString);
		            URL realUrl = new URL(urlNameString);
		            // 打开和URL之间的连接
		            URLConnection connection = realUrl.openConnection();
		            // 设置通用的请求属性
		            connection.setRequestProperty("accept", "*/*");
		            connection.setRequestProperty("connection", "Keep-Alive");
		            connection.setRequestProperty("user-agent",
		                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		            // 建立实际的连接
		            connection.connect();
		            // 获取所有响应头字段
		            Map<String, List<String>> map = connection.getHeaderFields();
		            // 遍历所有的响应头字段
		            /*for (String key : map.keySet()) {
		                System.out.println(key + "--->" + map.get(key));
		            }*/
		            // 定义 BufferedReader输入流来读取URL的响应
		            in = new BufferedReader(new InputStreamReader(
		                    connection.getInputStream()));
		            String line;
		            while ((line = in.readLine()) != null) {
		                result += line;
		            }
		        } catch (Exception e) {
		            System.out.println("发送GET请求出现异常！" + e);
		            e.printStackTrace();
		        }
		        // 使用finally块来关闭输入流
		        finally {
		            try {
		                if (in != null) {
		                    in.close();
		                }
		            } catch (Exception e2) {
		                e2.printStackTrace();
		            }
		        }
		        return result;
		    }
		
		public static String MD5(String s) {
		    try {
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        byte[] bytes = md.digest(s.getBytes("utf-8"));
		        return toHex(bytes);
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}

		private static String toHex(byte[] bytes) {
			
		    final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
		    StringBuilder ret = new StringBuilder(bytes.length * 2);
		    for (int i=0; i<bytes.length; i++) {
		        ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
		        ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		    }
		    return ret.toString();
		}
		
		public static String getAccessToken(){
			String returnValue = GET(getAccessTokenURL);
			//System.out.println(returnValue);
			JSONObject returnJ = JSON.parseObject(returnValue);//解析请求结果
			String access_token =String.valueOf(returnJ.get("access_token"));//获取access_token
			return access_token;
		}
		
}
