package com.zktr.supermarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zktr.supermarket.been.ChuKuXQ;
import com.zktr.supermarket.dao.conn.RowData;

public class ChuKuXQDao {

	private RowData<ChuKuXQ> ckxq;
	
	public ChuKuXQDao(){
		ckxq = new ChuKuXQData();
	}
	
	public class ChuKuXQData implements RowData<ChuKuXQ>{

		@Override
		public ChuKuXQ getData(ResultSet rs) throws SQLException {
			// 创建一个出库详情对象
			ChuKuXQ ckxq2 = new ChuKuXQ();
			//赋值
			ckxq2.setId(rs.getInt("id"));
			ckxq2.setSpcode(rs.getString("sp_code"));
			ckxq2.setCksl(rs.getInt("ck_sl"));
			ckxq2.setCktime(rs.getDate("ck_time"));
			return ckxq2; 
		}
		
	}
}
