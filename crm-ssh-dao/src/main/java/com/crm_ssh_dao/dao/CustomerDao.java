package com.crm_ssh_dao.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Customer;

/**
 * 客户的持久化接口
 * @author Peter
 */
public interface CustomerDao {

	/**
	 * 保存客户
	 * @param customer
	 */
	public void saveCustomer(Customer customer);
	
	/**
	 * 通过id查询客户
	 * @param cust_id
	 * @return
	 */
	public Customer findCustomerById(Long cust_id);
	
	/**
	 * 编辑客户
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * 删除客户
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);
	
	/**
	 * 查询所有客户
	 * @return
	 */
	public List<Customer> findAllCustomer();
	
	/**
	 * 分页查询客户
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
