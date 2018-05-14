package com.crm_ssh_service.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_dao.dao.CustomerDao;
import com.crm_ssh_dao.dao.VisitDao;
import com.crm_ssh_domain.domain.Customer;
import com.crm_ssh_domain.domain.Visit;

/**
 * 拜访客户的业务层实现类
 * @author Peter
 */
@Service(value="visitService")
public class VisitServiceImpl implements VisitService {

	@Resource(name="visitDao")
	private VisitDao visitDao;
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	
	/**
	 * 保存拜访记录
	 */
	public void saveVisit(Visit visit) {
		Long cust_id = visit.getCustomer().getCust_id();
		Customer customer = customerDao.findCustomerById(cust_id);
		visit.setCustomer(customer);
		visitDao.saveVisit(visit);
	}
	
	/**
	 * 分页查询拜访记录
	 */
	public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		
		return visitDao.findByPage(pageCode, pageSize, criteria);
	}
	
}
