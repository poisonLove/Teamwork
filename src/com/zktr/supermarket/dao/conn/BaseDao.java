package com.zktr.supermarket.dao.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.zktr.supermarket.been.DingDan;

public class BaseDao {
	//先加在数据库连接所需要的文件
	private static ResourceBundle rb=ResourceBundle.getBundle("com.zktr.supermarket.dao.conn.supermarket-config");
	//数据库连接信息
		private String url = rb.getString("jdbc.url");
		private String uname =rb.getString("jdbc.username");
		private String pwd = rb.getString("jdbc.password");
		private String Driver=rb.getString("jdbc.driver");
		/**
		 * 1.获取连接对象
		 * 
		 * @return
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			// 1. 加载驱动
			Class.forName(Driver);
			//2. 获取连接对象
			return DriverManager.getConnection(url, uname, pwd);
		}
		
		/**
		 * 2.释放资源
		 * @param conn   连接对象
		 * @param pstamt SQL执行对象
		 * @param rs 结果集对象
		 */
		public void close(Connection conn,PreparedStatement pstamt,ResultSet rs){
			//释放资源		
			try {
				if(rs!=null ){
					rs.close();
				}			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(pstamt!=null){
					pstamt.close();
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * 3. 添加、删除、修改方法
		 * @param sql
		 * @param obj
		 * @return
		 */
		public int update(String sql,ParameterSet parms){
			Connection conn=null; //连接对象
			PreparedStatement pstamt = null;   //SQL执行对象
			try {
				//获取连接
				conn = getConnection();	
				pstamt = conn.prepareStatement(sql);
				//设置参数
				if(parms !=null){
					parms.setParams(pstamt);
				}	
				//执行sql
				return pstamt.executeUpdate();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				//释放资源
				this.close(conn,pstamt,null);
			}
			return 0;
		}
		
		/**
		 * 4. 查询单条记录
		 * @param sql
		 * @param rows
		 * @param obj
		 * @return
		 */
		public <T> T queryOne(String sql,RowData<T> rows,ParameterSet parms){
			return this.queryAll(sql, rows, parms).get(0);
		}
		
		/**
		 * 5.查询数据集合
		 * 
		 * @param sql
		 * @param rows
		 * @param obj
		 * @return
		 */
		public <T> List<T> queryAll(String sql,RowData<T> rows,ParameterSet parms){
			Connection conn=null; //连接对象
			PreparedStatement pstamt = null;   //SQL执行对象
			ResultSet rs =null;  //结果集对象
			//用于保存返回数据
			List<T> lst  = new ArrayList<T>();
			
			try {
				conn = getConnection(); //获取连接
				pstamt = conn.prepareStatement(sql);
				//设置参数		
				if(parms !=null){
					parms.setParams(pstamt);
				}			
				rs = pstamt.executeQuery(); //获取数据结果集
				while(rs.next()){			
					//T 获取T对象
					T t = rows.getData(rs);
					//将T对象添加到lst集合中
					lst.add(t);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//返回结果集
			return lst;
		}
}
