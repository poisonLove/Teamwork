package com.zktr.supermarket.view;

import java.util.Scanner;

/**
 * 系统主界面类
 * 
 * @author asus
 *
 */
public class SystemMain {
	Scanner scan = new Scanner(System.in);

	public void login() {
		System.out.print("请输入你的用户名：");

		System.out.println("请输入你的密码：");

		System.out.println("请选择身份登录：");
		
	}

	public void welcome() {
		System.out.println("欢迎使用丫丫丫超市管理系统\n请先登录");
		

	}

	public static void main(String[] args) {
		SystemMain sm = new SystemMain();
		sm.welcome();
	}
}