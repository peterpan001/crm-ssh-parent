package com.crm_ssh_service.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_dao.dao.CustomerDao;
import com.crm_ssh_dao.dao.LinkmanDao;
import com.crm_ssh_domain.domain.Customer;
import com.crm_ssh_domain.domain.Linkman;

/**
 * 联系人业务层实现类
 * @author Peter
 *
 */
public class LinkmanServiceImpl implements LinkmanService {

	private LinkmanDao linkmanDao;
	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao = customerDao;
	}
	/**
	 * 保存联系人
	 */
	public void saveLinkman(Linkman linkman) {
		Long cust_id = linkman.getCustomer().getCust_id();
		Customer customer = customerDao.findCustomerById(cust_id);
		linkman.setCustomer(customer);
		linkmanDao.saveLinkman(linkman);
	}

	/**
	 * 更新联系人
	 */
	public void updateLinkman(Linkman linkman) {
		Long cust_id = linkman.getCustomer().getCust_id();
		Customer customer = customerDao.findCustomerById(cust_id);
		linkman.setCustomer(customer);
		linkmanDao.updateLinkman(linkman);
	}

	/**
	 * 删除联系人
	 */
	public void deleteLinkman(Linkman linkman) {

		linkmanDao.deleteLinkman(linkman);
	}

	/**
	 * 通过id查询联系人
	 */
	public Linkman findLinkmanById(Long lkm_id) {

		return linkmanDao.findLinkmanById(lkm_id);
	}

	/**
	 * 分页查询
	 */
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		
		return linkmanDao.findByPage(pageCode, pageSize, criteria);
	}

	
}
