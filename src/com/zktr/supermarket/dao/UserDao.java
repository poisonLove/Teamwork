package com.zktr.supermarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zktr.supermarket.been.User;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.ParameterSet;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;

public class UserDao extends BaseDao{
	
	private RowData<User> user;
	
	public UserDao(){
		user = new UserData();
	}
	/**
	 * 新增员工
	 * @param user
	 * @return
	 */
	public int addUser(User user){
		String sql = "insert into dbuser(user_code,user_name,user_password,user_sex,user_age,user_tel,user_addr,user_grade,user_ruzhi)"
	         +"values(?,?,?,?,?,?,?,?,?,?)";
		return update(sql,new Parameterimpl(user.getUsercode(),user.getUsername(),user.getUserpsw(),user.getUsersex(),user.getUserage(),
				                            user.getUsertel(),user.getUseraddr(),user.getUsergrade(),user.getUserruzhi()));  
		
	}
	
	/**
	 * 根据职位查询员工信息
	 */
	public List<User> findUserOne(String usergrade){
		String sql ="select * from dbuser where user_grade=?";
        Parameterimpl p = new Parameterimpl(usergrade);
		return queryAll(sql,user,p);
		
	}


	
	/**
	 *  获取所有员工信息
	 * @return
	 */
	public List<User> findUserAll(){
		String sql ="select * from dbuser";		
		return queryAll(sql, user, null);
	}
	
	/**
     *定义一个成员内部类，实现数据处理接口
	 * 将表中的数据与对象进行映射
	 */
	private class UserData implements RowData<User>{

		@Override
		public User getData(ResultSet rs) throws SQLException {
			// 创建一个员工对象
			User user = new User();
			//给员工对象进行赋值
			user.setId(rs.getInt("id"));
			user.setUsercode(rs.getString("user_code"));
			user.setUsername(rs.getString("user_name"));
			user.setUserpsw(rs.getString("user_password"));
			user.setUsersex(rs.getInt("user_sex"));
			user.setUserage(rs.getInt("user_age"));
			user.setUsertel(rs.getString("user_tel"));
			user.setUseraddr(rs.getString("user_addr"));
			user.setUsergrade(rs.getString("user_grade"));
			user.setUserruzhi(rs.getDate("user_ruzhi"));
			return user;
		}
		
	}
}