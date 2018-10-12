package com.wxAdmin;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class LoginInterception implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		Controller co = inv.getController();
		HttpSession ss =co.getSession();
		if(ss==null){
			System.out.println("ss is null");
			co.redirect("/admin");
			}
		else if((ss.getAttribute("isLogin")==null)||!"yes".equals((String)ss.getAttribute("isLogin"))){
			System.out.println("isLogin is null or wrong");
			co.redirect("/admin");
		}else{
			inv.invoke();
			System.out.println("isLogin:"+ss.getAttribute("isLogin"));
		}
		
	}

}
