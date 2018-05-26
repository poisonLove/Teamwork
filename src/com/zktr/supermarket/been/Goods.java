package com.zktr.supermarket.been;

import java.util.Date;
/**
 * 商品类
 * @author asus
 *
 */
public class Goods {
	private int id; //id号
	private String gbcode;//商品条形码
	private String gname;//商品名称
	private double gjprice;//商品进价
	private double ghdprice;//商品活动价
	private double gprice;//商品售价
	private int gnum;//商品总数量
	private String gztai;//商品状态
	private int gsjnum;//商品上架数量
	private int kunum;//商品库存数量
	private Date grktime;//商品入库时间
	
	public Goods() {
		super();
	}
	
	public Goods(String gbcode, String gname, double gjprice, double ghdprice, double gprice, int gnum, String gztai,
			int gsjnum, int kunum, Date grktime) {
		super();
		this.gbcode = gbcode;
		this.gname = gname;
		this.gjprice = gjprice;
		this.ghdprice = ghdprice;
		this.gprice = gprice;
		this.gnum = gnum;
		this.gztai = gztai;
		this.gsjnum = gsjnum;
		this.kunum = kunum;
		this.grktime = grktime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getGjprice() {
		return gjprice;
	}
	public void setGjprice(double gjprice) {
		this.gjprice = gjprice;
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
	public int getKunum() {
		return kunum;
	}
	public void setKunum(int kunum) {
		this.kunum = kunum;
	}
	public Date getGrktime() {
		return grktime;
	}
	public void setGrktime(Date grktime) {
		this.grktime = grktime;
	}
	
}