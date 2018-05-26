package com.zktr.supermarket.been;
/**
 * 订单详情表类
 * @author asus
 *
 */

public class DingDanXQ {
	
	private  int id;//id号
	private String spcode;//订单编码
	private String sptxm;//商品条形码
	private String spname;//商品名称
	private double spjg;//商品价格
	private int spsl;//商品数量
	
	public DingDanXQ() {
		super();
	}
	
	public DingDanXQ(String spcode, String sptxm, String spname, double spjg, int spsl) {
		super();
		this.spcode = spcode;
		this.sptxm = sptxm;
		this.spname = spname;
		this.spjg = spjg;
		this.spsl = spsl;
	}

	public DingDanXQ(int id, String spcode, String sptxm, String spname, double spjg, int spsl) {
		super();
		this.id = id;
		this.spcode = spcode;
		this.sptxm = sptxm;
		this.spname = spname;
		this.spjg = spjg;
		this.spsl = spsl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpcode() {
		return spcode;
	}
	public void setSpcode(String spcode) {
		this.spcode = spcode;
	}
	public String getSptxm() {
		return sptxm;
	}
	public void setSptxm(String sptxm) {
		this.sptxm = sptxm;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public double getSpjg() {
		return spjg;
	}
	public void setSpjg(double spjg) {
		this.spjg = spjg;
	}
	public int getSpsl() {
		return spsl;
	}
	public void setSpsl(int spsl) {
		this.spsl = spsl;
	}
	
	
	
}
