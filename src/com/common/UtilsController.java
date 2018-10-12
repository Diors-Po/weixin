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
			if(sex.equals("女"))
				GFR*=0.85;
			
			if(GFR>=90)
				this.setAttr("advice", "您当前属于肾病第一期，肾损伤指标（+），GFR无异常，重点诊治原发病");
			else if(GFR>=60 && GFR<90)
				this.setAttr("advice", "您当前属于肾病第二期，肾损伤指标（+），GFR轻度降，应减慢CKD进展，降低心血管病风险");
			else if(GFR>=30 && GFR<60)
				this.setAttr("advice", "您当前属于肾病第三期，GFR中度降，应减慢CKD进展，评估治疗并发症");
			else if(GFR>=15 && GFR<30)
				this.setAttr("advice", "您当前属于肾病第四期，GFR重度降，应采取综合治疗，治疗并发症");
			else 
				this.setAttr("advice", "您当前属于肾病第五期，肾衰竭，应进行透析前准备及透析治疗");
	
			this.setAttr("GFR", GFR);
			this.renderJson();
		}
	}
	
	
	
}
