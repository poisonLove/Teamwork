package com.zktr.supermarket.service;

import java.util.List;

import com.zktr.supermarket.been.DingDan;
import com.zktr.supermarket.been.DingDanXQ;
import com.zktr.supermarket.been.Goods;
import com.zktr.supermarket.dao.DingDanDao;
import com.zktr.supermarket.dao.DingDanXqDao;
import com.zktr.supermarket.dao.GoodDao;

/**
 * 
 * @author hp
 *
 */
public class SaleService{
	private DingDanDao saleDao;
	private DingDanXqDao xqDao;
	private GoodDao goodDao;
	List<DingDan> lstdd;
	
	
	public SaleService() {
		saleDao=new DingDanDao();
		xqDao=new DingDanXqDao();
		goodDao=new GoodDao();
	}
	/**
	 * 按照编号修改销售员姓名的方法。
	 * @param name
	 * @param salecode
	 */
	public void updateSale(String name,String salecode) {
		saleDao.updateDingDan(name, salecode);	
		queryAll();
	}
	/**
	 * 按售货员的姓名查找订单
	 * @param name
	 * @return
	 */
	public List<DingDan> conditionquery(String name){
		lstdd=saleDao.queryCondition(name);
		return lstdd!=null? lstdd:null;	
	}
	/**
	 * 按照订单编号查找订单
	 * @param saleCode
	 * @return
	 */
	public List<DingDan> querySaleCode(String saleCode){
		lstdd=saleDao.querySaleCode(saleCode);
		return lstdd!=null? lstdd:null;	
	}
	/**
	 * 按照会员编号查询
	 * @param salehytel
	 * @return
	 */
	public List<DingDan> querySalehytel(String hytel){
		lstdd=saleDao.querySaleCode(hytel);
		return lstdd!=null? lstdd:null;	
	}
	
	/**
	 * 查询全部的订单
	 * @return
	 */
	public List<DingDan> queryAll(){
		lstdd=saleDao.queryAll();
		return lstdd!=null? lstdd:null;
	}
	/**
	 * 根据订单编号查找到倒该订单的详情
	 * @param code
	 * @return
	 */
	public List<DingDanXQ> queryAll(String code){
		List<DingDanXQ>lstdd=xqDao.queryAll(code);
		return lstdd;
		
	}
	/**
	 * 查找单个商品
	 * @param gbcode
	 * @return
	 */
	public Goods queryOne(String gbcode) {
		List<Goods> listGood=goodDao.queryOne(gbcode);
		Goods good=new Goods(listGood.get(0).getGbcode(),
							listGood.get(0).getGname(),
							listGood.get(0).getGjprice(),							
							listGood.get(0).getGhdprice(),
							listGood.get(0).getGprice(),
							listGood.get(0).getGnum(),
							listGood.get(0).getGztai(),
							listGood.get(0).getGsjnum(),
					        listGood.get(0).getKunum(),
							listGood.get(0).getGrktime());
		return good;
		
	}
	/**
	 * 查找商品
	 * @param gbcode
	 * @return
	 */
	public List<Goods> queryGood(String gbcode){
		return goodDao.queryOne(gbcode);	
	}
	/**
	 * 添加订单详情
	 * @param xq
	 * @return
	 */
	public boolean addDingDanXq(DingDanXQ xq) {
		return xqDao.addDingDanXq(xq)>0?true:false;
	}
	/**
	 * 添加订单
	 * @param dingDan
	 * @return
	 */
	public boolean addDingDan(DingDan dingDan) {
		return saleDao.addDingdan(dingDan)>0?true:false;
		
	}
	/**
	 * 修改订单
	 * @param sptxm
	 * @return
	 */
	public boolean updateSpnum(double price,String sptxm ,String spcode) {
		return xqDao.updateSpnum(price,sptxm,spcode)>0? true:false;
		
	}
	/**
	 * 修改货架的商品数量
	 * @param spcode
	 * @return
	 */
	public boolean updateGoodsNum(String spcode) {
		return goodDao.updateGoodsNum(spcode)>0? true:false;
		
	}
	
}