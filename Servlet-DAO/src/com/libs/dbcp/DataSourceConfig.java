package com.libs.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceConfig {

	private BasicDataSource dataSource;
	private Object config;

	/**
	 * DataSourceConfig的构造器,接受一个任意对象(具体的配置信息)
	 * 
	 * @param config
	 */
	public DataSourceConfig(Object config) {
		setConfig(config);
	}

	/**
	 * 由子类继承重写的方法,从获取的config值中进行BasicDataSource的配置工作
	 */
	public void start() {

	}

	/*------------------ setter & getter ------------------*/

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Object getConfig() {
		return config;
	}

	public void setConfig(Object config) {
		this.config = config;
	}
}
