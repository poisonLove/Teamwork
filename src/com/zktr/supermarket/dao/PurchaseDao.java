package com.zktr.supermarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zktr.supermarket.been.CaiGouDingDan;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.ParameterSet;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;

public class PurchaseDao extends BaseDao {
	private CaiGouDate cgdate;
	public PurchaseDao() {
		cgdate=new CaiGouDate();
	}
	/**
	 * 查询自动生成订单
	 * @param zidong
	 * @return
	 */
	public List<CaiGouDingDan> queryAll(String zidong){
		String sql="select * from dbcaigoudd where cc_zd=?";
		return queryAll(sql, cgdate, new ParameterSet() {
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setString(1, zidong);	
			}
		});
	}
	/**
	 * 按条件查询
	 * @param str
	 * @param obj
	 * @return
	 */
	public List<CaiGouDingDan> checkCaiGou(String str,Object obj){
		String sql="select * from dbcaigoudd where "+str+"=?";
		return queryAll(sql, cgdate, new ParameterSet() {
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setObject(1, obj);
			}
		});
		
	}
	/**
	 * 添加采购订单
	 * @param cgdd
	 * @return
	 */
	public int addPurchase(CaiGouDingDan cgdd) {
		String sql="insert into dbcaigoudd(cc_name,cc_code,cc_date,cc_over,cc_zd,cc_zje) values(?,?,?,?,?,?)";
		return update(sql, new Parameterimpl(cgdd.getCcname(),
											cgdd.getCccode(),
											cgdd.getCcdate(),
											cgdd.getCcover(),
											cgdd.getCczd(),
											cgdd.getCczje()));	
	}
	
	private class CaiGouDate implements RowData<CaiGouDingDan>{

		@Override
		public CaiGouDingDan getData(ResultSet rs) throws SQLException {
			CaiGouDingDan cgdd=new CaiGouDingDan(rs.getInt("id"),
												rs.getString("cc_name"), 
												rs.getString("cc_code"), 
												rs.getString("cc_date"),
												rs.getInt("cc_over"),
												rs.getString("cc_zd"),
												rs.getDouble("cc_zje"));
			return cgdd;
		}
		
	}
}
