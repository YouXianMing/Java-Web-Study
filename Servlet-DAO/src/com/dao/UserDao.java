package com.dao;

import java.util.List;

import com.models.User;

public interface UserDao {

	/**
	 * 根据id删除指定的数据
	 * 
	 * @param id
	 *            需要删除的数据的id
	 * @return 是否删除成功
	 */
	public boolean delete(int id);

	/**
	 * 插入用户
	 * 
	 * @param user
	 *            User对象
	 */
	public void insertUser(User user);

	/**
	 * 更新用户
	 * 
	 * @param user
	 *            User对象
	 */
	public void updateUser(User user);

	/**
	 * 获取所有的数据
	 * 
	 * @return 所有的数据列表
	 */
	public List<User> findAll();

	/**
	 * 根据id查询到指定的数据
	 * 
	 * @param id
	 *            查询用id
	 * @return 如果存在返回User,不存在,返回空
	 */
	public User findById(int id);
}
