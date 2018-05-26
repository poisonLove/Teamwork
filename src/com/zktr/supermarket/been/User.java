package com.zktr.supermarket.been;

import java.util.Date;

public class User {

	/**
	 * 属性
	 */
	private int id;
	private String usercode;   //编号
	private String username;   //姓名
	private String userpsw;    //密码
	private int usersex;       //性别
	private int userage;       //年龄
	private String usertel;    //电话号码
	private String useraddr;   //住址
	private String usergrade;  //职位
	private Date userruzhi;    //入职时间
	
	
	public User() {
		super();
	}
	public User(int id, String usercode, String username, String userpsw, int usersex, int userage, String usertel,
			String useraddr, String usergrade, Date userruzhi) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.userpsw = userpsw;
		this.usersex = usersex;
		this.userage = userage;
		this.usertel = usertel;
		this.useraddr = useraddr;
		this.usergrade = usergrade;
		this.userruzhi = userruzhi;
	}
	
	/**
	 * set和get方法
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpsw() {
		return userpsw;
	}
	public void setUserpsw(String userpsw) {
		this.userpsw = userpsw;
	}
	public int getUsersex() {
		return usersex;
	}
	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}
	public int getUserage() {
		return userage;
	}
	public void setUserage(int userage) {
		this.userage = userage;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}
	public String getUsergrade() {
		return usergrade;
	}
	public void setUsergrade(String usergrade) {
		this.usergrade = usergrade;
	}
	public Date getUserruzhi() {
		return userruzhi;
	}
	public void setUserruzhi(Date userruzhi) {
		this.userruzhi = userruzhi;
	}
	
	
	
}
