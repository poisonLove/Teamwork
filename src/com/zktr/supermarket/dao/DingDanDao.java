package com.zktr.supermarket.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zktr.supermarket.been.DingDan;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.ParameterSet;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;
/**
 * 订单表的dao
 * @author asus
 *
 */
public class DingDanDao extends BaseDao{
	
	private DingDanDate dingDanDate; //内部类属性
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
		String sql="insert into dbsale(sale_name,sale_code,sale_spzj,sale_ssje,sale_zl,sale_hytel) value(?,?,?,?,?,?)";
		return update(sql, new Parameterimpl(dingDan.getSaleName(),
											 dingDan.getSaleCode(),
											 dingDan.getSaleSpzj(),
											 dingDan.getSaleSsje(),
											 dingDan.getSaleZl(),
											 dingDan.getSaleHytel()));	
	}
	/**
	 * 按条件修改订单
	 * @param name
	 * @param salecode
	 * @return
	 */
	public int updateDingDan(String name,String salecode) {
		String sql="update dbsale set sale_name=? where sale_code=?";
		return update(sql, new ParameterSet() {			
			@Override
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setString(1, name);
				pstamt.setString(2, salecode);	
			}
		});		
	}
	/**
	 * 按名字查询订单
	 * @param name
	 * @return
	 */
	public List<DingDan> queryCondition(String name){
		String sql="select * from dbsale where  sale_name=?";
		return queryAll(sql,dingDanDate, new ParameterSet() {	
			@Override
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setString(1, name);
			}
		});
	}
	/**
	 * 按订单编号查询订单
	 * @param saleCode
	 * @return
	 */
	public List<DingDan> querySaleCode(String saleCode){
		String sql="select * from dbsale where sale_code=?";
		return queryAll(sql, dingDanDate, new ParameterSet() {
			@Override
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setString(1, saleCode);	
			}	
		});	
	}
	/**
	 * 按照会员编号查询订单
	 * @param hytel
	 * @return
	 */
	public List<DingDan> queryHytel(String hytel){
		String sql="select * from dbsale where  sale_hytel=?";
		 return queryAll(sql, dingDanDate, new ParameterSet() {
			@Override
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setString(1, hytel);	
			}	
		});	
		
	}
	/**
	 * 查询所有订单
	 * @return List
	 */
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
										rs.getDouble("sale_ssje"),
										rs.getDouble("sale_zl"),
										rs.getString("sale_hytel"));
			return dingDan;
		}
		
	}
}