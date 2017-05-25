package com.listeners;

import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dao.NormalDataSourceConfig;
import com.libs.dbcp.DbcpManager;

public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[Listener] contextInitialized(ServletContextEvent)");
		libInit(sce);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[Listener] contextDestroyed(ServletContextEvent)");
	}

	private void libInit(ServletContextEvent sce) {

		// 数据库连接池基本配置
		HashMap<String, String> map = new HashMap<>();
		map.put("url", new String(new StringBuffer(sce.getServletContext().getInitParameter("url"))
				.append("?useUnicode=true&characterEncoding=utf-8&useSSL=false")));
		map.put("userName", sce.getServletContext().getInitParameter("userName"));
		map.put("passwd", sce.getServletContext().getInitParameter("passwd"));
		map.put("driverClassName", sce.getServletContext().getInitParameter("driverClassName"));

		// 注册一个数据库连接池
		DbcpManager.registerBasicDataSource("DB");

		// 配置一个数据库连接池
		DbcpManager.configBasicDataSource("DB", new NormalDataSourceConfig(map));
	}
}
