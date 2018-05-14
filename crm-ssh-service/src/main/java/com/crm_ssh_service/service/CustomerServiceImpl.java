package com.crm_ssh_service.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_dao.dao.CustomerDao;
import com.crm_ssh_domain.domain.Customer;

/**
 * 客户业务层实现类
 * @author Peter
 *
 */
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * 保存客户
	 */
	public void saveCustomer(Customer customer) {
		
		customerDao.saveCustomer(customer);
	}

	/**
	 * 通过id查找客户
	 */
	public Customer findCustomerById(Long cust_id) {

		return customerDao.findCustomerById(cust_id);
	}

	/**
	 * 更新客户
	 */
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	/**
	 * 删除客户
	 */
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	/**
	 * 查找客户列表
	 */
	public List<Customer> findAllCustomer() {
		
		return customerDao.findAllCustomer();
	}

	/**
	 * 按条件分页查询客户列表
	 */
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {

		return customerDao.findByPage(pageCode, pageSize, criteria);
	}
	
}
