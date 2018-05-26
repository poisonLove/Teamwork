package com.zktr.supermarket.service;

import java.util.List;

import com.zktr.supermarket.been.RuKu;
import com.zktr.supermarket.been.RuKuXQ;
import com.zktr.supermarket.dao.RuKuDao;
import com.zktr.supermarket.dao.RuKuXQDao;

public class RuKuService {

	private RuKuDao rkdao;//入库
	private RuKuXQDao rkxqdao;//入库详情
	//集合接收信息
	List<RuKu> lst;
	List<RuKu> lst1;
	List<RuKuXQ> lst2 ;
	
	public RuKuService(){
		rkdao = new RuKuDao();//实例化
		rkxqdao = new RuKuXQDao();
	}
	/*
	 * 查询所有入库信息
	 */
	public List<RuKu> queryByAll(){
		lst = rkdao.queryByAll();
		return lst;
	}

	/*
	 * 根据入库编号
	 */
	public List<RuKu> codeQuery(String rkcode){
		lst1 = rkdao.qureyByCode(rkcode);
		return lst1;
	}
	/*
	 * 根据入库编号查询入库详情
	 */
	public List<RuKuXQ> xqcodeQuery(String rkxqcode){
		lst2 = rkxqdao.queryByCode(rkxqcode);
		return lst2;
	} 
}
