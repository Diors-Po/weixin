package com.wxUser;

import java.io.UnsupportedEncodingException;

import com.common.JSonUtils;
import com.wxModel.User;

public class UserService {
	
	public static final UserService me = new UserService();
	
	private User dao = new User().dao();
	
	public User findById(int id){
		return dao.findById(id);
	}
	
	public boolean deleteById(int id){
		return dao.deleteById(id);
	}
	
	//�����û�id�����¸�������
	public boolean updateById(int id, String newUserData){
		User user = User.dao.findById(id);
		try {
			user._setAttrs(JSonUtils.json2Map(newUserData));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("json2Map happened a Exception!");
		}
		
		return user.update();
	}
	
	//�������û���Ϣ���������û���id������ʧ�ܷ���-1
	public int insert(String userData){
		User user = new User();
		try {
			user._setAttrs(JSonUtils.json2Map(userData));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = -1;
		if(user.save())
			id = user.getInt("id");
		
		return id;
	}
	
	//�����û�id��ȡ�û����
	public float getHeight(int id){
		return this.findById(id).getFloat("height");
	}
}
