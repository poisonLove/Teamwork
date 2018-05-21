package com.zktr.supermarket.been;
/**
 * 订单的javaBeen类
 * @author 黄盼
 *
 */
public class DingDan{
	private int id;			  //id号
	private String saleName;  //销售员姓名
	private String saleCode;  //订单编号
	private double saleSpzj;  //商品总价
	private double saleSsje;  //实收金额
	private double saleZl;   //找零
	private String saleHytel; //会员电话
	
	public DingDan() {
		super();
	}

	public DingDan(String saleName, String saleCode, double saleSpzj, double saleSsje, double saleZl,
			String saleHytel) {
		super();
		this.saleName = saleName;
		this.saleCode = saleCode;
		this.saleSpzj = saleSpzj;
		this.saleSsje = saleSsje;
		this.saleZl = saleZl;
		this.saleHytel = saleHytel;
	}
	
	/**
	 * 属性的getter和setter方法
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}

	public double getSaleSpzj() {
		return saleSpzj;
	}

	public void setSaleSpzj(double saleSpzj) {
		this.saleSpzj = saleSpzj;
	}

	public double getSaleSsje() {
		return saleSsje;
	}

	public void setSaleSsje(double saleSsje) {
		this.saleSsje = saleSsje;
	}

	public double getSaleZl() {
		return saleZl;
	}

	public void setSaleZl(double saleZl) {
		this.saleZl = saleZl;
	}

	public String getSaleHytel() {
		return saleHytel;
	}

	public void setSaleHytel(String saleHytel) {
		this.saleHytel = saleHytel;
	}
	
	
	
	
	
}