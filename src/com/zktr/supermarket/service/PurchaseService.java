package com.zktr.supermarket.service;

import java.util.List;

import com.zktr.supermarket.been.CaiGouDingDan;
import com.zktr.supermarket.been.CaiGouXq;
import com.zktr.supermarket.dao.PurchaseDao;
import com.zktr.supermarket.dao.PurchaseXqDao;

/**
 * 采购模块逻辑类
 * @author asus
 *
 */
public class PurchaseService {
	
	private  PurchaseDao purchaseDao;
	private PurchaseXqDao purchaseXqDao;
	public PurchaseService() {
		purchaseDao=new PurchaseDao();
		purchaseXqDao=new PurchaseXqDao();
	}
	/**
	 * 查询自动生成的订单
	 * @param zidong
	 * @return
	 */
	public List<CaiGouDingDan> queryAll(String zidong){
		
		return purchaseDao.queryAll(zidong);	
	}
	/**
	 * 添加采购订单
	 * @param cgdd
	 * @return
	 */
	public boolean addPurchase(CaiGouDingDan cgdd) {
		return purchaseDao.addPurchase(cgdd)>0? true:false;
		
	}
	/**
	 * 添加采购订单详情
	 * @param cgXq
	 * @return
	 */
	public boolean addPurchaseXq(CaiGouXq cgXq) {
		return purchaseXqDao.addCgXq(cgXq)>0? true:false;
		
	}
	/**
	 * 按条件查询
	 * @param str
	 * @param obj
	 * @return
	 */
	public List<CaiGouDingDan> checkCaiGou(String str,Object obj){
		return purchaseDao.checkCaiGou(str, obj);
		
	}
	
	public List<CaiGouXq> queryCaiGouXq(String code ){
		return purchaseXqDao.queryAll(code);
		
	}
}
