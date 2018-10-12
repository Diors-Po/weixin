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
	
	//�ж��Ƿ�Ϊ��һ�ε�¼
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
		String code = json.getString("code");//��ȡ��¼��code
		
		System.out.println(code);
		
		String appID = Utils.getAppID();//appID
		String secret = Utils.getSecret();//SECRET
		String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		String requestUrl = WX_URL.replace("APPID", appID).replace("SECRET", secret).replace("JSCODE", code);
		
		String returnValue = Utils.GET(requestUrl);//��������
		
		System.out.println(returnValue);
		
		JSONObject returnJ = JSON.parseObject(returnValue);//����������
		
        String openid =String.valueOf(returnJ.get("openid"));//��ȡ�û���Ψһ��ʶ��openid��
        
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
	
	//��һ�ε�¼���û���������
	public void firstLogin(){
		String jsonString = HttpKit.readData(getRequest());
		int id = UserService.me.insert(jsonString);
		setAttr("result",id>0?true:false);
		setAttr("id", id);
		renderJson();
	}

	//����༭��������ҳ�棬����ǰ̨�����е��û�id�������û���ǰ��Ϣ
	public void edit(){
		
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		int id = json.getIntValue("id");
		
		User user = User.dao.findById(id);
		this.renderJson(user.toJson());
		
		
	}
	
	//�������ύ�����ݣ����¸�������
	public void update(){
		String jsonString = HttpKit.readData(getRequest());
		JSONObject json = JSON.parseObject(jsonString);
		
		int id = json.getIntValue("id");
		this.setAttr("result", UserService.me.updateById(id, jsonString));
		this.renderJson();		
	}
	
	//���ƹ��������¼�ƹ����
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
