package com.wxModel;

import com.jfinal.plugin.activerecord.Model;

public class Medicine extends Model<Medicine> {
	public static final Medicine dao = new Medicine().dao();
}
