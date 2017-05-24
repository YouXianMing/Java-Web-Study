package com.libs.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceConfig {

    private BasicDataSource dataSource;
    private Object config;

    public DataSourceConfig(Object config) {
        setConfig(config);
    }

    public void start() {

    }

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
