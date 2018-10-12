package com.wxGoods;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.common.JSonUtils;
import com.common.TimeUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Bought;
import com.wxModel.Good;
import com.wxModel.ScoreRecord;
import com.wxScore.ScoreService;

public class GoodService {
	public static final GoodService me = new GoodService();
	private Good dao = Good.dao;
	
	//����id��ȡ��Ʒ
	public Good findById(int id){
		return dao.findById(id);
	}
	
	//����idɾ����Ʒ
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	//�������Ͳ�ѯ��Ʒ
	public List<Record> findByType(String type){
		return Db.find("select * from wx_goods where type = '"+type+"' order by id desc");
	}
	
	//��ѯ������Ƶ
	public List<Record> getAllVideo(){
		return Db.find("select id,name,vid,description,price,img from wx_goods where type = 'video' order by id desc");
	}
	
	//��ѯ���з������Ƶ
	public List<Record> getNoFreeVideo(){
		return Db.find("select id,name,vid,description,price,img from wx_goods where type = 'video' and price>0 order by id desc");
	}
	
	//��ѯ���������Ƶ
	public List<Record> getFreeVideo(){
		return Db.find("select id,name,vid,description,price,img from wx_goods where type = 'video' and price=0 order by id desc");
	}
	
	//��ѯ�ҵ���Ƶ
	public List<Record> getMyVideo(int uid){
		return Db.find("select goodsid id,name,vid,description,price,img from wx_bought where uid="+uid+" and type = 'video' and price>0 order by id desc");
	}
	
	//���ֶһ�������һ��bought��¼��scoreRecord��¼
	public boolean buyGoods(int id,int uid,int price){
		Good good = dao.findById(id);
		String cause = "�һ�"+good.getStr("name")+"��"+good.getStr("type")+"��";
		ScoreService.me.insertRecord(uid, 0-price, cause);
		String goodString = good.toRecord().remove("id").toJson();
		Bought b = new Bought();
		
		try {
			b._setAttrs(JSonUtils.json2Map(goodString));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.set("time", TimeUtils.getDateTime());
		b.set("goodsid", id);
		b.set("uid", uid);
		return b.save();
	}
	
	
	
	
}
