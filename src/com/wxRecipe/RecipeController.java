package com.wxRecipe;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Recipe;

public class RecipeController extends Controller {
	private RecipeService service = RecipeService.me;
	
	//进入食谱助手，获取历史搜索和全部食谱
	public void index(){
		int uid = this.getParaToInt("uid");
		
		List<Record> res = Db.find("select keyword from (select keyword,max(time) time from wx_searchHis where type='recipe_search' and uid="
		+uid+" group by keyword) a ORDER BY time DESC LIMIT 5");
		 
		String[] keywords = new String[res.size()];
		for(int i=0;i<res.size();i++)
			keywords[i] = res.get(i).getStr("keyword");
		this.setAttr("keywords",keywords);
	//	this.setAttr("allrecipes",this.service.getAll());
		this.renderJson();
	}
	
	//获取用户首页滚动展示的菜谱
	public void display(){
		List<Recipe> res = Recipe.dao.find("select * from wx_recipe limit 5");
		this.setAttr("display_recipe", res);
		renderJson();
	}
	
	public void search(){//需要uid，keyword
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		String keyword = json.getString("keyword");
		
		if(keyword==null || "".equals(keyword.trim()))
			this.renderJson("recipes",this.service.getAll());
		else
			this.renderJson("recipes",this.service.searchRecipe(uid,keyword));
		
	}
}
