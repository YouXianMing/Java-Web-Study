package com.libs.dbcp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author YouXianMing1987@iCloud.com
 * 以链式编程简化PreparedStatement的使用
 */
public class PreparedStatementCreator {

	private PreparedStatement statement;
	private Integer index = 1;

	/**
	 * PreparedStatementCreator的便利构造器
	 * 
	 * @param statement PreparedStatement对象
	 * @return PreparedStatementCreator对象
	 */
	public static PreparedStatementCreator with(PreparedStatement statement) {

		PreparedStatementCreator creator = new PreparedStatementCreator();
		creator.setStatement(statement);
		return creator;
	}

	/**
	 * 设置具体的数值
	 * 
	 * @param x 具体的数字
	 * @return PreparedStatementCreator对象
	 * @throws SQLException
	 */
	public PreparedStatementCreator setInt(int x) throws SQLException {

		getStatement().setInt(index++, x);
		return this;
	}

	/**
	 * 设置具体的字符串
	 * 
	 * @param x 具体的字符串
	 * @return PreparedStatementCreator对象
	 * @throws SQLException
	 */
	public PreparedStatementCreator setString(String x) throws SQLException {

		getStatement().setString(index++, x);
		return this;
	}

	/*------------------ setter & getter ------------------*/

	public PreparedStatement getStatement() {
		return statement;
	}

	public void setStatement(PreparedStatement statement) {
		this.statement = statement;
	}
}
