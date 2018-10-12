package com.wxAdmin;

import com.common.TimeUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class ManageService {
	public static final ManageService me = new ManageService();
	
	public Page<Record> getArticles(int pageNum,int pageSize,String state){
		Page<Record> res =  Db.paginate(pageNum, pageSize, "select a.id,time,title,details,name uname,state"
				,"from wx_article a,wx_user u where a.uid = u.id and state='"+state+"' order by time desc");
		TimeUtils.formatDateTime(res.getList());
		return res;
	}
	
}
