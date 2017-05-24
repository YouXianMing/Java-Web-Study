package com.libs.dbcp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbcpManager {

    private static DbcpManager singleton = new DbcpManager();
    private HashMap<String, BasicDataSource> map;

    private DbcpManager() {
        map = new HashMap<>();
    }

    public static final void registerBasicDataSource(String name) {
        BasicDataSource dataSource = new BasicDataSource();
        singleton.map.put(name, dataSource);
    }

    public static final BasicDataSource getBasicDataSource(String name) {
        return singleton.map.get(name);
    }
    
    public static final void configBasicDataSource(String name, DataSourceConfig config) {
        BasicDataSource dataSource = singleton.map.get(name);
        if (dataSource != null) {
            config.setDataSource(singleton.map.get(name));
            config.start();   
        }
    }

    public static final Connection getConnectionFromBasicDataSource(String name) throws SQLException {
        BasicDataSource dataSource = singleton.map.get(name);
        if (dataSource != null) {
            return dataSource.getConnection();
        } else {
            return null;
        }
    }
}
