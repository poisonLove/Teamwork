/**
 * 
 */
/**
 * @author asus
 *
 */
package com.zktr.supermarket.view.cangku;

import java.util.List;
import java.util.Scanner;
import com.zktr.supermarket.been.RuKu;
import com.zktr.supermarket.been.RuKuXQ;
import com.zktr.supermarket.service.RuKuService;

public class CangKuPanDian{
	private RuKuService rkser; //入库
	boolean b = true;
	Scanner sc = new Scanner(System.in);
	
	public CangKuPanDian(){
		//实例化
		rkser = new RuKuService();
	}
	/**
	 * 盘点总界面
	 */
	public void pdMain(){
		
		while(b){
			
			System.out.println("欢迎进入仓库盘点界面！");
			System.out.println("1.商品入库查询\t2.商品出库查询\t3.商品库存查询\t4.退出");
			System.out.println("请选择您需要使用的功能：");
				switch(sc.nextInt()){
				case 1 :
					this.rkquery();
					break;
				case 2 :
					this.ckquery();
					break;
				case 3 :
					this.kcquery();
					break;
				case 4 :
					break;
				default:
					System.out.println("输入错误！请重新输入！");
				}
			
		}
		
	}
	/*
	 * 商品入库查询
	 */
	public void rkquery(){
		List<RuKu> rk = rkser.queryByAll();//接收所有入库信息
		System.out.println("欢迎进入商品入库查询界面！");
		System.out.println("以下为所有入库信息：");
		for(int i = 0;i<rk.size();i++){
			System.out.println("入库编号："+rk.get(i).getRkcode()+"   "+rk.get(i).getRkxqcode());
		}
		System.out.print("请输入您需要查询的入库编号：");
		String rkc = sc.next();
		for(int r=0;r<rk.size();r++){
			if(rk.get(r).getRkcode().equals(rkc)){
				System.out.println("以下为该入库编号的入库详情：");
				System.out.println("入库详情编号   入库商品编号    入库商品数量        入库时间");
				List<RuKu> rk2 = rkser.codeQuery(rkc);
				for(int i = 0;i<rk2.size();i++){
					List<RuKuXQ> rkxq = rkser.xqcodeQuery(rk2.get(i).getRkxqcode());
					for (RuKuXQ rr : rkxq) {
						System.out.println("  "+rr.getRkxqcode()+"   "+rr.getRkxqgcode()+"   "+rr.getRkxqgnum()+"    "+rr.getRkxqtime());
					}
				}
				System.out.println("查找完毕！请选择：");
				System.out.println("1.继续查找\t2.退出");
				switch(sc.nextInt()){
				case 1 :
					this.rkquery();
				case 2 :
					this.pdMain();
				default:
					System.out.println("输入错误！请重新输入！");
				}
			}else{
				System.out.println("查找不到该编号的入库详情！请选择：");
				System.out.println("1.继续查找\t2.退出");
				switch(sc.nextInt()){
			    case 1 :
					this.rkquery();
				case 2 :
					this.pdMain();
				default:
					System.out.println("输入错误！请重新输入！");
				}
			}		
		}
	}


	/*
	 * 商品出库查询
	 */
	public void ckquery(){
		
	}
	/*
	 * 商品库存查询
	 */
	public void kcquery(){
		
	}
	public static void main(String[] args) {
		CangKuPanDian ckpd = new CangKuPanDian();
		ckpd.pdMain();
	}
}