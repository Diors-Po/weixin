package com.wxModel;

import com.jfinal.plugin.activerecord.Model;

public class Diary extends Model<Diary> {
	public static final Diary dao = new Diary().dao();
}
