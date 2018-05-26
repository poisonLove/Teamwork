package com.zktr.supermarket.view.xiaoshou;

import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.zktr.supermarket.been.DingDan;
import com.zktr.supermarket.been.DingDanXQ;
import com.zktr.supermarket.been.Goods;
import com.zktr.supermarket.service.SaleService;

public class XiaoShouView {
	private SaleService saleService;
	Scanner scan = new Scanner(System.in);

	public XiaoShouView() {
		saleService = new SaleService();
	}
	// 销售页面主页视图
	public void saleMian() {
		int tt = 0;
		boolean isTrue = true;
		while (isTrue) {
			System.out.println("欢迎进入销售系统，你可以使用下列功能");
			System.out.println("1、订单查询。\n2、开始收银。\n3、退出系统");
			System.out.print("请选择你想要使用的功能：");
			if (scan.hasNextInt()) {
				tt = scan.nextInt();
			} else {
				System.out.println("选择功能失败，请重新输入整数");
			}
			switch (tt) {
			case 1:
				querySale();
				break;
			case 2:
				shouYin("黄盼");// 开始收银
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("出现错误");
			}
			System.out.println("是否返回（y/n）");
			String str = scan.next();
			if (str.equals("n")) {
				isTrue = false;
			}
		}
	}
	/**
	 * 按照姓名查询订单方法
	 */
	public void nameCheck() {
		System.out.println("请输入查询订单的售货员姓名：");
		String name = scan.next();
		// 定义一个list来接收
		List<DingDan> listdd = saleService.conditionquery(name);
		// 输出数据
		if (listdd.size() > 0) {
			print(listdd);
		} else {
			System.out.println("对不起，没找到，请确认你输入的姓名");
		}
	}

	/**
	 * 按照订单编号查询
	 */
	public void saleCodeCheck() {
		System.out.println("请输入查询订单的编号：");
		String saleCode = scan.next();
		List<DingDan> listdd = saleService.querySaleCode(saleCode);
		if (listdd.size() > 0) {
			print(listdd);
			System.out.println("订单详情如下：");
			//显示订单详情列表
			List<DingDanXQ> listxq=saleService.queryAll(saleCode);
			printXQ(listxq);
		} else {
			System.out.println("对不起，没找到，请确认你输入的订单编号");
		}
	}

	/**
	 * 按照会员编号查询
	 */
	public void saleHytelCheck() {
		System.out.println("请输入查询订单的会员编号：");
		String saleHytel = scan.next();
		List<DingDan> listdd = saleService.querySalehytel(saleHytel);
		if (listdd.size() > 0) {
			print(listdd);
		} else {
			System.out.println("对不起，没找到，请确认你输入的会员编号");
		}
	}

