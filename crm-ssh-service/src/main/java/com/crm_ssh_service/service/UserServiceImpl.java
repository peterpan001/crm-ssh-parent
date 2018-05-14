package com.crm_ssh_service.service;

import com.crm_ssh_common.utils.MD5Utils;
import com.crm_ssh_dao.dao.UserDao;
import com.crm_ssh_domain.domain.User;

/**
 * 用户的业务层实现类
 * @author Peter
 *
 */
public class UserServiceImpl implements UserService{
	
	/**
	 * set方法注入持久层dao
	 */
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 通过用户名查询用户
	 */
	public User findCode(String user_code) {
		return userDao.findCode(user_code);
	}

	/**
	 * 保存用户
	 */
	public void save(User user) {
		String user_password = user.getUser_password();
		user.setUser_password(MD5Utils.md5(user_password));
		user.setUser_state("1");
		userDao.save(user);
	}

	/**
	 * 通过用户名和密码查询用户
	 */
	public User findUser(User user) {
		String user_password = user.getUser_password();
		user.setUser_password(MD5Utils.md5(user_password));
		return userDao.findUser(user);
	}

	/**
	 * 通过id查询用户
	 */
	public User findUserById(Long user_id) {
		return userDao.findUserById(user_id);
	}

	/**
	 * 修改密码
	 */
	public boolean updatePwd(String pwdId1, String pwdId2, User u1) {
		if(u1.getUser_password().equals(pwdId1)){
			u1.setUser_password(pwdId2);
			userDao.updatePwd(u1);
			return true;
		}
		return false;
	}

}
