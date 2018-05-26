
package com.zktr.supermarket.view.caigou;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.zktr.supermarket.been.CaiGouDingDan;
import com.zktr.supermarket.been.CaiGouXq;
import com.zktr.supermarket.service.PurchaseService;

/**
 * 采购模块视图类
 * @author asus
 *
 */
public class PurchaseView{
	private PurchaseService pruchaseService;
	Scanner scan=new Scanner(System.in);
	public  PurchaseView() {
		pruchaseService=new PurchaseService();
	}
	
	/**
	 * 采购模块主界面
	 */
	public void purchaseMain() {
		System.out.println("欢迎登录采购主页");
		System.out.println("请选择你要使用的功能：1、采购计划\t2、采购管理\t3、采购商品");
		switch(scan.nextInt()) {
		case 1:
			purchasePlan();//采购计划
			break;
		case 2:
			 purchaseManage();//采购管理
			break;
		case 3:
			purchaseGoods();//采购商品
			break;
		default :
			System.out.println("输入错误");
		}
		
	}
	/**
	 * 采购计划
	 */
	public void purchasePlan() {
		System.out.println("请选择你想使用的功能：1、查看自动生成计划\t2、添加采购计划");
		if(scan.hasNextInt()) {
			int tt=scan.nextInt();
			if(tt>0&&tt<3) {
				switch(tt) {
				case 1:
					checkPlan();
					break;
				case 2:
					addPlan("宇宇");
					break;
				}
			}else {
				System.out.println("输入的整数只能为1和2");
			}
		}else {
			System.out.println("输入错误，请输入整数。");
		}
		
		
	}
	/**
	 * 采购管理
	 */
	public void  purchaseManage() {
		System.out.println("请选择你想使用的功能：1、查看采购订单\t2、修改采购单");
		int tt=scan.nextInt();
		switch(tt) {
		case 1:
			checkCgdd();
			break;
		case 2:
			updateCgdd();
			break;
		}
	}
	/**
	 * 采购商品
	 */
	public void purchaseGoods() {
		
	}
	/**
	 * 查看自动生成计划
	 */
	public void checkPlan() {
		List<CaiGouDingDan> lst=pruchaseService.queryAll("是");
		if(lst.size()>0) {
			System.out.println("id号"+"\t"+"采购员姓名"+"\t"+"采购编号"+"\t\t"+"采购时间"+"\t\t"+"是否完成采购"+"\t"+"是否自动生成"+"\t"+"订单金额");
			for (CaiGouDingDan cgdd : lst) {
				System.out.println(cgdd.getId()+"\t"+cgdd.getCcname()+"\t"+cgdd.getCccode()+"\t"+
									cgdd.getCcdate()+"\t"+cgdd.getCcover()+"\t\t"+cgdd.getCczd()+"\t"+cgdd.getCczje());
			}
		}else {
			System.out.println("没有自动生成的订单");
		}
	}
	/**
	 * 添加采购计划
	 */
	public void addPlan(String cgName) {
		boolean bool=true;
		double sumMoney=0;
		CaiGouDingDan caigou=new CaiGouDingDan();
		caigou.setCcname(cgName);
		caigou.setCccode((int)(Math.random()*9999999+1)+"");
		//设置时间格式为String传入数据库
		caigou.setCcdate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		caigou.setCcover(0);
		caigou.setCczd("否");
		while(bool) {
			CaiGouXq caiGouXq=new CaiGouXq();
			caiGouXq.setCgcode(caigou.getCccode());
			//设置商品条形码自动生成
			caiGouXq.setCgsptxm(new SimpleDateFormat("yyyyMMdd").format(new Date())+(int)(Math.random()*999999+1)+"");
			System.out.println("请输入采购商品的名称：");
			caiGouXq.setCgspname(scan.next());
			System.out.println("请输入商品的采购价格（元/个）");
			caiGouXq.setCgjg(scan.nextDouble());
			System.out.println("请输入采购的数量");
			caiGouXq.setCgsl(scan.nextInt());
			sumMoney+=caiGouXq.getCgsl()*caiGouXq.getCgjg();
			if(pruchaseService.addPurchaseXq(caiGouXq)) {
				System.out.println("添加成功");
				System.out.println("是否继续输入y/n");
				if(scan.next().equals("n")) {
					bool=false;
				}else {
					System.out.println("请继续输入");
				}
			}else {
				System.out.println("添加失败");
			}		
		}
		caigou.setCczje(sumMoney);
		if(pruchaseService.addPurchase(caigou)) {
			System.out.println("订单成功生成");
		}else {
			System.out.println("生成订单失败");
		}
	}
	/**
	 * 查看采购订单
	 */
	public void checkCgdd() {
		int tt=0;
		String str=null;
		System.out.println("请选择条件查询\n1、按时间查询。\n2、按采购人姓名查询\n3、按采购订单编号查询\n4、按是否完成采购查询");
		if(scan.hasNextInt()) {
			tt=scan.nextInt();
		}else {
			System.out.println("输入错误，请输入整数");
		}
		switch(tt) {
		case 1:
			str="cc_date";
			break;
		case 2:
			str="cc_name";
			break;
		case 3:
			str="cc_code";
			break;
		case 4:
			str="cc_over";
			break;
		}
		 List<CaiGouDingDan> cglist=this.checkCondition(str, tt);
		 if(cglist.size()>0) {
			 this.printcgDd(cglist);
		 }else {
			 System.out.println("对不起没找到，请确定后在输入");
		 }
		 
		
	}
	/**
	 * 按条件查询订单
	 * @param str
	 * @param tt
	 * @return
	 */
	public List<CaiGouDingDan> checkCondition(String str,int tt) {
		List<CaiGouDingDan> cglist=null;
		if(tt==1) {
			System.out.println("请输入时间：");
			cglist= pruchaseService.checkCaiGou(str, scan.next());
		}else if(tt==2) {
			System.out.println("请输入采购员姓名：");
			cglist= pruchaseService.checkCaiGou(str, scan.next());
		}else if(tt==3) {
			System.out.println("请输入采购订单编号：");
			cglist= pruchaseService.checkCaiGou(str, scan.next());
		}else if(tt==4) {
			System.out.println("请输入订单是否完成(0、未完成，1、完成)");
			cglist= pruchaseService.checkCaiGou(str, scan.next());
		}else {
			System.out.println("输入不正确，请输入1-4的整数");
			
		}
		return cglist;
	}
	/**
	 * 修改采购订单
	 */
	public void updateCgdd() {
		System.out.println("请输入采购订单的编号：");
		printcgddXq(pruchaseService.queryCaiGouXq(scan.next()));
		System.out.println("请选择你想修改的");
		
	}
	
	
	
	
	
	
	/**
	 * 打印输出采购订单
	 * @param list
	 */
	public void printcgDd(List<CaiGouDingDan> list) {
		System.out.println("id号"+"\t"+"采购员姓名"+"\t"+"采购编号"+"\t"+"采购时间"+"\t\t\t"+"采购状态"+"\t"+"是否自动生成"+"\t"+"采购金额");
		for (CaiGouDingDan cgdd : list) {
			System.out.println(cgdd.getId()+"\t"+cgdd.getCcname()+"\t"+cgdd.getCccode()+"\t"+cgdd.getCcdate()+"\t  "+
								cgdd.getCcover()+"\t     "+cgdd.getCczd()+"\t\t"+cgdd.getCczje());
		}
	}
	/**
	 * 打印采购订单详情
	 * @param list
	 */
	public void printcgddXq(List<CaiGouXq> list) {
		System.out.println("采购编号"+"\t       "+"商品条形码"+"\t"+"商品名称"+"\t"+"采购价格"+"\t"+"采购数量");
		for (CaiGouXq cgxq : list) {
			System.out.println(cgxq.getCgcode()+"\t"+cgxq.getCgsptxm()+"\t"+cgxq.getCgspname()+"\t"+cgxq.getCgjg()+"\t"+cgxq.getCgsl());
		}
	}
}