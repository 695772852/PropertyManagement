package com.pl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pl.uitl.ConfigManager;

/**
 * 包含基本数据库资源的获取、释放操作。注意释放资源时的先后顺序及异常处理
 * 
 * @author PLFEIGN
 *
 */
public class BaseDao {

	public Connection connection;
	public PreparedStatement ppst;
	public ResultSet rs;

	public BaseDao() {
	}

	/**
	 * 数据库资源的获取
	 * 
	 * @return
	 */
	public boolean getConnection() {
		try {
			Class.forName(ConfigManager.getIntance().getProperties("jdbc.driver"));
			String url = ConfigManager.getIntance().getProperties("jdbc.connection.url");
			String user = ConfigManager.getIntance().getProperties("jdbc.connection.root");
			String password = ConfigManager.getIntance().getProperties("jdbc.connection.password");
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 增删改
	public int executeUpdate(String sql, Object... args) {
		int updateRows = 0;
		if (this.getConnection()) {
			try {
				ppst = connection.prepareStatement(sql);
				for (int i = 0; i < args.length; i++) {
					ppst.setObject(i + 1, args[i]);
				}
				updateRows = ppst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return updateRows;

	}

	// 查询功能
	public ResultSet executeQuery(String sql, Object... args) {

		if (this.getConnection()) {
			try {
				ppst = connection.prepareStatement(sql);
				for (int i = 0; i < args.length; i++) {
					ppst.setObject(i + 1, args[i]);
				}
				rs = ppst.executeQuery();// 结果集
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rs;

	}

	/**
	 * 数据库资源的释放
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ppst != null) {
				ppst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
