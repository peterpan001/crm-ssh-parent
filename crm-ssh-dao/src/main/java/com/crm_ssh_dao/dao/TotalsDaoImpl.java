package com.crm_ssh_dao.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * 统计的持久化实现类
 * @author Peter
 */
@Repository(value="totalsDao")
public class TotalsDaoImpl extends HibernateDaoSupport implements TotalsDao {
	
	@Resource(name="sessionFactory")
	public void set2SessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * 统计客户来源
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findSource() {
		String hql = "select c.source.dict_item_name, count(*) from Customer c inner join c.source group by c.source";
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 统计客户行业
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findVocations() {
		String hql = "select c.industry.dict_item_name, count(*) from Customer c inner join c.industry group by c.industry";
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find(hql);
		return list;
	}

}
