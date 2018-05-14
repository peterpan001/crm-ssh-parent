package com.crm_ssh_dao.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm_ssh_domain.domain.User;

/**
 * 用户持久层实现类
 * @author Peter
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/**
	 * 通过用户名查询用户
	 */
	@SuppressWarnings("unchecked")
	public User findCode(String user_code) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 保存用户
	 */
	public void save(User user) {

		this.getHibernateTemplate().save(user);
	}

	/**
	 * 通过用户查找用户
	 */
	@SuppressWarnings("unchecked")
	public User findUser(User user) {

		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code", user.getUser_code()));
		criteria.add(Restrictions.eq("user_password", user.getUser_password()));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 通过id查询用户
	 */
	public User findUserById(Long user_id) {
		return this.getHibernateTemplate().get(User.class, user_id);
	}

	/**
	 * 修改用户密码
	 */
	public void updatePwd(User u1) {
		this.getHibernateTemplate().update(u1);
	}
	
}
