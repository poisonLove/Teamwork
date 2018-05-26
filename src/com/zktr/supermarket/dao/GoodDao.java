package com.zktr.supermarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zktr.supermarket.been.Goods;
import com.zktr.supermarket.dao.conn.BaseDao;
import com.zktr.supermarket.dao.conn.ParameterSet;
import com.zktr.supermarket.dao.conn.Parameterimpl;
import com.zktr.supermarket.dao.conn.RowData;
/**
 * 商品dao
 * @author asus
 *
 */
public class GoodDao extends BaseDao {
	private GoodDate goodDate;
	
	public GoodDao() {
		goodDate=new GoodDate();
	}
	/**
	 * 查询单条的商品
	 * @param gbcode
	 * @return
	 */
	public List<Goods> queryOne(String gbcode) {
		String sql="select * from dbgoods where g_bcode=?";
		Parameterimpl pimpl=new Parameterimpl(gbcode);
		return queryAll(sql, goodDate, pimpl);	
	}
	/**
	 * 修改商品的数量
	 * @return
	 */
	public int updateGoodsNum(String spcode) {
		String sql="update dbgoods set g_sjnum=g_sjnum-1 where g_bcode=?";
		return update(sql, new ParameterSet() {
			@Override
			public void setParams(PreparedStatement pstamt) throws SQLException {
				pstamt.setString(1, spcode);	
			}
		});
		
	}
	/**
	 * 查看全部商品
	 * @return
	 */
	public List<Goods> queryAll(){
		String sql="select * from goods";
		return queryAll(sql, goodDate, null);		
	}
	
	
	private class GoodDate implements RowData<Goods>{
		@Override
		public Goods getData(ResultSet rs) throws SQLException {
			Goods goods=new Goods(rs.getString("g_bcode"),
								  rs.getString("g_name"),
								  rs.getDouble("g_jprice"),
								  rs.getDouble("g_hdprice"),
								  rs.getDouble("g_price"),
								  rs.getInt("g_num"),
								  rs.getString("g_ztai"),
								  rs.getInt("g_sjnum"),
								  rs.getInt("g_kunum"),
								  rs.getDate("g_rktime"));
			return goods;
		}
		
	}
}
