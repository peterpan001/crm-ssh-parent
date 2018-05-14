package com.crm_ssh_service.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Visit;

/**
 * 拜访的业务层接口
 * @author Peter
 *
 */
public interface VisitService {

	/**
	 * 保存拜访记录
	 * @param visit
	 */
	public void saveVisit(Visit visit);
	
	/**
	 * 按条件分页查询
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
