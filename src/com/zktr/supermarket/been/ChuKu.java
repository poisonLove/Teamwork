package com.zktr.supermarket.been;

public class ChuKu {

	private int ckid;
	private String ckcode;//出库编号
	private String ckxqcode;//出库详情编号
	public ChuKu() {
		super();
	}
	public ChuKu(int ckid, String ckcode, String ckxqcode) {
		super();
		this.ckid = ckid;
		this.ckcode = ckcode;
		this.ckxqcode = ckxqcode;
	}
	public int getCkid() {
		return ckid;
	}
	public void setCkid(int ckid) {
		this.ckid = ckid;
	}
	public String getCkcode() {
		return ckcode;
	}
	public void setCkcode(String ckcode) {
		this.ckcode = ckcode;
	}
	public String getCkxqcode() {
		return ckxqcode;
	}
	public void setCkxqcode(String ckxqcode) {
		this.ckxqcode = ckxqcode;
	}
	
	
}
