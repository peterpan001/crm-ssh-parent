package com.crm_ssh_dao.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Linkman;

/**
 * linkman的持久化接口
 * @author Peter
 *
 */
public interface LinkmanDao {

	/**
	 * 保存联系人
	 * @param linkman
	 */
	public void saveLinkman(Linkman linkman);
	
	/**
	 * 通过id查询联系人
	 * @param lkm_id
	 * @return
	 */
	public Linkman findLinkmanById(Long lkm_id);
	
	/**
	 * 修改联系人
	 * @param linkman
	 */
	public void updateLinkman(Linkman linkman);
	
	/**
	 * 删除联系人
	 * @param linkman
	 */
	public void deleteLinkman(Linkman linkman);
	
	/**
	 * 分页查询联系人
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
