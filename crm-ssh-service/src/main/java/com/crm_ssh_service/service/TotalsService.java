package com.crm_ssh_service.service;

import java.util.List;

/**
 * 统计的业务层接口
 * @author Peter
 *
 */
public interface TotalsService {

	/**
	 * 查找客户来源
	 * @return
	 */
	List<Object[]> findSource();
	
	/**
	 * 查找客户行业
	 * @return
	 */
	List<Object[]> findVocations();
}
