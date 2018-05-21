package com.zktr.supermarket.dao.conn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
* 参数设置实现类
* @author Administrator
*
*/
public class Parameterimpl implements ParameterSet {
	private Object[] obj; // 定义个object类型数组

	public Parameterimpl(Object... objects) {
		this.obj = objects;
	}

	@Override
	public void setParams(PreparedStatement pstamt) throws SQLException {
		// 设置参数
		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				pstamt.setObject((i + 1), obj[i]);
			}
		}

	}
}
