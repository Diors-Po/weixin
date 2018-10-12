package com.wxModel;

import com.jfinal.plugin.activerecord.Model;

public class Recipe extends Model<Recipe> {
	public static final Recipe dao = new Recipe().dao();
}
