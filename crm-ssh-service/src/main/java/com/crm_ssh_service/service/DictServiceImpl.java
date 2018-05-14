package com.crm_ssh_service.service;

import java.util.List;

import com.crm_ssh_dao.dao.DictDao;
import com.crm_ssh_domain.domain.Dict;

/**
 * 字典业务层实现类
 * @author Peter
 */
public class DictServiceImpl implements DictService {

	private DictDao dictDao;
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	/**
	 * 通过code查找Dict列表
	 */
	public List<Dict> findDictByCode(String dict_type_code) {
		return dictDao.findDictByCode(dict_type_code);
	}

}
