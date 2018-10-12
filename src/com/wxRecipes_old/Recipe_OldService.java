package com.wxRecipes_old;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.TimeUtils;
import com.jfinal.kit.HttpKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Recipe_old;

public class Recipe_OldService {
	public static final Recipe_OldService me = new Recipe_OldService();
	private Recipe_old dao = Recipe_old.dao;
	
	public Recipe_old findById(int id){
		return dao.findById(id);
	}
	
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	public List<Recipe_old> getAll(){
		return dao.find("select * from wx_recipes");
	}
	
	public List<Recipe_old> searchRecipe(int uid, String keyword){
		
		//´æÈëËÑË÷¼ÇÂ¼
		Record record = new Record();
		record.set("uid", uid);
		record.set("keyword", keyword);
		record.set("type", "recipes_search");
		record.set("time", TimeUtils.getDateTime());
		Db.save("wx_searchHis", record);
		
		String[] keywords = keyword.split(" ");
		String sql = "";
		for(int i=0; i<keywords.length-1;i++){
			String tem = keywords[i].trim();
			sql += "select * from wx_recipes where name like '%"+tem+"%' or tag like '%"
				+tem+"%' or details like '%"+tem+"%' union ";
		}
		sql+="select * from wx_recipes where name like '%"+keywords[keywords.length-1].trim()+"%' or tag like '%"
				+keywords[keywords.length-1].trim()+"%' or details like '%"+keywords[keywords.length-1].trim()+"%'";
		
		List<Recipe_old> res = dao.find(sql);
		return res;
	}
	
}
