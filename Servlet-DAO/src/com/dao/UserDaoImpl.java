package com.dao;

import java.sql.*;
import java.util.*;

import com.models.User;

public class UserDaoImpl extends NormalDao implements UserDao {

	final static String ALL_USER = "SELECT * FROM tb_user;";
	final static String INSERT = "INSERT INTO tb_user (id,name,tel,passwd) VALUES(?,?,?,?);";
	final static String FIND_BY_ID = "SELECT * FROM tb_user where id=?;";
	final static String UPDATE = "UPDATE tb_user SET name=?, tel=?, passwd=? WHERE id=?;";
	final static String DELETE = "DELETE FROM tb_user WHERE id=?;";

	@Override
	public boolean delete(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(preparedStatement);
			close(connection);
		}

		return false;
	}

	@Override
	public List<User> findAll() {

		ArrayList<User> list = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(ALL_USER);

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int tel = resultSet.getInt("tel");
				int passwd = resultSet.getInt("passwd");

				// 初始化用户
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setTel(tel);
				user.setPasswd(passwd);

				// 添加用户
				list.add(user);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(resultSet);
			close(statement);
			close(connection);
		}

		return list;
	}

	@Override
	public User findById(int id) {

		User tmpUser = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(FIND_BY_ID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				int userId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int tel = resultSet.getInt("tel");
				int passwd = resultSet.getInt("passwd");

				// 初始化用户
				User user = new User();
				user.setId(userId);
				user.setName(name);
				user.setTel(tel);
				user.setPasswd(passwd);

				tmpUser = user;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(resultSet);
			close(preparedStatement);
			close(connection);
		}

		return tmpUser;
	}

	@Override
	public void insertUser(User user) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setInt(3, user.getTel());
			preparedStatement.setInt(4, user.getPasswd());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(preparedStatement);
			close(connection);
		}
	}

	@Override
	public void updateUser(User user) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getTel());
			preparedStatement.setInt(3, user.getPasswd());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(preparedStatement);
			close(connection);
		}
	}
}
