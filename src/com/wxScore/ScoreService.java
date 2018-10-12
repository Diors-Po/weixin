package com.wxScore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.common.TimeUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.ScoreRecord;

public class ScoreService {
	
	public static final ScoreService me = new ScoreService();
	private ScoreRecord dao = ScoreRecord.dao;
	
	public List<ScoreRecord> findBySql(String sql){
		return dao.find(sql);
	}
	
	//����һ�����ּ�¼��scoreΪ��ֵΪ���ּ�¼
	public boolean insertRecord(int uid,int score,String cause){
		ScoreRecord sr = new ScoreRecord();
		
		String datetime = TimeUtils.getDateTime();
		
		sr.set("uid", uid);
		sr.set("score", score);
		sr.set("cause", cause);
		sr.set("time", datetime);
		
		return sr.save();
	}
	
	//�����ȡ����ǩ��Ӧ�����ӵĻ���
	public int todaySignScore(int uid){
        String  yesterday = TimeUtils.getYesterday();
        //System.out.println(yesterday);
		String sql = "select score from score_record where uid =" + uid +" and time like'"+yesterday+"%' and cause = 'ǩ��'";
		
		Record r = Db.findFirst(sql);
		if(r==null || r.getInt("score")==7)
			return 1;
		else
			return r.getInt("score")+1;
	}
	
	//��ȡ�û���ǰ�����ܺ�
	public int getTotalScore(int uid){
		String sql = "select sum(score) totalScore from score_record where uid = " + uid ;
		Record r = Db.findFirst(sql);
		if(r.getInt("totalScore") == null)
			return 0;
		return r.getInt("totalScore");
	}
	
	//��ȡ���ּ�¼
	public List<ScoreRecord> getAll(int uid){
		return dao.find("select * from score_record where uid = "+uid+" order by id desc");
	}
	
	
}
