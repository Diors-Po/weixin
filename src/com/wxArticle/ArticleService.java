package com.wxArticle;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.common.JSonUtils;
import com.common.TimeUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Article;

public class ArticleService {
	public static final ArticleService me = new ArticleService();
	private Article dao = Article.dao;
	
	//��������id��������
	public Article findById(int id){
		return dao.findById(id);
	}
	
	//ɾ������
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	//��ȡȫ�����ͨ��������
	public List<Record> getAll(){
		String sql = "select a.id,time,title,details,name username "
				+ "from wx_article a,wx_user u where a.uid = u.id and state='���ͨ��' order by time desc";
		List<Record> res = Db.find(sql);
		TimeUtils.formatDateTime(res);
		return res;
	}
	
	//�����û�uid��ȡ����
	public List<Record> getMyArticle(int uid){
		String sql = "select * from wx_article where uid = "+ uid +" order by time desc";
		List<Record> res = Db.find(sql);
		TimeUtils.formatDateTime(res);
		return res;
	}
	
	//����µ�����
	public boolean insertArticle(String data){
		Article article = new Article();
		try {
			article._setAttrs(JSonUtils.json2Map(data));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		article.set("time", TimeUtils.getDateTime());
		article.set("state", "�����");
		return article.save();
	}
	
	//�޸���������
	public boolean updateArticle(int id, String newData){
		Article article = dao.findById(id);
		try {
			article._setAttrs(JSonUtils.json2Map(newData));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		article.set("time", TimeUtils.getDateTime());
		article.set("state", "�����");
		return article.update();
	}
	
	
	
	
	
	
}
