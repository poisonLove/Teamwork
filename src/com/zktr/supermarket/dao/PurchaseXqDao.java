package com.zktr.supermarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sun.javafx.application.ParametersImpl;
import com.zktr.supermarket.been.CaiGouXq;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.ParameterSet;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;

public class PurchaseXqDao extends BaseDao {
	private PurchaseXqDate pcx;
	public PurchaseXqDao() {
		pcx=new PurchaseXqDate();
	}
	/**
	 * 添加采购商品详情订单
	 * @param cgXq
	 * @return
	 */
	public int addCgXq(CaiGouXq cgXq) {
		String sql="insert into dbcaigouxq values(?,?,?,?,?)";
		return update(sql, new Parameterimpl(cgXq.getCgcode(),
											 cgXq.getCgsptxm(),
											 cgXq.getCgspname(),
											 cgXq.getCgjg(),
											 cgXq.getCgsl()));	
	}
	/**
	 * 按编号查询采购详情
	 * @param code
	 * @return
	 */
	public List<CaiGouXq> queryAll(String code){
		String sql="select * from dbcaigouxq where cg_code=? ";
		return queryAll(sql, pcx, new ParameterSet() {
			
			@Override
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setString(1, code);
				
			}
		});	
	}
	
	/**
	 * 从数据库总读取参数绑定
	 * @author asus
	 *
	 */
	private class PurchaseXqDate  implements RowData<CaiGouXq>{
		public CaiGouXq getData(ResultSet rs) throws SQLException {
			CaiGouXq xq=new CaiGouXq(rs.getString("cg_code"),
									rs.getString("sp_txm"),
									rs.getString("sp_name"),
									rs.getDouble("cg_jg"),
									rs.getInt("cg_sl"));
			return xq;
		}
		
	}

}
