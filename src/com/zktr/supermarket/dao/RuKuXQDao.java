package com.zktr.supermarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zktr.supermarket.been.RuKuXQ;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;

public class RuKuXQDao extends BaseDao{
	private RowData<RuKuXQ> rkxq;
	
	
	
	public RuKuXQDao(){
		rkxq = new RuKuXQData();//实例化
	}

	/*
	 *根据入库详情编号查询
	 */
	public List<RuKuXQ> queryByCode(String rkxqcode){
		String sql = "select *  from dbrukuxq where rkxq_code = ?";
		Parameterimpl p = new Parameterimpl(rkxqcode);
		return queryAll(sql, rkxq, p);
		
	}
	public class RuKuXQData implements RowData<RuKuXQ>{

		@Override
		public RuKuXQ getData(ResultSet rs) throws SQLException {
			// 创建一个入库详情对象
			RuKuXQ rkxq2 = new RuKuXQ();
			//赋值
			rkxq2.setRkxqcode(rs.getString("rkxq_code"));
			rkxq2.setRkxqgcode(rs.getString("rkxq_gcode"));
			rkxq2.setRkxqgnum(rs.getInt("rkxq_gnum"));
			rkxq2.setRkxqtime(rs.getDate("rkxq_time"));
			return rkxq2;
		}
		
	}
}
