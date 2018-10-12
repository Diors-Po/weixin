package com.wxDiary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Diary;
import com.wxModel.User;
import com.wxUser.UserService;

public class DiaryController extends Controller {
	
	public void test(){
		
		
		this.renderJson(Db.findById("wx_diary", 1));
	}
	
	//进入疾病日志，根据uid返回上次记录时的体重数据
	public void index(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		//int uid = this.getParaToInt("uid");
		float weight = DiaryService.me.getUserWeigth(uid);
		this.renderJson("weight",weight);
	}
	
	//提交新的疾病日记
	public void save(){
		String jsonString = HttpKit.readData(getRequest());
		this.renderJson("result",DiaryService.me.insertDiary(jsonString));
	}
	
	//查看用户的日记
	public void myDiary(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		List<Record> diarys = DiaryService.me.getDiary(uid);
		boolean result = false;
		if(diarys.size()>0)
			result = true;
		this.setAttr("result", result);
		this.setAttr("diarys", diarys);
		this.renderJson();
	}
	
	//根据起止时间搜索日记
	public void searchDiary(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		String startDate = json.getString("startDate") + " 00:00:00";
		String endDate = json.getString("endDate") + " 23:59:59";
		List<Record> diarys = DiaryService.me.getDiary(uid, startDate, endDate);
		boolean result = false;
		if(diarys.size()>0)
			result = true;
		this.setAttr("result", result);
		this.setAttr("diarys", diarys);
		this.renderJson();
	}
	
	//进入编辑日记
	public void edit(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int id = json.getIntValue("id");
		Diary diary = DiaryService.me.findById(id);
		boolean result = false;
		if(diary!=null)
			result = true;
		this.setAttr("result", result);
		this.setAttr("diary", result?diary.toRecord():null);
		this.renderJson();
	}

	//更新日记
	public void updateDiary(){
		String jsonString = HttpKit.readData(getRequest());
		//System.out.println(jsonString);
		JSONObject json = JSON.parseObject(jsonString);
		int id = json.getIntValue("id");
		this.renderJson("result",DiaryService.me.updateByid(id, jsonString));
	}
	
	//删除日记
	public void delete(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int id = json.getIntValue("id");
		this.renderJson("result",DiaryService.me.deleteById(id));
	}
	
	//获取用以绘制趋势图的健康数据，
	public void healthData(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		String startDate = json.getString("startDate")+" 00:00:00";
		String endDate = json.getString("endDate")+" 23:59:59";
		
		List<Record> res = DiaryService.me.getHealth(uid, startDate, endDate);
		int count = res.size();
		String[] date = DiaryService.me.getDateArr(res);
		Float[] BMI = DiaryService.me.getBMIArr(res);
		Float[] weight= DiaryService.me.getWeightArr(res);
		Integer[] GLS = DiaryService.me.getGLSArr(res);
		Integer[] BPHigh = DiaryService.me.getBPHighArr(res);
		Integer[] BPLow = DiaryService.me.getBPLowArr(res);
		Integer[] UPD = DiaryService.me.getUPDArr(res);
		
		boolean result = false;
		if(count>0)
			result = true;
		this.setAttr("result", result);
		this.setAttr("count", count);
		this.setAttr("date", date);
		this.setAttr("BMI", BMI);
		this.setAttr("weight", weight);
		this.setAttr("GLS", GLS);
		this.setAttr("BPHigh", BPHigh);
		this.setAttr("BPLow", BPLow);
		this.setAttr("UPD", UPD);

		this.renderJson();
	}
		
	
	
}
