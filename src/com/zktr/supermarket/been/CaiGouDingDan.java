package com.zktr.supermarket.been;

public class CaiGouDingDan {
	
	private int id;//id号
	private String ccname;//采购员姓名
	private String cccode;//采购编号
	private String ccdate;//采购时间
	private int ccover;//采购状态
	private String cczd;//生成状态
	private double cczje;//采购总金额
	public CaiGouDingDan() {
		super();
	}

	
	public CaiGouDingDan(int id, String ccname, String cccode, String ccdate, int ccover, String cczd,double cczje) {
		super();
		this.id = id;
		this.ccname = ccname;
		this.cccode = cccode;
		this.ccdate = ccdate;
		this.ccover = ccover;
		this.cczd = cczd;
		this.cczje=cczje;
	}

	public CaiGouDingDan(String ccname, String cccode, String ccdate, int ccover, String cczd ,double cczje) {
		super();
		this.ccname = ccname;
		this.cccode = cccode;
		this.ccdate = ccdate;
		this.ccover = ccover;
		this.cczd = cczd;
		this.cczje=cczje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getCccode() {
		return cccode;
	}

	public void setCccode(String cccode) {
		this.cccode = cccode;
	}

	public String getCcdate() {
		return ccdate;
	}

	public void setCcdate(String ccdate) {
		this.ccdate = ccdate;
	}

	public int getCcover() {
		return ccover;
	}

	public void setCcover(int ccover) {
		this.ccover = ccover;
	}
	public String getCczd() {
		return cczd;
	}

	public void setCczd(String cczd) {
		this.cczd = cczd;
	}


	public double getCczje() {
		return cczje;
	}


	public void setCczje(double cczje) {
		this.cczje = cczje;
	}

	
}
