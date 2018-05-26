package com.zktr.supermarket.been;

public class CaiGouXq {
	
	private String cgcode;//采购订单编号
	private String cgsptxm;//采购商品的条形码
	private  String cgspname;//采购商品的名称
	private  double cgjg;//采购金额
	private int cgsl;//采购数量
	
	public CaiGouXq() {
		super();
	}
	public CaiGouXq(String cgcode, String cgsptxm, String cgspname, double cgjg, int cgsl) {
		super();
		this.cgcode = cgcode;
		this.cgsptxm = cgsptxm;
		this.cgspname = cgspname;
		this.cgjg = cgjg;
		this.cgsl = cgsl;
	}
	public String getCgcode() {
		return cgcode;
	}
	public void setCgcode(String cgcode) {
		this.cgcode = cgcode;
	}
	public String getCgsptxm() {
		return cgsptxm;
	}
	public void setCgsptxm(String cgsptxm) {
		this.cgsptxm = cgsptxm;
	}
	public String getCgspname() {
		return cgspname;
	}
	public void setCgspname(String cgspname) {
		this.cgspname = cgspname;
	}
	public double getCgjg() {
		return cgjg;
	}
	public void setCgjg(double cgjg) {
		this.cgjg = cgjg;
	}
	public int getCgsl() {
		return cgsl;
	}
	public void setCgsl(int cgsl) {
		this.cgsl = cgsl;
	}
	
	
	
}
