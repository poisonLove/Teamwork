package com.zktr.supermarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.omg.Dynamic.Parameter;

import com.zktr.supermarket.been.DingDanXQ;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.ParameterSet;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;
/**
 * 订单详情表的dao
 * @author asus
 *
 */
public class DingDanXqDao extends BaseDao {
	private DingDanXqDate xqDate;
	
	public DingDanXqDao(){
		xqDate=new DingDanXqDate();
	}
	/**
	 * 根据订单编号查找商品详情
	 * @param dingDanCode
	 * @return
	 */
	public List<DingDanXQ> queryAll(String dingDanCode){
		String sql="select * from dbsalexq where sp_code=?";
		Parameterimpl ss=new Parameterimpl(dingDanCode);
		return queryAll(sql, xqDate, ss);
	}
	/**
	 * 修改商品信息
	 * @param sptxm
	 * @return
	 */
	public int updateSpnum(double price,String sptxm,String spcode) {
		String sql="update dbsalexq set sp_sl=sp_sl+1,sp_jg=sp_jg+? where sp_txm=? and sp_code=?";
		return update(sql, new ParameterSet() {
			@Override
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setDouble(1, price);
				pstamt.setString(2, sptxm);	
				pstamt.setString(3, spcode);	
				
			}
		});
		
	}
	/**
	 * 添加商品订单详情表信息
	 * @param xq
	 * @return
	 */
	public int addDingDanXq(DingDanXQ xq) {
		String sql="insert into dbsalexq(sp_code,sp_txm,sp_name,sp_jg,sp_sl) values(?,?,?,?,?)";
		return update(sql, new Parameterimpl(xq.getSpcode(),
											xq.getSptxm(),
											xq.getSpname(),											
											xq.getSpjg(),
											xq.getSpsl()));	
	}
	
	
	
	private class DingDanXqDate implements RowData<DingDanXQ>{

		@Override
		public DingDanXQ getData(ResultSet rs) throws SQLException {
			DingDanXQ xq=new DingDanXQ(rs.getInt("id"),
										rs.getString("sp_code"),
										rs.getString("sp_txm"),
										rs.getString("sp_name"),
										rs.getDouble("sp_jg"),
										rs.getInt("sp_sl"));
			return xq;
		}
		
	}
}
