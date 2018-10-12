package com.wxModel;

import com.jfinal.plugin.activerecord.Model;

public class ScoreRecord extends Model<ScoreRecord> {
	public static final ScoreRecord dao = new ScoreRecord().dao();
}
