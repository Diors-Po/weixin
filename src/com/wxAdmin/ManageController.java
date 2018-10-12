package com.wxAdmin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.Utils;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.wxModel.Good;
import com.wxModel.Medicine;
import com.wxModel.Pop;
import com.wxModel.Recipe;
@Before(LoginInterception.class)
public class ManageController extends Controller {
	
	//首页
	public void index(){
		render("index.html");
	}
	
	public void main(){
		this.setAttr("userCount", Db.find("select * from wx_user").size());
		this.setAttr("shareCount",  Db.find("select * from wx_article").size());
		this.setAttr("videoCount",  Db.find("select * from wx_goods where type = 'video'").size());
		this.setAttr("recipeCount", Db.find("select * from wx_recipe").size()); 
		this.setAttr("medicineCount", Db.find("select * from wx_medicine").size());
		render("main.html");
	}
	
	//视频管理相关
	public void videoManage(){
		//int currPage = this.getParaToInt();
		int pageNum = this.getParaToInt()==null?1:this.getParaToInt();
		System.out.println(pageNum);
		Page<Good> res = Good.dao.paginate(1, 5, "select *", "from wx_goods order by id asc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("videoPage", res);
		render("video.html");
		
	}
	
	public void preVideoPage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		if(pageNum>1)
			pageNum--;
		Page<Good> res = Good.dao.paginate(pageNum, 5, "select *", "from wx_goods order by id asc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("videoPage", res);
		render("video.html");
	}
	
	public void nextVideoPage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		int totalPage = this.getParaToInt(1);
		if(pageNum<totalPage)
			pageNum++;
		Page<Good> res = Good.dao.paginate(pageNum, 5, "select *", "from wx_goods order by id asc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("videoPage", res);
		render("video.html");
	}
	
	public void videoEdit(){
		String op = this.getPara(0);
		if(op.equals("add"))
			render("addvideo.html");
		else{
			Integer id = this.getParaToInt(0);
			if(id!=null){
				Good good = Good.dao.findById(id);
				this.setAttr("this", good);
				render("updatevideo.html");
			}
			
		}
	}
	
	public void videoAdd(){
		UploadFile image = this.getFile("img");
		String img;
		if(image!=null)
			 img = "/img/"+image.getFileName();
		else
			 img = "/img/1.jpg";
		
		Good good = new Good();
		good.set("name", this.getPara("name"));
		good.set("type", "video");
		good.set("vid", this.getPara("vid"));
		good.set("description", this.getPara("description"));
		good.set("price", this.getParaToInt("price"));
		good.set("img", img);
		good.save();
		this.redirect("/manage/videoManage");
	}
	
	public void videoUpdate(){
		UploadFile image = this.getFile("img");
		int id = getParaToInt("id");
		Good good = Good.dao.findById(id);
		good.set("name", this.getPara("name"));
		good.set("vid", this.getPara("vid"));
		good.set("description", this.getPara("description"));
		good.set("price", this.getParaToInt("price"));
		
		if(image!=null)
			good.set("img", "/img/"+image.getFileName());
		good.update();
		this.redirect("/manage/videoManage");
	}
	
	public void videoDelete(){
		int id = this.getParaToInt();
		Good.dao.deleteById(id);
		this.redirect("/manage/videoManage");
	}
	
	//菜谱管理相关
	public void recipeManage(){
		//int currPage = this.getParaToInt();
		int pageNum = this.getParaToInt()==null?1:this.getParaToInt();
		System.out.println(pageNum);
		Page<Recipe> res = Recipe.dao.paginate(1, 20, "select *", "from wx_recipe order by id asc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("recipePage", res);
		render("recipe.html");
		
	}
	//菜谱翻页-上一页
	public void preRecipePage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		if(pageNum>1)
			pageNum--;
		Page<Good> res = Good.dao.paginate(pageNum, 20, "select *", "from wx_recipe order by id asc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("recipePage", res);
		render("recipe.html");
	}
	
	//菜谱翻页-下一页
	public void nextRecipePage(){
		int pageNum = this.getParaToInt(0)==null?1:this.getParaToInt(0);
		int totalPage = this.getParaToInt(1);
		if(pageNum<totalPage)
			pageNum++;
		Page<Good> res = Good.dao.paginate(pageNum, 20, "select *", "from wx_recipe order by id asc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("recipePage", res);
		render("recipe.html");
	}
	
	//删除菜谱（按id）
	public void recipeDelete(){
		int id = this.getParaToInt();
		Recipe.dao.deleteById(id);
		this.redirect("/manage/recipeManage");
	}
	
	//菜谱编辑-判断添加/更新
	public void recipeEdit(){
		String op = this.getPara(0);
		if(op.equals("add"))
			render("addrecipe.html");
		else{
			Integer id = this.getParaToInt(0);
			if(id!=null){
				Recipe recipe = Recipe.dao.findById(id);
				this.setAttr("this", recipe);
				render("updaterecipe.html");
			}
			
		}
	}
	
	//添加菜谱
	public void recipeAdd(){
		UploadFile image = this.getFile("img");
		String img;
		if(image!=null)
			 img = "/img/"+image.getFileName();
		else
			 img = "/img/recipe_no_img.jpg";
		
		Recipe recipe = new Recipe();
		recipe.set("name", this.getPara("name"));
		recipe.set("suitpeople", this.getPara("suitpeople"));
		recipe.set("vid", this.getPara("vid"));
		recipe.set("method", this.getPara("method"));
		recipe.set("material", this.getPara("material"));
		recipe.set("img", img);
		recipe.save();
		this.redirect("/manage/recipeManage");
	}
	
	//更新菜谱
	public void recipeUpdate(){
		UploadFile image = this.getFile("img");
		int id = getParaToInt("id");
		Recipe recipe = Recipe.dao.findById(id);
		recipe.set("name", this.getPara("name"));
		recipe.set("suitpeople", this.getPara("suitpeople"));
		recipe.set("vid", this.getPara("vid"));
		recipe.set("method", this.getPara("method"));
		recipe.set("material", this.getPara("material"));
		
		if(image!=null)
			recipe.set("img", "/img/"+image.getFileName());
		recipe.update();
		this.redirect("/manage/recipeManage");
	}
	
	//药品管理相关接口
	//主页面
	public void medicineManage(){
		int pageNum = this.getParaToInt()==null?1:this.getParaToInt();
		System.out.println(pageNum);
		Page<Medicine> res = Medicine.dao.paginate(1, 20, "select *", "from wx_medicine order by id asc");
		this.setAttr("pageNum", res.getPageNumber());
		this.setAttr("totalPage", res.getTotalPage());
		this.setAttr("medicinePage", res);
		render("medicine.html");
	}
	
	//根据id删除药品信息
	public void medicineDelete(){
		int id = this.getParaToInt();
		Medicine.dao.deleteById(id);
		this.redirect("/manage/medicineManage");
	}
	
	//菜谱编辑-判断添加/更新
	public void medicineEdit(){
		String op = this.getPara(0);
		if(op.equals("add"))
			render("addmedicine.html");
		else{
			Integer id = this.getParaToInt(0);
			if(id!=null){
				Medicine medicine = Medicine.dao.findById(id);
				this.setAttr("this", medicine);
				render("updatemedicine.html");
			}
			
		}
	}
	
	//添加药品信息
	public void medicineAdd(){
		UploadFile image = this.getFile("img");
		String img;
		if(image!=null)
			 img = "/img/"+image.getFileName();
		else
			 img = "/img/medicine_no_img.jpg";
		
		Medicine medicine = new Medicine();
		medicine.set("name", this.getPara("name"));
		medicine.set("details", this.getPara("details"));
		medicine.set("img", img);
		medicine.save();
		this.redirect("/manage/medicineManage");
	}
	
	//更新药品信息
	public void medicineUpdate(){
		UploadFile image = this.getFile("img");
		int id = getParaToInt("id");
		Medicine medicine = Medicine.dao.findById(id);
		medicine.set("name", this.getPara("name"));
		medicine.set("details", this.getPara("details"));
		
		if(image!=null)
			medicine.set("img", "/img/"+image.getFileName());
		medicine.update();
		this.redirect("/manage/medicineManage");
	}
	
	public void test2(){
		String path = PathKit.getWebRootPath();
		System.out.println(path);
	}
	
	//推广情况相关接口
	//新增推广人员
	public void popAdd(){
		
		String name = this.getPara("name");
		Pop p = new Pop();
		
		p.set("name", name);
		p.save();
		
		
		//生成二维码
		try{
			Map<String, Object> params = new HashMap<>();
			System.out.println("ID-------------------------------"+p.getInt("id"));
		    params.put("path", "pages/index/index?id="+p.getInt("id")); //位置
		    params.put("width", 430);
		    CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		    String url = Utils.getAqrURL()+Utils.getAccessToken();
		    //System.out.println(url);
			HttpPost httpPost = new HttpPost(url);
			
			
			httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
	        String body = JSON.toJSONString(params); 
	        //System.out.println(body);
	        StringEntity entity;
	        entity = new StringEntity(body);
	        entity.setContentType("image/jpeg");
	        httpPost.setEntity(entity);
	        HttpResponse response;
	        response = httpClient.execute(httpPost);
	        InputStream in = response.getEntity().getContent();
	        
            File test = new File(PathKit.getWebRootPath()+"/img/qrcode/"+name+".jpg");
            if(!test.exists())
            	test.createNewFile();
            OutputStream os = new FileOutputStream(test);
            int len=0;
            byte[] arr = new byte[1024];
            while ((len = in.read(arr)) != -1)
            {
                os.write(arr, 0, len);

            }
            os.flush();
            os.close();
		}catch(Exception e){
			e.printStackTrace();
			renderText("添加失败！！！！！！！！");
		}
		
		this.redirect("/manage/pop");
		
	}
	
	public void pop(){
		List<Record> res = Db.find("select * from wx_pop");
		this.setAttr("popPage", res);
		this.render("pop.html");
	}
	
	public void popDelete(){
		int id = this.getParaToInt(0);
		Db.delete("delete from wx_pop where id = "+id);
		this.redirect("/manage/pop");
	}
	

	
	
	
}
