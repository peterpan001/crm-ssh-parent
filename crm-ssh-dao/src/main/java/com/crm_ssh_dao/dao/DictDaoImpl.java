package com.crm_ssh_dao.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm_ssh_domain.domain.Dict;

/**
 * 字典的持久化实现类
 * @author Peter
 *
 */
public class DictDaoImpl extends HibernateDaoSupport implements DictDao {

	/**
	 * 通过dict_type_code查找dict_item_name
	 */
	@SuppressWarnings("unchecked")
	public List<Dict> findDictByCode(String dict_type_code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Dict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<Dict> list = (List<Dict>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	
}
