package com.pl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pl.uitl.ConfigManager;

/**
 * �����������ݿ���Դ�Ļ�ȡ���ͷŲ�����ע���ͷ���Դʱ���Ⱥ�˳���쳣����
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
	 * ���ݿ���Դ�Ļ�ȡ
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

	// ��ɾ��
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

	// ��ѯ����
	public ResultSet executeQuery(String sql, Object... args) {

		if (this.getConnection()) {
			try {
				ppst = connection.prepareStatement(sql);
				for (int i = 0; i < args.length; i++) {
					ppst.setObject(i + 1, args[i]);
				}
				rs = ppst.executeQuery();// �����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rs;

	}

	/**
	 * ���ݿ���Դ���ͷ�
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
