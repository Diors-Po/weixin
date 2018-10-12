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
	
	//����get����ķ�����
		public static String GET(String url) {
			
		        String result = "";
		        BufferedReader in = null;
		        try {
		            String urlNameString = url;
		            //System.out.println(urlNameString);
		            URL realUrl = new URL(urlNameString);
		            // �򿪺�URL֮�������
		            URLConnection connection = realUrl.openConnection();
		            // ����ͨ�õ���������
		            connection.setRequestProperty("accept", "*/*");
		            connection.setRequestProperty("connection", "Keep-Alive");
		            connection.setRequestProperty("user-agent",
		                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		            // ����ʵ�ʵ�����
		            connection.connect();
		            // ��ȡ������Ӧͷ�ֶ�
		            Map<String, List<String>> map = connection.getHeaderFields();
		            // �������е���Ӧͷ�ֶ�
		            /*for (String key : map.keySet()) {
		                System.out.println(key + "--->" + map.get(key));
		            }*/
		            // ���� BufferedReader����������ȡURL����Ӧ
		            in = new BufferedReader(new InputStreamReader(
		                    connection.getInputStream()));
		            String line;
		            while ((line = in.readLine()) != null) {
		                result += line;
		            }
		        } catch (Exception e) {
		            System.out.println("����GET��������쳣��" + e);
		            e.printStackTrace();
		        }
		        // ʹ��finally�����ر�������
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
			JSONObject returnJ = JSON.parseObject(returnValue);//����������
			String access_token =String.valueOf(returnJ.get("access_token"));//��ȡaccess_token
			return access_token;
		}
		
}
