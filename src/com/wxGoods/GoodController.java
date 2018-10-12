package com.wxGoods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.wxModel.Bought;
import com.wxModel.Good;

public class GoodController extends Controller {
	
	private GoodService service = GoodService.me;
	
	public void test(){
		
	}
	public void index(){
		allVideo();
	}
	
	//获取视频，一次发送
	public void getVideos(){
		int uid = this.getParaToInt("uid");
		this.setAttr("nofree", this.service.getNoFreeVideo());
		this.setAttr("free", this.service.getFreeVideo());
		this.setAttr("my", this.service.getMyVideo(uid));
		this.renderJson();
	}
	
	public void allVideo(){
		renderJson("videos",this.service.getAllVideo());
	}
	
	
	public void freeVideo(){
		renderJson("videos",this.service.getFreeVideo());
	}
	
	public void myVideo(){
		//int uid = this.getParaToInt("uid");
		int uid = JSON.parseObject(HttpKit.readData(getRequest())).getIntValue("uid");
		renderJson("videos",this.service.getMyVideo(uid));
	}
	
	public void buyVideo(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int id = json.getIntValue("id");
		int uid = json.getIntValue("uid");
		int price = json.getIntValue("price");
		this.renderJson("result",this.service.buyGoods(id, uid, price));
	}
	
	public void deleteMyvideo(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int id = json.getIntValue("id");
		Bought b = Bought.dao.findFirst("select * from wx_bought where goodsid="+id);
		
		this.renderJson("result", b.delete());
	}
	
	
	/**
	 * 以下接口为后台管理系统调用
	 */
	public void add(){
		Good good = new Good();
		good.set("type", this.getPara("type"));
		good.set("price", this.getPara("price"));
		good.set("vid", this.getPara("vid"));
		good.set("description", this.getPara("description"));
		good.set("name", this.getPara("name"));	
		good.set("img", this.getPara("img"));
		this.renderJson("result",good.save());
		
	}
	
	public void update(){
		int id = this.getParaToInt("id");
		Good good = this.service.findById(id);
		good.set("type", this.getPara("type"));
		good.set("price", this.getPara("price"));
		good.set("vid", this.getPara("vid"));
		good.set("description", this.getPara("description"));
		good.set("name", this.getPara("name"));	
		good.set("img", this.getPara("img"));
		this.renderJson("result",good.update());
	}
	
	public void delete(){
		int id = this.getParaToInt("id");
		this.renderText("result: "+this.service.deleteById(id));
	}
	
	
}
