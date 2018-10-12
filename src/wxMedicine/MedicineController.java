package wxMedicine;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Medicine;

public class MedicineController extends Controller {
	private MedicineService service = MedicineService.me;
	
	public void index(){
		int uid = this.getParaToInt("uid");
		List<Record> res = Db.find("select keyword from wx_searchHis where type='medicines_search' and uid="
				+uid+" group by keyword limit 5");
		String[] keywords = new String[res.size()];
		for(int i=0;i<res.size();i++)
			keywords[i] = res.get(i).getStr("keyword");
		this.setAttr("keywords",keywords);
		this.setAttr("allmedicine",this.service.getAll());
		this.renderJson();
	}
	
	public void search(){
		JSONObject json = JSON.parseObject(HttpKit.readData(getRequest()));
		int uid = json.getIntValue("uid");
		String keyword = json.getString("keyword");
		if(keyword==null || "".equals(keyword.trim()))
			this.renderJson("medicines",this.service.getAll());
		else
			this.renderJson("medicines",this.service.searchMedicine(uid,keyword));
	}
	
	public void add(){
		Medicine m = new Medicine();
		m.set("name", this.getPara("name"));
		m.set("tag", this.getPara("tag"));
		m.set("details", this.getPara("details"));
		this.renderJson("result",m.save());
	}
	
	public void delete(){}
	
	public void update(){}
	
	
}
