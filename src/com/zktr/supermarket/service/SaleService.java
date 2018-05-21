package com.zktr.supermarket.service;

import java.util.List;

import com.zktr.supermarket.been.DingDan;
import com.zktr.supermarket.dao.DingDanDao;

/**
 * 
 * @author hp
 *
 */
public class SaleService{
	private DingDanDao saleDao;
	
	public SaleService() {
		saleDao=new DingDanDao();
	}
	public List<DingDan> queryAll(){
		List<DingDan> lst=saleDao.queryAll();
		
		return lst;
		
	}
}