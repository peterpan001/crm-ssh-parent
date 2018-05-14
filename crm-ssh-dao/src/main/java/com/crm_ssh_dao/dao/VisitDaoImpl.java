package com.crm_ssh_dao.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Visit;
/**
 * 拜访的持久化实现类
 * @author Peter
 *
 */
@Repository(value="visitDao")
public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	@Resource(name="sessionFactory")
	public void set2SessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * 保存拜访记录
	 */
	public void saveVisit(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	/**
	 * 按条件查询拜访记录
	 */
	@SuppressWarnings("unchecked")
	public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Visit> pageBean = new PageBean<Visit>();
		pageBean.setPageCode(pageCode);
		
		pageBean.setPageSize(pageSize);
		
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list.size() > 0){
			pageBean.setTotalCount(list.get(0).intValue());
		}
	
		criteria.setProjection(null);
		List<Visit> list2 = (List<Visit>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		pageBean.setBeanList(list2);
		
		return pageBean;
	}

}
