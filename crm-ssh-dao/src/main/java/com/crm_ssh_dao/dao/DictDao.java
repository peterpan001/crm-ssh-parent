package com.crm_ssh_dao.dao;

import java.util.List;

import com.crm_ssh_domain.domain.Dict;

/**
 * 字典的持久化接口
 * @author Peter
 */
public interface DictDao {

	/**
	 * 通过dict_type_code查找dict_item_name
	 * @param dict_type_code
	 * @return
	 */
	public List<Dict> findDictByCode(String dict_type_code);
}
