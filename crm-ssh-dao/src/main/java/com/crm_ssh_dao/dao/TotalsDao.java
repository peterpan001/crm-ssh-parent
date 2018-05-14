package com.crm_ssh_dao.dao;

import java.util.List;

/**
 * 统计模块的持久层接口
 * @author Peter
 *
 */
public interface TotalsDao {

	/**
	 * 统计客户来源
	 * @return
	 */
	public List<Object[]> findSource();
	
	/**
	 * 统计客户行业
	 * @return
	 */
	public List<Object[]> findVocations();
}
