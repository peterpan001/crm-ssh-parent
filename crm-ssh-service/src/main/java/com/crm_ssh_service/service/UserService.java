package com.crm_ssh_service.service;

import com.crm_ssh_domain.domain.User;
/**
 * 用户业务层接口
 * @author Peter
 *
 */
public interface UserService {

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
	 * 修改用户的密码
	 * @param pwdId1
	 * @param pwdId2
	 * @param u1 
	 * @return
	 */
	public boolean updatePwd(String pwdId1, String pwdId2, User u1);
}
