package com.zktr.supermarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zktr.supermarket.been.ChuKu;
import com.zktr.supermarket.been.ChuKuXQ;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.RowData;

public class ChuKuDao extends BaseDao {

	private RowData<ChuKu> ck;
	
	public ChuKuDao(){
		ck = new ChuKuData();
	}
	
	/*
	 * 查询所有入库信息
	 */
	public List<ChuKu> queryAll(){
		return null;
		
	}
	/*
	 * 根据出库编号查询
	 */
	public List<ChuKu> queryByCode(){
		return null;
		
	}
	public class ChuKuData implements RowData<ChuKu>{

		@Override
		public ChuKu getData(ResultSet rs) throws SQLException {
			//创建一个出库对象
			ChuKu ck = new ChuKu();
			//赋值
			ck.setCkid(rs.getInt("ck_id"));
			ck.setCkcode(rs.getString("ck_code"));
			ck.setCkxqcode(rs.getString("ckxq_code"));
			return ck;
		}
		
	}
}
