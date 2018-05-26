package com.zktr.supermarket.view;

import java.util.Scanner;

import com.zktr.supermarket.view.caigou.PurchaseView;
import com.zktr.supermarket.view.xiaoshou.XiaoShouView;

/**
 * 系统主界面类
 * 
 * @author asus
 *
 */
public class SystemMain {
	private XiaoShouView xiaoShouView;
	private PurchaseView purchaseView;
	Scanner scan = new Scanner(System.in);
	
	public SystemMain() {
		xiaoShouView=new XiaoShouView();
		purchaseView=new PurchaseView();		
	}
	public void login() {
		System.out.print("请输入你的用户名：");
		
		System.out.println("请输入你的密码：");

		System.out.println("请选择身份登录：");
		
	}

	public void welcome() {
		System.out.println("欢迎使用丫丫丫超市管理系统\n请先登录");
		purchaseView.purchaseMain();
		

	}

	public static void main(String[] args) {
		SystemMain sm = new SystemMain();
		sm.welcome();
	}
}