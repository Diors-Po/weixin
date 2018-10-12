package com.wxRecipes_old;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.JSonUtils;
import com.common.TimeUtils;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Recipe_old;

public class Recipe_OldController extends Controller {
	private Recipe_OldService service = Recipe_OldService.me;
	
	//进入食谱助手，获取历史搜索和全部食谱
	public void index(){
		int uid = this.getParaToInt("uid");
		List<Record> res = Db.find("select top 5 keyword from wx_searchHis where type='recipes_search' and uid="
							+uid+" group by keyword ");
		
		String[] keywords = new String[res.size()];
		for(int i=0;i<res.size();i++)
			keywords[i] = res.get(i).getStr("keyword");
		this.setAttr("keywords",keywords);
		this.setAttr("allrecipes",this.service.getAll());
		this.renderJson();
		/*for(int i=0;i<res.size();i++)
			this.setAttr("keyword"+(i+1), res.get(i).getStr("keyword"));*/
		//renderJson();
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
