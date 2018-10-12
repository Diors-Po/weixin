package com.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Record;

public class TimeUtils {
	public static String getDate(){
		Date today = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String date = sdf.format(today);
		return date;
	}
	
	public static String getDateTime(){
		Date today = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String now = sdf.format(today);
		return now;
	}
	
	public static String getYesterday(){
		Calendar calendar = Calendar.getInstance();//��ʱ��ӡ����ȡ����ϵͳ��ǰʱ��
        calendar.add(Calendar.DATE, -1);    //�õ�ǰһ��
        String  yesterday = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        return yesterday;
	}
	
	//�Խ�����е�datetime���͵�ʱ���ַ�������ȥ��ĩβ��.000
	public static void formatDateTime(List<Record> data){
		for(Record r : data){
			r.set("time", r.getStr("time").substring(0,19));
		}
	}
}
