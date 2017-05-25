package com.libs.dbcp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbcpManager {

	private static DbcpManager singleton = new DbcpManager();
	private HashMap<String, BasicDataSource> map;

	/**
	 * DbcpManager构造方法,初始化时让字典可用,对外不可见
	 */
	private DbcpManager() {
		map = new HashMap<>();
	}

	/**
	 * 创建一个BasicDataSource实体,并给BasicDataSource注册一个名字,存储在map当中
	 * 
	 * @param name 指定的名字
	 */
	public static final void registerBasicDataSource(String name) {
		BasicDataSource dataSource = new BasicDataSource();
		singleton.map.put(name, dataSource);
	}

	/**
	 * 通过注册的名字获取BasicDataSource实体
	 * 
	 * @param name 注册的BasicDataSource的名字
	 * @return BasicDataSource实体
	 */
	public static final BasicDataSource getBasicDataSource(String name) {
		return singleton.map.get(name);
	}

	/**
	 * 给注册名字的BasicDataSource进行配置工作
	 * 
	 * @param name 注册的BasicDataSource的名字
	 * @param config DataSourceConfig对象,需要继承它来实现对应的配置工作
	 */
	public static final void configBasicDataSource(String name, DataSourceConfig config) {
		BasicDataSource dataSource = singleton.map.get(name);
		if (dataSource != null) {
			config.setDataSource(singleton.map.get(name));
			config.start();
		}
	}

	/**
	 * 从注册名字的BasicDataSource处获取一个Connection
	 * 
	 * @param name 注册的BasicDataSource的名字
	 * @return Connection实体
	 * @throws SQLException
	 */
	public static final Connection getConnectionFromBasicDataSource(String name) throws SQLException {
		BasicDataSource dataSource = singleton.map.get(name);
		if (dataSource != null) {
			return dataSource.getConnection();
		} else {
			return null;
		}
	}
}
