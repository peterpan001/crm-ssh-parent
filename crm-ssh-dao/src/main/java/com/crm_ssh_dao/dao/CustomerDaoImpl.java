package com.crm_ssh_dao.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Customer;

/**
 * 客户的持久化实现类
 * @author Peter
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	/**
	 * 保存客户
	 */
	public void saveCustomer(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	/**
	 * 通过id查询客户
	 */
	public Customer findCustomerById(Long cust_id) {
		
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}

	/**
	 * 更新客户
	 */
	public void updateCustomer(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	/**
	 * 删除客户
	 */
	public void deleteCustomer(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	/**
	 * 查询所有客户
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomer() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	/**
	 * 分页查询客户
	 */
	@SuppressWarnings("unchecked")
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		
		pageBean.setPageCode(pageCode);
		
		pageBean.setPageSize(pageSize);
		
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list.size() >0){
			pageBean.setTotalCount(list.get(0).intValue());
		}
		
		criteria.setProjection(null);
		List<Customer> list2 = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		pageBean.setBeanList(list2);
		
		return pageBean;
	}

}
