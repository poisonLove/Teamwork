package com.zktr.supermarket.been;

import java.util.Date;

public class RuKuXQ {

	private String rkxqcode;//入库详情编号
	private String rkxqgcode;//入库商品编号
	private int rkxqgnum;//商品入库数量
	private Date rkxqtime;//商品入库时间
	
	public RuKuXQ() {
		super();
	}
	
	public RuKuXQ(String rkxqcode, String rkxqgcode, int rkxqgnum, Date rkxqtime) {
		super();
		this.rkxqcode = rkxqcode;
		this.rkxqgcode = rkxqgcode;
		this.rkxqgnum = rkxqgnum;
		this.rkxqtime = rkxqtime;
	}
	
	public String getRkxqcode() {
		return rkxqcode;
	}
	public void setRkxqcode(String rkxqcode) {
		this.rkxqcode = rkxqcode;
	}
	public String getRkxqgcode() {
		return rkxqgcode;
	}
	public void setRkxqgcode(String rkxqgcode) {
		this.rkxqgcode = rkxqgcode;
	}
	public int getRkxqgnum() {
		return rkxqgnum;
	}
	public void setRkxqgnum(int rkxqgnum) {
		this.rkxqgnum = rkxqgnum;
	}
	public Date getRkxqtime() {
		return rkxqtime;
	}
	public void setRkxqtime(Date rkxqtime) {
		this.rkxqtime = rkxqtime;
	}
	
}
