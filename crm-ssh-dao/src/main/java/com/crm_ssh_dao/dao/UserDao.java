package com.crm_ssh_dao.dao;

import com.crm_ssh_domain.domain.User;
/**
 * 持久层dao接口
 * @author Peter
 */
public interface UserDao {

	/**
	 * 通过用户名查询用户
	 * @param user_code
	 * @return
	 */
	public User findCode(String user_code);
	
	/**
	 * 保存用户
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * 通过用户名和密码查询用户
	 * @param user
	 */
	public User findUser(User user);
	
	/**
	 * 通过用户id查询用户
	 * @param user_id
	 * @return
	 */
	public User findUserById(Long user_id);

	/**
	 * 修改用户密码
	 * @param u1
	 */
	public void updatePwd(User u1);
}
