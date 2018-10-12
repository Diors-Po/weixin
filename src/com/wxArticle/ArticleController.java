package com.wxArticle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;

public class ArticleController extends Controller {
	ArticleService service = ArticleService.me;
	
	public void index(){
		allArticle();
	}
	
	public void save(){
		String jsonString = HttpKit.readData(getRequest());
		renderJson("result",this.service.insertArticle(jsonString)?true:false);
	}
	
	public void allArticle(){
		renderJson("articles",this.service.getAll());
	}
	
	public void myArticle(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		renderJson("myArticles", this.service.getMyArticle(uid));
	}
	
	public void edit(){}
	
	public void update(){
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		int id = json.getIntValue("id");
		renderJson("result", this.service.updateArticle(id, jsonString));
		
	}
	
	public void delete(){
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		int id = json.getIntValue("id");
		renderJson("result", this.service.deleteById(id));
	}
}
