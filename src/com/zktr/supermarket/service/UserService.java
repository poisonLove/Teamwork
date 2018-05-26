/**
 * 
 */
/**
 * @author asus
 *
 */
package com.zktr.supermarket.service;

import java.util.List;
import com.zktr.supermarket.been.User;
import com.zktr.supermarket.dao.UserDao;

public class UserService{
	private UserDao userdao;
	List<User> lst1;
	
	public UserService(){
		userdao = new UserDao();
	}
	/**
	 * 
	 * @param usergrade
	 * @return
	 */
	public List<User> gradequery(String usergrade){
		lst1 = userdao.findUserOne(usergrade);
		return lst1;
	}
}