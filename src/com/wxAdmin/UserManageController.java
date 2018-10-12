package com.wxAdmin;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Article;
import com.wxModel.Good;
import com.wxModel.ScoreRecord;
import com.wxModel.User;
import com.wxScore.ScoreService;

@Before(LoginInterception.class)
public class UserManageController extends Controller {
	
	ManageService service = ManageService.me;
	
	//������Ϣ����
	public void user(){
		int pageNum = this.getParaToInt()==null?1:this.getParaToInt();
		System.out.println(pageNum);
		Page<User> res = User.dao.paginate(1, 20, "select *,TIMESTAMPDIFF(YEAR, birthday, CURDATE()) age ", "from wx_user order by id desc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("userPage", res);
		render("user.html");
	}
	
	public void nextUserPage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		int totalPage = this.getParaToInt(1);
		if(pageNum<totalPage)
			pageNum++;
		Page<User> res = User.dao.paginate(pageNum, 20, "select *,TIMESTAMPDIFF(YEAR, birthday, CURDATE()) age ", "from wx_user order by id desc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("userPage", res);
		render("user.html");
	}
	
	public void preUserPage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		if(pageNum>1)
			pageNum--;
		Page<User> res = User.dao.paginate(pageNum, 20, "select *,select *,TIMESTAMPDIFF(YEAR, birthday, CURDATE()) age ", "from wx_user order by id desc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("userPage", res);
		render("user.html");
	}
	
	
	public void deleteUser(){
		int id = this.getParaToInt();
		User.dao.deleteById(id);
		user();
	}
	
	
	//���ѷ������¹���
	public void article(){
		Integer para = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		
		if(para==1){//1�����ѯͨ����˵����ݣ����ѷ���ҳ��
			
			Page<Record> res = this.service.getArticles(1,5,"���ͨ��");
			this.setAttr("pageNum", res.getPageNumber());
			this.setAttr("totalPage", res.getTotalPage());
			this.setAttr("articlePage", res);
			render("article.html");
		}
		else if(para==0){//0�����ѯ����˼�δͨ�������ݣ���˷���ҳ��
			
			Page<Record> res = this.service.getArticles(1,5,"�����");
			this.setAttr("pageNum", res.getPageNumber());
			this.setAttr("totalPage", res.getTotalPage());
			this.setAttr("reviewPage", res);
			
			Page<Record> res1 = this.service.getArticles(1,5,"���δͨ��");
			this.setAttr("pageNum1", res1.getPageNumber());
			this.setAttr("totalPage1", res1.getTotalPage());
			this.setAttr("reviewPage1", res1);
			
			render("review.html");
		}
		
	}
	
	public void preArticlePage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		String op = this.getPara(1)==null?"article":this.getPara(1);
		if(pageNum>1)
			pageNum--;
		if(op.equals("article")){
			Page<Record> res = this.service.getArticles(pageNum,5,"���ͨ��");
			this.setAttr("pageNum", res.getPageNumber());
			this.setAttr("totalPage", res.getTotalPage());
			this.setAttr("articlePage", res);
			render("article.html");
		}else {
			Page<Record> res;
			Page<Record> res1;
			if(op.equals("review")){
				int pageNum1 = this.getParaToInt(2);
				res = this.service.getArticles(pageNum,5,"�����");
				res1 = this.service.getArticles(pageNum1,5,"���δͨ��");
			}else{
				int pageNum1 = this.getParaToInt(2);
				res = this.service.getArticles(pageNum1,5,"�����");
				res1 = this.service.getArticles(pageNum,5,"���δͨ��");
			}
			this.setAttr("pageNum", res.getPageNumber());
			this.setAttr("totalPage", res.getTotalPage());
			this.setAttr("reviewPage", res);
			
			
			this.setAttr("pageNum1", res1.getPageNumber());
			this.setAttr("totalPage1", res1.getTotalPage());
			this.setAttr("reviewPage1", res1);
			render("review.html");
		}
		
	}
	
	public void nextArticlePage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		int totalPage = this.getParaToInt(1);
		String op = this.getPara(2)==null?"article":this.getPara(2);
		
		if(pageNum<totalPage)
			pageNum++;
		if(op.equals("article")){
			Page<Record> res = this.service.getArticles(pageNum,5,"���ͨ��");
			this.setAttr("pageNum", res.getPageNumber());
			this.setAttr("totalPage", res.getTotalPage());
			this.setAttr("articlePage", res);
			render("article.html");
		}else{
			Page<Record> res;
			Page<Record> res1;
			if(op.equals("review")){
				int pageNum1 = this.getParaToInt(3);
				res = this.service.getArticles(pageNum,5,"�����");
				res1 = this.service.getArticles(pageNum1,5,"���δͨ��");
			}else{
				int pageNum1 = this.getParaToInt(3);
				res = this.service.getArticles(pageNum1,5,"�����");
				res1 = this.service.getArticles(pageNum,5,"���δͨ��");
			}
			this.setAttr("pageNum", res.getPageNumber());
			this.setAttr("totalPage", res.getTotalPage());
			this.setAttr("reviewPage", res);
			
			
			this.setAttr("pageNum1", res1.getPageNumber());
			this.setAttr("totalPage1", res1.getTotalPage());
			this.setAttr("reviewPage1", res1);
			render("review.html");
		}
	}
	
	public void deleteArticle(){
		int id = this.getParaToInt(0);
		int srcPage = this.getParaToInt(1);
		Article.dao.deleteById(id);
		this.redirect("/userManage/article/"+srcPage);
	}
	
	public void updateArticle(){
		int id = this.getParaToInt(0);
		String statePara = this.getPara(1);
		String state;
		switch(statePara){
		case "waitreview":state="�����";break;
		case "nopass":state="���δͨ��";break;
		case "pass":state="���ͨ��";break;
		default:state="�����";
		}
		System.out.println(state);

		int srcPage = this.getParaToInt(2);
		Article article = Article.dao.findById(id);

		article.set("state", state);
		article.update();
		
		if(statePara.equals("pass")){
			int uid = article.getInt("uid");
			String cause = "�������£�"+article.getStr("title")+"��";
			if(ScoreRecord.dao.find("select * from score_record where uid="+uid+" and cause = '"+cause+"'").size()<=0)
				ScoreService.me.insertRecord(article.getInt("uid"), 100, cause);
		}
		
		this.redirect("/userManage/article/"+srcPage);
	}
}
