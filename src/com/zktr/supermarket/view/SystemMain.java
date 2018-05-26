package com.zktr.supermarket.view;

import java.util.List;
import java.util.Scanner;

import com.zktr.supermarket.been.User;
import com.zktr.supermarket.service.UserService;

/**
 * 系统主界面类
 * @author asus
 *
 */
 public class SystemMain{
	 private UserService userser;
	 boolean b = true;
	 public  SystemMain(){
		 userser = new UserService();
	 }
	
	 
	 Scanner sc = new Scanner(System.in);
	 
	 
	 //登录主页面
	 public void loginmain(){
		 
		 
		 while(b){
			 System.out.println("欢迎进入***超市管理系统！");
			 System.out.println("请选择身份登录：");
			 System.out.println("1.销售员\t2.采购员\t3.仓库管理员\t4.老板\t");
			 switch(sc.nextInt()){
			 case 1 :
				 this.zwlogin("收银员");
				 break;
			 case 2 :
				 this.zwlogin("采购员");
				 break;
			 case 3 :
				 this.zwlogin("仓库管理员");
				 break;
			 case 4 :
				 this.zwlogin("老板");
				 break;
			 default:
				 System.out.println("输入有误！请重新选择身份登录！");
			 }
			 
		 }
	 } 
	 //选择职位登录
	 public void zwlogin(String usergrade){
		 //用集合来接收消息
		
		 System.out.println("请输入您的名字：");
		 String name = sc.next();
		 System.out.println("请输入您的密码：");
		 String mm = sc.next();
		 List<User> list2 = userser.gradequery(usergrade);
		 for(int i=0;i<list2.size();i++){
			if(list2.get(i).getUsername().equals(name)){
				if(list2.get(i).getUserpsw().equals(mm)){
					System.out.println("登录成功！");
					b = false;
				}else{
					System.out.println("密码不正确！请重新登录!");
					b =true;
				}
			}
		 }
	 }
	 public static void main(String[] args) {
		 SystemMain sm = new SystemMain();
		 sm.loginmain();
	 }
	
 }