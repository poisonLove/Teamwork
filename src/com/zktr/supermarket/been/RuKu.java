package com.zktr.supermarket.been;

public class RuKu {

	private int rkid;
	private String rkcode;//入库编号
	private String rkxqcode;//入库详情编号
	
	public RuKu() {
		super();
	}
	
	public RuKu(int rkid, String rkcode, String ruxqcode) {
		super();
		this.rkid = rkid;
		this.rkcode = rkcode;
		this.rkxqcode = rkxqcode;
	}
	
	public int getRkid() {
		return rkid;
	}
	public void setRkid(int rkid) {
		this.rkid = rkid;
	}
	public String getRkcode() {
		return rkcode;
	}
	public void setRkcode(String rkcode) {
		this.rkcode = rkcode;
	}
	public String getRkxqcode() {
		return rkxqcode;
	}
	public void setRkxqcode(String rkxqcode) {
		this.rkxqcode = rkxqcode;
	}
	
}
