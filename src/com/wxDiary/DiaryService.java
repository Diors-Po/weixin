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
	
	//根据用户uid返回用户最近的一次记录的体重
	public float getUserWeigth(int uid){
		Record res = Db.findFirst("select weight from wx_diary where weight != 0 and uid="+ uid + " order by id desc");
		if(res==null)
			return 0;
		return res.getFloat("weight");
	}
	
	//根据用户uid获取该用户的所有日记
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
	
	//插入新的疾病日记
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
	
	//根据日记的id更新疾病日记
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
	
	//根据起止日期和用户uid，获取记录的各项健康数据
	public List<Record> getHealth(int uid, String startDate, String endDate){
		List<Record> res = Db.find("select * from wx_diary where time between '"
				+startDate+"' and '" +endDate+"' and uid = "+uid);
		
		float height = UserService.me.getHeight(uid)/100;
		for(Record r : res){
			r.set("BMI", null);
			if(r.getFloat("weight")!=null)
				r.set("BMI", (r.getFloat("weight")/(height*height)));//BMI=体重（kg）/身高（m）的平方
			String time = r.getStr("time");
			time = time.substring(5, 10);
			r.set("time", time);
		}
		return res;
		
	}
	
	//BMI记录数组
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
	
	
	//日期记录数组
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
	
	//体重记录数组
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
	
	//血糖记录数组
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
	
	//血压（BP）高压记录数组
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
	
	//血压（BP）低压记录数组
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
	
	//尿量(UPD)记录数组
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
