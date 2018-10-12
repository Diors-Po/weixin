package com.wxModel;

import com.jfinal.plugin.activerecord.Model;

public class Good extends Model<Good> {
	public static final Good dao = new Good().dao();
}
