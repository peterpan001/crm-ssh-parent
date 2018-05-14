package com.crm_ssh_service.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Customer;

/**
 * 客户业务层接口
 * @author Peter
 *
 */
public interface CustomerService {

	/**
	 * 保存客户
	 * @param customer
	 */
	public void saveCustomer(Customer customer);
	
	/**
	 * 通过id查找客户
	 * @param cust_id
	 * @return
	 */
	public Customer findCustomerById(Long cust_id);
	
	/**
	 * 更新客户
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * 删除客户
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);
	
	/**
	 * 查找所有客户列表
	 * @return
	 */
	public List<Customer> findAllCustomer();
	
	/**
	 * 分页查找客户
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
