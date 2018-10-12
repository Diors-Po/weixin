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
	
	//���뼲����־������uid�����ϴμ�¼ʱ����������
	public void index(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		//int uid = this.getParaToInt("uid");
		float weight = DiaryService.me.getUserWeigth(uid);
		this.renderJson("weight",weight);
	}
	
	//�ύ�µļ����ռ�
	public void save(){
		String jsonString = HttpKit.readData(getRequest());
		this.renderJson("result",DiaryService.me.insertDiary(jsonString));
	}
	
	//�鿴�û����ռ�
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
	
	//������ֹʱ�������ռ�
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
	
	//����༭�ռ�
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

	//�����ռ�
	public void updateDiary(){
		String jsonString = HttpKit.readData(getRequest());
		//System.out.println(jsonString);
		JSONObject json = JSON.parseObject(jsonString);
		int id = json.getIntValue("id");
		this.renderJson("result",DiaryService.me.updateByid(id, jsonString));
	}
	
	//ɾ���ռ�
	public void delete(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int id = json.getIntValue("id");
		this.renderJson("result",DiaryService.me.deleteById(id));
	}
	
	//��ȡ���Ի�������ͼ�Ľ������ݣ�
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
