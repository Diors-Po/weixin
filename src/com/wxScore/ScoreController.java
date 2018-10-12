package com.wxScore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.TimeUtils;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.wxModel.ScoreRecord;

public class ScoreController extends Controller {
	public void index(){
		
	}
	
	//根据增加积分记录，判断用户是否已经签到
	public void isSigned(){
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		int uid = json.getIntValue("uid");
		
		String date = TimeUtils.getDate();
		String sql = "select * from score_record where uid =" + uid +" and time like'"+date+"%' and cause = '签到'";
		this.setAttr("result",ScoreService.me.findBySql(sql).size()>0?true:false);
		this.setAttr("totalScore", ScoreService.me.getTotalScore(uid));
		this.renderJson();
	}
	
	//签到增加积分
	public void signIn(){
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		
		int uid = json.getIntValue("uid");
		int score = 0;
		
		/*switch(cause){
			case "写文章":score = 100;break;
			case "购买内容":score = 0 - json.getIntValue("price");break;
			case "签到":score = ScoreService.me.todaySignScore(uid);break;
			default:break;
			
		}*/
		score = ScoreService.me.todaySignScore(uid);
		
		this.setAttr("result",ScoreService.me.insertRecord(uid, score, "签到"));
		this.setAttr("totalScore", ScoreService.me.getTotalScore(uid));
		this.renderJson();

	}
	
	public void scoreRecord(){
		int uid = this.getParaToInt("uid");
		List<ScoreRecord> res = ScoreService.me.getAll(uid);
		this.setAttr("records", res);
		this.renderJson();
	}
	
	
	
}
