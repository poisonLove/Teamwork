package com.zktr.supermarket.been;

import java.util.Date;

public class ChuKuXQ {

	private int id;
	private String spcode;//商品编号
	private int cksl;//商品出库数量
	private Date cktime;//商品出库时间
	
	public ChuKuXQ() {
		super();
	}
	
	public ChuKuXQ(int id, String spcode, int cksl, Date cktime) {
		super();
		this.id = id;
		this.spcode = spcode;
		this.cksl = cksl;
		this.cktime = cktime;
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
	public int getCksl() {
		return cksl;
	}
	public void setCksl(int cksl) {
		this.cksl = cksl;
	}
	public Date getCktime() {
		return cktime;
	}
	public void setCktime(Date cktime) {
		this.cktime = cktime;
	}
	
	
}
