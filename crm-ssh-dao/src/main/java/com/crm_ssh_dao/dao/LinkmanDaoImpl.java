package com.crm_ssh_dao.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Linkman;

/**
 * linkman的持久化实现类
 * @author Peter
 *
 */
public class LinkmanDaoImpl extends HibernateDaoSupport implements LinkmanDao {

	/**
	 * 保存联系人
	 */
	public void saveLinkman(Linkman linkman) {
		this.getHibernateTemplate().save(linkman);
	}

	/**
	 * 通过id查询联系人
	 */
	public Linkman findLinkmanById(Long lkm_id) {
		return this.getHibernateTemplate().get(Linkman.class, lkm_id);
	}

	/**
	 * 更新联系人
	 */
	public void updateLinkman(Linkman linkman) {
		this.getHibernateTemplate().update(linkman);
	}

	/**
	 * 删除联系人
	 */
	public void deleteLinkman(Linkman linkman) {
		this.getHibernateTemplate().delete(linkman);
	}

	/**
	 * 按条件分页查询联系人
	 */
	@SuppressWarnings("unchecked")
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Linkman> pageBean = new PageBean<Linkman>();
		pageBean.setPageCode(pageCode);
		
		pageBean.setPageSize(pageSize);
		
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list.size() > 0){
			pageBean.setTotalCount(list.get(0).intValue());
		}
		
		criteria.setProjection(null);
		List<Linkman> list2 = (List<Linkman>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		pageBean.setBeanList(list2);

		return pageBean;
	}

}
