package com.crm_ssh_dao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm_ssh_dao.dao.UserDao;
import com.crm_ssh_domain.domain.User;

public class UserTest {

	@SuppressWarnings("resource")
	@Test
	public void testFindCode(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		User user = userDao.findCode("admin");
		System.out.println(user);
	}
}
