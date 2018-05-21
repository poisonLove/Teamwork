package com.zktr.supermarket.dao.conn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 定义一个参数设置接口
 * @author Administrator
 *
 */
public interface ParameterSet {

	/**
	 * 参数设置
	 * @param pastmt
	 * @param objects
	 */
	public void setParams(PreparedStatement pstamt) throws SQLException;
}
