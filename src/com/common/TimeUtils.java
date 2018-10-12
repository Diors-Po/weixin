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
		Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
        calendar.add(Calendar.DATE, -1);    //得到前一天
        String  yesterday = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        return yesterday;
	}
	
	//对结果集中的datetime类型的时间字符串处理，去掉末尾的.000
	public static void formatDateTime(List<Record> data){
		for(Record r : data){
			r.set("time", r.getStr("time").substring(0,19));
		}
	}
}
