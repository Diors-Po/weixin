package com.wxModel;

import com.jfinal.plugin.activerecord.Model;

public class Article extends Model<Article> {
	public static final Article dao = new Article().dao();
}
