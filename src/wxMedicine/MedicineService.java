package wxMedicine;

import java.util.List;

import com.common.TimeUtils;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wxModel.Medicine;
import com.wxModel.Recipe;
import com.wxModel.Recipe_old;

public class MedicineService {
	public static final MedicineService me = new MedicineService();
	private Medicine dao = Medicine.dao;
	
	public Medicine findById(int id){
		return dao.findById(id);
	}
	
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	//查询所有的药物信息
	public List<Medicine> getAll(){
		return dao.find("select * from wx_medicine");
	}
	
	public List<Medicine> searchMedicine(int uid, String keyword){
		Record record = new Record();
		record.set("uid", uid);
		record.set("keyword", keyword);
		record.set("type", "medicines_search");
		record.set("time", TimeUtils.getDateTime());
		Db.save("wx_searchHis", record);
		
		String[] keywords = keyword.trim().split(" ");
		for(String s : keywords){
			s = s.trim();
			//System.out.println("-"+s+"-");
		}
		
		/*
		String sql = "";
		for(int i=0; i<keywords.length-1;i++){
			String tem = keywords[i].trim();
			sql += "select * from wx_medicine where name like '%"+tem+"%' or details like '%"+tem+"%' union ";
		}
		sql+="select * from wx_medicine where name like '%"+keywords[keywords.length-1].trim()+"%' or details like '%"+keywords[keywords.length-1].trim()+"%'";
		
		List<Medicine> res = dao.find(sql);
		return res;*/
		List<Medicine> res = dao.find("select * from wx_medicine");
		for(int i=res.size()-1;i>=0;i--){
			Medicine tem = res.get(i);
			//System.out.println("tem"+i+tem);
			for(int j=0;j<keywords.length;j++){
				boolean f1 = (!(tem.getStr("name")==null))&&tem.getStr("name").contains(keywords[j]);
				boolean f2 = (!(tem.getStr("details")==null))&&tem.getStr("details").contains(keywords[j]);

				//System.out.println(f1+"-"+f2+"-"+f3+"-"+f4);
				if(!(f1||f2)){
					res.remove(i);
					//System.out.println(i);
					break;
				}
				
			}
		}
		
		System.out.println(res.size());
		return res;
		
		
		
		
	}
	
	
}
