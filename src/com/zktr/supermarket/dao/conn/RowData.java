package com.zktr.supermarket.dao.conn;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 定义一个泛型结果集处理接口
 * @author Administrator
 *
 */
public interface RowData<T> {
	
	//结果处理方法
	public T getData(ResultSet rs) throws SQLException;
}
