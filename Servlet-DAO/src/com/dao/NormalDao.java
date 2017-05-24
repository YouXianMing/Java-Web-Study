package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.libs.dbcp.BaseDao;
import com.libs.dbcp.DbcpManager;

public class NormalDao extends BaseDao {

	@Override
	public Connection getConnection() throws SQLException {

		return DbcpManager.getConnectionFromBasicDataSource("DB");
	}
}
