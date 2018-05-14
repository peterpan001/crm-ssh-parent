package com.crm_ssh_web.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_domain.domain.User;
import com.crm_ssh_domain.domain.Visit;
import com.crm_ssh_service.service.VisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 拜访的表现层
 * @author Peter
 *
 */
@Controller(value="visitAction")
@Scope(value="prototype")
public class VisitAction extends ActionSupport implements ModelDriven<Visit> {

	private static final long serialVersionUID = 6454692291394218368L;
	
	@Resource(name="visitService")
	private VisitService visitService;
	
	private Visit visit = new Visit();
	public Visit getModel() {
		return visit;
	}

	/**
	 * 跳转到初始化添加页面
	 * @return
	 */
	public String initAddUI(){
		return "addVisitUI";
	}
	
	/**
	 * 保存拜访记录
	 * @return
	 */
	public String add(){
		User u1 = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		visit.setUser(u1);
		visitService.saveVisit(visit);
		return "addVisit";
	}
	
	/**
	 * 查询拜访客户列表
	 * @return
	 */
	private Integer pageCode = 1;
	private Integer pageSize = 5;
	public Integer getPageCode() {
		return pageCode;
	}
	public void setPageCode(Integer pageCode) {
		if(pageCode == null){
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
	private String beginDate;
	private String endDate;
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		String visit_interviewee = visit.getVisit_interviewee();
		if(visit_interviewee!=null && !visit_interviewee.trim().isEmpty()){
			criteria.add(Restrictions.like("visit_interviewee", "%"+visit_interviewee+"%"));
		}
		if(beginDate!=null && !beginDate.trim().isEmpty()){
			criteria.add(Restrictions.ge("visit_time", beginDate));
		}
		if(endDate!=null && !endDate.trim().isEmpty()){
			criteria.add(Restrictions.le("visit_time", endDate));
		}
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		criteria.add(Restrictions.eq("user.user_id", u.getUser_id()));
		PageBean<Visit> page = visitService.findByPage(this.getPageCode(), this.getPageSize(), criteria);
		ActionContext.getContext().getValueStack().set("page", page);
		ServletActionContext.getRequest().setAttribute("visit_interviewee", visit_interviewee);
		ServletActionContext.getRequest().setAttribute("beginDate", beginDate);
		ServletActionContext.getRequest().setAttribute("endDate", endDate);
		return "listVisit";
	}
	
}
