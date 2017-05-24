package com.libs.dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection 数据库连接
	 */
	public Connection getConnection() throws SQLException {

		return null;
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param resultSet
	 *            ResultSet对象
	 */
	public void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Connection
	 * 
	 * @param connection
	 *            Connection对象
	 */
	public void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Statement
	 * 
	 * @param statement
	 *            Statement对象
	 */
	public void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
