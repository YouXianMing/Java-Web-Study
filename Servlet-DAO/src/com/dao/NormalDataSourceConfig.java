package com.dao;

import java.util.HashMap;

import com.libs.dbcp.DataSourceConfig;

public class NormalDataSourceConfig extends DataSourceConfig {

	public NormalDataSourceConfig(Object config) {
		super(config);
	}

	@Override
	public void start() {

		if (getConfig() != null) {

			@SuppressWarnings("unchecked")
			HashMap<String, String> map = (HashMap<String, String>) getConfig();
			getDataSource().setUrl(map.get("url"));
			getDataSource().setDriverClassName(map.get("driverClassName"));
			getDataSource().setUsername(map.get("userName"));
			getDataSource().setPassword(map.get("passwd"));
		}
	}
}
