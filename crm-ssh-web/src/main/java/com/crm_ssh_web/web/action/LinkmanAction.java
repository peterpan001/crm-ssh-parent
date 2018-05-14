package com.crm_ssh_web.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.Linkman;
import com.crm_ssh_service.service.LinkmanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 联系人的表现层
 * @author Peter
 *
 */
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman>{

	private static final long serialVersionUID = -2165511033851845406L;
	private LinkmanService linkmanService;
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}
	private Linkman linkman = new Linkman();
	public Linkman getModel() {
		return linkman;
	}
	
	/**
	 * 跳转到初始化添加页面
	 * @return
	 */
	public String initAddUI(){
		return "addLinkmanUI";
	}
	
	/**
	 * 添加联系人
	 * @return
	 */
	public String add(){
		linkmanService.saveLinkman(linkman);
		return "addLinkman";
	}
	
	/**
	 * 分页查询联系人
	 * @return
	 */
	private Integer pageCode = 1;
	private Integer pageSize = 5;
	public Integer getPageCode() {
		return pageCode;
	}
	public void setPageCode(Integer pageCode) {
		if(pageCode==null){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize = 5;
		}
		this.pageSize = pageSize;
	}

	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		
		String lkm_name = linkman.getLkm_name();
		
		if(lkm_name!=null && !lkm_name.trim().isEmpty()){
			criteria.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
		}
		if(linkman.getCustomer()!=null && linkman.getCustomer().getCust_id()!=null){
			criteria.add(Restrictions.like("customer.cust_id", linkman.getCustomer().getCust_id()));
		}
		PageBean<Linkman> page = linkmanService.findByPage(this.getPageCode(), this.getPageSize(), criteria);
		ActionContext.getContext().getValueStack().set("page", page);
		return "listLinkman";
	}

	/**
	 * 跳转到初始化编辑联系人页面
	 * @return
	 */
	public String initEdit(){
		Long lkm_id = linkman.getLkm_id();
		linkman = linkmanService.findLinkmanById(lkm_id);
		return "updateLinkmanUI";
	}
	
	/**
	 * 修改联系人
	 * @return
	 */
	public String edit(){
		linkmanService.updateLinkman(linkman);
		return "updateLinkman";
	}
	
	/**
	 * 删除联系人
	 * @return
	 */
	public String delete(){
		linkmanService.deleteLinkman(linkman);
		return "deleteLinkman";
	}
}
