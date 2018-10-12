package com.wxAdmin;

import java.io.IOException;

import com.alibaba.druid.util.Utils;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;


public class LoginController extends Controller {
	
	public void test(){
		this.setSessionAttr("isLogin", "yes");
		this.redirect("/admin/manage");
	}
	
	
	public void index(){
		render("index.html");
	}
	
	public void login(){
		String name = this.getPara("name");
		String password = Utils.md5(this.getPara("password"));
		String right = Db.findFirst("select password from wx_admin where name='"+name+"'").getStr("password");
		if(password.equals(right)){
			this.setAttr("flag",true);
			this.setSessionAttr("isLogin", "yes");
			this.getSession().setMaxInactiveInterval(1800);
			this.setAttr("msg", "��¼�ɹ�");
			}
		else{
			this.setAttr("flag", false);
			this.setAttr("msg", "�˺�/������󣡣���");
		} 	
		this.renderJson();

	}
	
	@Before(LoginInterception.class)
	public void manage(){		
		this.redirect("/manage/index");
	}
	
	public void logout(){
		this.removeSessionAttr("isLogin");
		this.redirect("/admin");
	}
	
	public void newPwd(){
		this.render("changepwd.html");
	}
	
	public void changePwd(){
		String pwd = Utils.md5(this.getPara("password"));
		System.out.println("������"+pwd);
		int res = Db.update("update wx_admin set password = '"+pwd+"' where name = 'admin'");
		System.out.println(res+"����Ӱ��");
		if(res>0)
			this.renderText("�����޸ĳɹ���");
		else
			this.renderText("�����޸�ʧ�ܣ�");
	}
}
