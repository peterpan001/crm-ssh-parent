package com.crm_ssh_dao.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Visit;

/**
 * 拜访的持久层接口
 * @author Peter
 *
 */
public interface VisitDao {

	/**
	 * 保存拜访的记录
	 * @param visit
	 */
	public void saveVisit(Visit visit);
	
	/**
	 * 按条件查询拜访记录
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
