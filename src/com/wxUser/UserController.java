package com.wxUser;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.Utils;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.wxModel.Pop;
import com.wxModel.User;

public class UserController extends Controller {
	
	UserService service = UserService.me;
	
	//判断是否为第一次登录
	public void isFirstLogin(){
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		
		String openid = json.getString("openid");
		List<User> users = User.dao.find("select * from wx_user where openid = '" + openid +"'");
		int id = -1;
		String name = "";
		boolean res = true;
		if(users.size()>0){
			res = false;
			id = users.get(0).getInt("id");
			name = users.get(0).getStr("name");
			}
		
		this.setAttr("result", res);
		this.setAttr("id", id);
		this.setAttr("name", name);
		this.renderJson();
		
	}
	
	public void getOpenId(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		String code = json.getString("code");//获取登录的code
		
		System.out.println(code);
		
		String appID = Utils.getAppID();//appID
		String secret = Utils.getSecret();//SECRET
		String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		String requestUrl = WX_URL.replace("APPID", appID).replace("SECRET", secret).replace("JSCODE", code);
		
		String returnValue = Utils.GET(requestUrl);//发起请求
		
		System.out.println(returnValue);
		
		JSONObject returnJ = JSON.parseObject(returnValue);//解析请求结果
		
        String openid =String.valueOf(returnJ.get("openid"));//获取用户的唯一标识（openid）
        
		List<User> users = User.dao.find("select * from wx_user where openid = '" + openid +"'");
		int id = -1;
		String name = "";
		boolean res = true;
		if(users.size()>0){
			res = false;
			id = users.get(0).getInt("id");
			name = users.get(0).getStr("name");
			}
		this.setAttr("openid",openid);
		this.setAttr("result", res);
		this.setAttr("id", id);
		this.setAttr("name", name);
		this.renderJson();
       
	}
	
	//第一次登录的用户存入数据
	public void firstLogin(){
		String jsonString = HttpKit.readData(getRequest());
		int id = UserService.me.insert(jsonString);
		setAttr("result",id>0?true:false);
		setAttr("id", id);
		renderJson();
	}

	//进入编辑个人资料页面，根据前台请求中的用户id，返回用户当前信息
	public void edit(){
		
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		int id = json.getIntValue("id");
		
		User user = User.dao.findById(id);
		this.renderJson(user.toJson());
		
		
	}
	
	//根据新提交的数据，更新个人资料
	public void update(){
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		
		int id = json.getIntValue("id");
		this.setAttr("result", UserService.me.updateById(id, jsonString));
		this.renderJson();		
	}
	
	//由推广进来，记录推广次数
	public void doPop(){
		int id = this.getParaToInt("id");
		Pop p = Pop.dao.findById(id);
		int count = p.getInt("count")+1;
		System.out.println("count================================="+count);
		p.set("count", count);
		p.update();
		this.renderNull();
	}
	
}
