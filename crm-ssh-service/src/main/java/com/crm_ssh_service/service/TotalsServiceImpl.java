package com.crm_ssh_service.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm_ssh_dao.dao.TotalsDao;

/**
 * 统计业务层的实现
 * @author Peter
 *
 */
@Service(value="totalsService")
public class TotalsServiceImpl implements TotalsService {

	@Resource(name="totalsDao")
	private TotalsDao totalsDao;

	/**
	 * 查找客户来源
	 */
	public List<Object[]> findSource() {
		return totalsDao.findSource();
	}

	/**
	 * 查找客户行业
	 */
	public List<Object[]> findVocations() {
		return totalsDao.findVocations();
	}

	
}
