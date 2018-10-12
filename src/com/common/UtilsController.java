package com.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;

public class UtilsController extends Controller {
	
	public void getGFR(){
		JSONObject json = JSON.parseObject(HttpKit.readData(this.getRequest()));
		if((json.getString("age")==null)||(json.getString("weight")==null)||(json.getString("scr")==null))
		{
			this.setAttr("res", false);
			this.renderJson();
		}else{
			int age = json.getIntValue("age");
			float weight = json.getFloatValue("weight");
			float SCR = json.getFloatValue("scr") / (float)88.41;
			String sex = json.getString("sex");
			
			float GFR = ((140-age)*weight)/(SCR*72);
			if(sex.equals("Ů"))
				GFR*=0.85;
			
			if(GFR>=90)
				this.setAttr("advice", "����ǰ����������һ�ڣ�������ָ�꣨+����GFR���쳣���ص�����ԭ����");
			else if(GFR>=60 && GFR<90)
				this.setAttr("advice", "����ǰ���������ڶ��ڣ�������ָ�꣨+����GFR��Ƚ���Ӧ����CKD��չ��������Ѫ�ܲ�����");
			else if(GFR>=30 && GFR<60)
				this.setAttr("advice", "����ǰ�������������ڣ�GFR�жȽ���Ӧ����CKD��չ���������Ʋ���֢");
			else if(GFR>=15 && GFR<30)
				this.setAttr("advice", "����ǰ�������������ڣ�GFR�ضȽ���Ӧ��ȡ�ۺ����ƣ����Ʋ���֢");
			else 
				this.setAttr("advice", "����ǰ�������������ڣ���˥�ߣ�Ӧ����͸��ǰ׼����͸������");
	
			this.setAttr("GFR", GFR);
			this.renderJson();
		}
	}
	
	
	
}
