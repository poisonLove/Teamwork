package com.zktr.supermarket.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zktr.supermarket.been.DingDan;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;

public class DingDanDao extends BaseDao{
	
	private DingDanDate dingDanDate;
	
	/**
	 * 构造方法初始化
	 */
	public DingDanDao(){
		dingDanDate =new DingDanDate();
	}
	/**
	 * 添加订单
	 * @param dingDan
	 * @return
	 */
	public int addDingdan(DingDan dingDan) {
		String sql="insert into supermarketdb value(?,?,?,?,?,?,)";
		
		return update(sql, new Parameterimpl(dingDan.getSaleName(),
											 dingDan.getSaleCode(),
											 dingDan.getSaleSpzj(),
											 dingDan.getSaleSsje(),
											 dingDan.getSaleZl(),
											 dingDan.getSaleHytel()));	
	}
	public List<DingDan> queryAll(){
		String sql="select * from dbsale";
		return queryAll(sql, dingDanDate, null);
		
	}
	
	
	
	private class DingDanDate implements RowData<DingDan>{
		@Override
		public DingDan getData(ResultSet rs) throws SQLException {
			DingDan dingDan=new DingDan(rs.getString("sale_name"),
										rs.getString("sale_code"),
										rs.getDouble("sale_spzj"),
										rs.getDouble("sale_spssje"),
										rs.getDouble("sale_zl"),
										rs.getString("sale_hytel"));
			return dingDan;
		}
		
	}
}