	/**
	 * 订单查询功能
	 */
	public void querySale() {
		int cha = 0;
		System.out.println("选择要查询的信息。\n1、查询所有订单。\t2、按条件查询");
		if (scan.hasNextInt()) {
			cha = scan.nextInt();
		} else {
			System.out.println("选择失败，请输入整数");
		}
		// 根据输入整数来选择要执行的功能
		if (cha == 1) {
			// 定义一个list来接收逻辑层传递的list。
			List<DingDan> listDingDan = saleService.queryAll();
			// 输出数据；
			print(listDingDan);
		} else if (cha == 2) {
			int aa = 0;
			System.out.println("1、按售货员姓名查询.\t2、按订单编号查询。\t3、按会员编号查询");
			System.out.print("请输入你想使用的功能：");
			if (scan.hasNextInt()) {
				aa = scan.nextInt();
			} else {
				System.out.println("输入错误，请输入整数");
			}
			switch (aa) {
			case 1:
				nameCheck();// 按照姓名查询订单
				break;
			case 2:
				saleCodeCheck();
				break;
			case 3:
				saleHytelCheck();
				break;
			}
		}
	}
	/**
	 * 收银业务
	 * @param name
	 */
	public void shouYin(String name) {
		boolean result=true;
		double money=0;//商品总价
		double shouQian=0;//顾客给的实际金额
		String hytel=null;
		
		System.out.println("是否开始收银（1、是 2、否）");
		int input=scan.nextInt();
		if(input==1) {
			DingDan dingDan=new DingDan();
			DingDanXQ xq=null;
			//自动生成订单编号
			dingDan.setSaleCode((int)(Math.random()*999999+1)+"");
			while(result) {
				xq=new DingDanXQ();
				System.out.println("请输入商品的条形码");
				String sptxm=scan.next();
					//查询到该商品的对象，然后输出
					Goods goods=saleService.queryOne(sptxm);
					 money+=goods.getGprice();
				if(saleService.updateSpnum(goods.getGprice(),sptxm, dingDan.getSaleCode())!=true) {
					 //给订单详情类赋值
					 xq.setSpcode(dingDan.getSaleCode());
					 xq.setSptxm(sptxm);
					 xq.setSpname(goods.getGname());
					 xq.setSpjg(goods.getGprice());
					 xq.setSpsl(1);
					 if(saleService.addDingDanXq(xq)) {//向商品详情表里插入数据
						 System.out.println("扫描成功");
						 saleService.updateGoodsNum(sptxm);//扫描成功商品数量减一
					 }else {
						 System.out.println("扫描失败");
					 }
				}else {
					System.out.println("扫描成功");
					 saleService.updateGoodsNum(sptxm);//扫描成功商品数量减一
				}
					
				 System.out.println("是否继续扫描（y/n）");
				 if(scan.next().equals("n")) {
					 result=false;
				 } 
			}	 
			System.out.println("总金额是："+money);
			System.out.println("是否有会员卡（y/n）");
			if(scan.next().equals("y")) {
				System.out.println("请输入会员的电话号码后四位：");
				hytel=scan.next();
				//调用查询判断会员编号是否正确，如果正确就打折，不正确就重新输入
				money=money*0.85;
				System.out.println("打折后的金额是："+money);
			}
			System.out.println("请输入付款金额：");
			shouQian=scan.nextDouble();
			//给订单类赋值
			dingDan.setSaleName(name);
			dingDan.setSaleSpzj(money);
			dingDan.setSaleSsje(shouQian);
			dingDan.setSaleZl(shouQian-money);
			dingDan.setSaleHytel(hytel);
			if(saleService.addDingDan(dingDan)==true) {//向订单表里插入数据
				System.out.println("该订单成功完成");
				System.out.println("是否打印凭条（1、是 2、否）");
				if(scan.hasNextInt()) {
					if(scan.nextInt()==1) {
						printPinTiao(dingDan.getSaleCode(),money);//调用打印的方法
//						shouYin(name);
					}
				}else {
					System.out.println("选择错误，请输入整数");
				}
			}else {
				System.out.println("该订单未完成");
			}
			
			
		}
	}
	/**
	 * 打印凭条的方法
	 * @param salecode
	 * @param sptxm
	 */
	public void printPinTiao(String saleCode,double money) {
		List<DingDanXQ> listxq=saleService.queryAll(saleCode);
		System.out.println("订单编号："+saleCode);
		System.out.println("====================");
		System.out.println("商品名称"+"\t"+"商品数量"+"\t"+"商品价格");
		for (DingDanXQ ddxq : listxq) {
			System.out.println(ddxq.getSpname()+"\t"+ddxq.getSpsl()+"\t"+ddxq.getSpjg());
		}
		System.out.println("====================");
		System.out.println("商品的总金额："+money);
	}

/**
 *输出订单列表信息
 * @param list
 */
	public void print(List<DingDan> list) {
		System.out.println(
				"id号" + "\t" + "销售员姓名" + "\t" + "订单编号" + "\t" + "商品总价" + "\t" + "实收金额" + "\t" + "找零" + "\t" + "会员编号");
		for (DingDan dingDan : list) {
			System.out.println((dingDan.getId() + 1) + "\t" + dingDan.getSaleName() + "\t" + dingDan.getSaleCode()
					+ "\t" + dingDan.getSaleSpzj() + "\t" + dingDan.getSaleSsje() + "\t" + dingDan.getSaleZl() + "\t"
					+ dingDan.getSaleHytel());
		}
	}
	/**
	 * 输出订单详情信息
	 * @param list
	 */
	public void printXQ(List<DingDanXQ> list) {
		System.out.println("订单编号"+"\t"+"商品条形码"+"\t\t"+"商品名称"+"\t"+"商品总价"+"\t"+"商品数量");
		for(DingDanXQ xq :list) {
			System.out.println(xq.getSpcode()+"\t"+xq.getSptxm()+"\t"+xq.getSpname()+"\t"+
								xq.getSpjg()+"\t"+xq.getSpsl());
		}		
	}
	
}