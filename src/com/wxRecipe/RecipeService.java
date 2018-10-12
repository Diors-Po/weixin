package com.wxRecipe;

import java.util.List;

import com.common.TimeUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Recipe;


public class RecipeService {
	public static final RecipeService me = new RecipeService();
	private Recipe dao = Recipe.dao;
	
	
	public Recipe findById(int id){
		return dao.findById(id);
	}
	
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	public List<Recipe> getAll(){
		return dao.find("select * from wx_recipe");
	}
	
	public List<Recipe> searchRecipe(int uid, String keyword){
		
		//´æÈëËÑË÷¼ÇÂ¼
		Record record = new Record();
		record.set("uid", uid);
		record.set("keyword", keyword);
		record.set("type", "recipe_search");
		record.set("time", TimeUtils.getDateTime());
		Db.save("wx_searchHis", record);
		
		String[] keywords = keyword.trim().split(" ");
		/*String sql = "";
		for(int i=0; i<keywords.length-1;i++){
			String tem = keywords[i].trim();
			sql += "select * from wx_recipe where name like '%"+tem+"%' or material like '%"
				+tem+"%' or method like '%"+tem+"%' or suitpeople like '%"+"%' union ";
		}
		sql+="select * from wx_recipe where name like '%"+keywords[keywords.length-1].trim()+"%' or material like '%"
				+keywords[keywords.length-1].trim()+"%' or method like '%"+keywords[keywords.length-1].trim()
				+"%' or suitpeople like '%"+keywords[keywords.length-1].trim()+"%'";
		*/
		for(String s : keywords){
			s = s.trim();
			//System.out.println("-"+s+"-");
		}
		
		List<Recipe> res = dao.find("select * from wx_recipe");
		for(int i=res.size()-1;i>=0;i--){
			Recipe tem = res.get(i);
			//System.out.println("tem"+i+tem);
			for(int j=0;j<keywords.length;j++){
				boolean f1 = (!(tem.getStr("name")==null))&&tem.getStr("name").contains(keywords[j]);
				boolean f2 = (!(tem.getStr("method")==null))&&tem.getStr("method").contains(keywords[j]);
				boolean f3 = (!(tem.getStr("material")==null))&&tem.getStr("material").contains(keywords[j]);
				boolean f4 = (!(tem.getStr("suitpeople")==null))&&tem.getStr("suitpeople").contains(keywords[j]);
				//System.out.println(f1+"-"+f2+"-"+f3+"-"+f4);
				if(!(f1||f2||f3||f4)){
					res.remove(i);
					//System.out.println(i);
					break;
				}
				
			}
		}
		
		System.out.println(res.size());
		return res;
	}
}
