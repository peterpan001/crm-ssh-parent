package com.crm_ssh_service.service;

import java.util.List;

import com.crm_ssh_domain.domain.Dict;

/**
 * 字典的业务层接口
 * @author Peter
 *
 */
public interface DictService {
	
	/**
	 * 通过code查找Dict列表
	 * @param dict_type_code
	 * @return
	 */
	public List<Dict> findDictByCode(String dict_type_code);
}
