package com.wxDiary;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.common.JSonUtils;
import com.common.TimeUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Diary;
import com.wxUser.UserService;

public class DiaryService {
	
	public static final DiaryService me = new DiaryService();
	private Diary dao = Diary.dao;
	
	public Diary findById(int id){
		return dao.findById(id);
	}
	
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	//�����û�uid�����û������һ�μ�¼������
	public float getUserWeigth(int uid){
		Record res = Db.findFirst("select weight from wx_diary where weight != 0 and uid="+ uid + " order by id desc");
		if(res==null)
			return 0;
		return res.getFloat("weight");
	}
	
	//�����û�uid��ȡ���û��������ռ�
	public List<Record> getDiary(int uid){
		List<Record> res = Db.find("select * from wx_diary where uid = "+uid+" order by id desc");
		for(Record r : res){
			r.set("time", r.getStr("time").substring(0,19));
		}
		return res;
	}
	
	public List<Record> getDiary(int uid, String startDate, String endDate){
		List<Record> res = Db.find("select * from wx_diary where time between '"
				+startDate+"' and '" +endDate+"' and uid = "+uid+" order by id desc");
		for(Record r : res){
			r.set("time", r.getStr("time").substring(0,19));
		}
		return res;
	}
	
	//�����µļ����ռ�
	public boolean insertDiary(String diaryData){
		Diary diary = new Diary();
		try {
			diary._setAttrs(JSonUtils.json2Map(diaryData));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		diary.set("time", TimeUtils.getDateTime());
		return diary.save();
	}
	
	//�����ռǵ�id���¼����ռ�
	public boolean updateByid(int id,String newDiarydata){
		Diary diary = new Diary();
		try {
			diary._setAttrs(JSonUtils.json2Map(newDiarydata));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return diary.update();
	}
	
	//������ֹ���ں��û�uid����ȡ��¼�ĸ��������
	public List<Record> getHealth(int uid, String startDate, String endDate){
		List<Record> res = Db.find("select * from wx_diary where time between '"
				+startDate+"' and '" +endDate+"' and uid = "+uid);
		
		float height = UserService.me.getHeight(uid)/100;
		for(Record r : res){
			r.set("BMI", null);
			if(r.getFloat("weight")!=null)
				r.set("BMI", (r.getFloat("weight")/(height*height)));//BMI=���أ�kg��/��ߣ�m����ƽ��
			String time = r.getStr("time");
			time = time.substring(5, 10);
			r.set("time", time);
		}
		return res;
		
	}
	
	//BMI��¼����
	public Float[] getBMIArr(int uid, String startDate, String endDate){
		List<Record> res = getHealth(uid,startDate,endDate);
		Float[] BMI = new Float[res.size()];
		for(int i=0;i<res.size();i++){
			BMI[i] = res.get(i).getFloat("BMI");
		}
		return BMI;
	}
	
	public Float[] getBMIArr(List<Record> res){
		Float[] BMI = new Float[res.size()];
		for(int i=0;i<res.size();i++){
			BMI[i] = res.get(i).getFloat("BMI");
		}
		return BMI;
	}
	
	
	//���ڼ�¼����
	public String[] getDateArr(int uid, String startDate, String endDate){
		List<Record> res = getHealth(uid,startDate,endDate);
		String[] date = new String[res.size()];
		
		for(int i=0;i<res.size();i++){
			date[i] = res.get(i).getStr("time");
		}
		return date;
	}
	
	public String[] getDateArr(List<Record> res){
		String[] date = new String[res.size()];
		for(int i=0;i<res.size();i++){
			date[i] = res.get(i).getStr("time");
		}
		return date;
	}
	
	//���ؼ�¼����
	public Float[] getWeightArr(int uid, String startDate, String endDate){
		List<Record> res = getHealth(uid,startDate,endDate);
		Float[] weight = new Float[res.size()];
		for(int i=0;i<res.size();i++){
			weight[i] = res.get(i).getFloat("weight");
		}
		return weight;
	}
	
	public Float[] getWeightArr(List<Record> res){
		Float[] weight = new Float[res.size()];
		for(int i=0;i<res.size();i++){
			weight[i] = res.get(i).getFloat("weight");
		}
		return weight;
	}
	
	//Ѫ�Ǽ�¼����
	public Integer[] getGLSArr(int uid, String startDate, String endDate){
		List<Record> res = getHealth(uid,startDate,endDate);
		Integer[] GLS = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			GLS[i] = res.get(i).getInt("gls");
		}
		return GLS;
	}
	
	public Integer[] getGLSArr(List<Record> res){
		Integer[] GLS = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			GLS[i] = res.get(i).getInt("gls");
		}
		return GLS;
	}
	
	//Ѫѹ��BP����ѹ��¼����
	public Integer[] getBPHighArr(int uid, String startDate, String endDate){
		List<Record> res = getHealth(uid,startDate,endDate);
		Integer[] bpHigh = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			bpHigh[i] = res.get(i).getInt("bp_high");
		}
		return bpHigh;
	}
	
	public Integer[] getBPHighArr(List<Record> res){
		Integer[] bpHigh = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			bpHigh[i] = res.get(i).getInt("bp_high");
		}
		return bpHigh;
	}
	
	//Ѫѹ��BP����ѹ��¼����
	public Integer[] getBPLowArr(int uid, String startDate, String endDate){
		List<Record> res = getHealth(uid,startDate,endDate);
		Integer[] bpLow = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			bpLow[i] = res.get(i).getInt("bp_low");
		}
		return bpLow;
	}
	
	public Integer[] getBPLowArr(List<Record> res){
		Integer[] bpLow = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			bpLow[i] = res.get(i).getInt("bp_low");
		}
		return bpLow;
	}
	
	//����(UPD)��¼����
	public Integer[] getUPDArr(int uid, String startDate, String endDate){
		List<Record> res = getHealth(uid,startDate,endDate);
		Integer[] upd = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			upd[i] = res.get(i).getInt("upd");
		}
		return upd;
	}
	
	public Integer[] getUPDArr(List<Record> res){
		Integer[] upd = new Integer[res.size()];
		for(int i=0;i<res.size();i++){
			upd[i] = res.get(i).getInt("upd");
		}
		return upd;
	}
	
	

	
	
}
