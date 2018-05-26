package com.zktr.supermarket.been;

import java.util.Date;

public class Goods {
//
	private int gid;               
	private String gbcode;             //商品条形码
	private String gname;              //商品名称
	private double giprice;            //商品进价
	private double ghdprice;           //商品活动价
	private double gprice;             //商品售价
	private int gnum;                  //商品总数量
	private String gztai;              //商品状态
	private int gsjnum;                //商品上架数目
	private int gkcnum;                //商品库存数量
	private Date grktime;              //商品入库时间
	
	public Goods() {
		super();
	}
	
	public Goods(String gbcode, String gname, double giprice, double ghdprice, double gprice, int gnum, String gztai,
			int gsjnum, int gkcnum, Date grktime) {
		super();
		this.gbcode = gbcode;
		this.gname = gname;
		this.giprice = giprice;
		this.ghdprice = ghdprice;
		this.gprice = gprice;
		this.gnum = gnum;
		this.gztai = gztai;
		this.gsjnum = gsjnum;
		this.gkcnum = gkcnum;
		this.grktime = grktime;
	}

	public Goods(int gid, String gbcode, String gname, double giprice, double ghdprice, double gprice, int gnum,
			String gztai, int gsjnum, int gkcnum, Date grktime) {
		super();
		this.gid = gid;
		this.gbcode = gbcode;
		this.gname = gname;
		this.giprice = giprice;
		this.ghdprice = ghdprice;
		this.gprice = gprice;
		this.gnum = gnum;
		this.gztai = gztai;
		this.gsjnum = gsjnum;
		this.gkcnum = gkcnum;
		this.grktime = grktime;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGbcode() {
		return gbcode;
	}
	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGiprice() {
		return giprice;
	}
	public void setGiprice(double giprice) {
		this.giprice = giprice;
	}
	public double getGhdprice() {
		return ghdprice;
	}
	public void setGhdprice(double ghdprice) {
		this.ghdprice = ghdprice;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public String getGztai() {
		return gztai;
	}
	public void setGztai(String gztai) {
		this.gztai = gztai;
	}
	public int getGsjnum() {
		return gsjnum;
	}
	public void setGsjnum(int gsjnum) {
		this.gsjnum = gsjnum;
	}
	public int getGkcnum() {
		return gkcnum;
	}
	public void setGkcnum(int gkcnum) {
		this.gkcnum = gkcnum;
	}
	public Date getGrktime() {
		return grktime;
	}
	public void setGrktime(Date grktime) {
		this.grktime = grktime;
	}
	
	
}
