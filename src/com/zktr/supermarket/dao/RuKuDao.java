package com.zktr.supermarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.zktr.supermarket.been.RuKu;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;

public class RuKuDao extends BaseDao{

	private RowData<RuKu> rk;
	
	public RuKuDao(){
		rk=new RuKuData();
	}
	
	/*
	 * 查询所有入库信息
	 */
	public List<RuKu> queryByAll(){
		String sql = "select * from dbruku";
		return queryAll(sql, rk, null);
	}

	//根据入库编号查询
	public List<RuKu> qureyByCode(String rkcode){
		String sql = "select * from dbruku where rk_code = ?";
		Parameterimpl p = new Parameterimpl(rkcode);
		return queryAll(sql, rk, p);
		
	}
	
	private class RuKuData implements RowData<RuKu> {

		@Override
		public RuKu getData(ResultSet rs) throws SQLException {
			// 创建一个入库列表对象
			RuKu rk2 = new RuKu();
			//赋值
			rk2.setRkid(rs.getInt("rk_id"));
			rk2.setRkcode(rs.getString("rk_code"));
			rk2.setRkxqcode(rs.getString("rkxq_code"));
			
			return rk2;
		}
		
	}
}
