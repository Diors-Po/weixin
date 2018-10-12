package com.wxConfig;


import com.common.UtilsController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.AnsiSqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.sun.org.apache.bcel.internal.generic.POP;
import com.wxAdmin.LoginController;
import com.wxAdmin.LoginInterception;
import com.wxAdmin.ManageController;
import com.wxAdmin.UserManageController;
import com.wxArticle.ArticleController;
import com.wxDiary.DiaryController;
import com.wxGoods.GoodController;
import com.wxModel.Article;
import com.wxModel.Bought;
import com.wxModel.Diary;
import com.wxModel.Good;
import com.wxModel.Medicine;
import com.wxModel.Pop;
import com.wxModel.Recipe;
import com.wxModel.Recipe_old;
import com.wxModel.ScoreRecord;
import com.wxModel.User;
import com.wxRecipe.RecipeController;
import com.wxRecipes_old.Recipe_OldController;
import com.wxScore.ScoreController;
import com.wxUser.UserController;
import wxMedicine.MedicineController;

public class MyConfig extends JFinalConfig {
	

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		
		PropKit.use("db.config");
		
		me.setBaseUploadPath("img");//配置文件默认上传路径
		
	//	me.setJsonFactory(new FastJsonFactory());
		
		me.setDevMode(true);
		//me.setDevMode(PropKit.getBoolean("devmode", false));
	}
	
	
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/user",UserController.class);
		me.add("/score",ScoreController.class);
		me.add("/diary",DiaryController.class);
		me.add("/article",ArticleController.class);
		me.add("/good",GoodController.class);
		me.add("/recipe",RecipeController.class);
		me.add("/medicine",MedicineController.class);
		me.add("/utils",UtilsController.class);
		
		me.add("/admin",LoginController.class);
		me.add("/manage",ManageController.class);
		me.add("/userManage",UserManageController.class);
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		me.addSharedFunction("/manage/_paginate.html");
	}

	/**
	 * 配置插件
	 */
	public static DruidPlugin createDruidPlugin(){
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"),
				PropKit.get("password").trim());
	}
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		//配置数据库连接池插件
		DruidPlugin dp = this.createDruidPlugin();
		me.add(dp);
		
		//配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		me.add(arp);
		
		//设置方言
		arp.setDialect(new AnsiSqlDialect());
		
		//配置映射
		arp.addMapping("wx_user", User.class);
		arp.addMapping("score_record", ScoreRecord.class);
		arp.addMapping("wx_diary", Diary.class); 
		arp.addMapping("wx_article", Article.class);
		arp.addMapping("wx_bought", Bought.class);
		arp.addMapping("wx_goods", Good.class);
		//arp.addMapping("wx_recipes", Recipe_old.class);
		arp.addMapping("wx_medicine", Medicine.class);
		arp.addMapping("wx_recipe", Recipe.class);
		arp.addMapping("wx_pop", Pop.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
