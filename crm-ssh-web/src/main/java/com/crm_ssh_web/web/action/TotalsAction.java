package com.crm_ssh_web.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.crm_ssh_service.service.TotalsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller(value="totalsAction")
@Scope(value="prototype")
public class TotalsAction extends ActionSupport{

	private static final long serialVersionUID = 7357675055690403698L;
	@Resource(name="totalsService")
	private TotalsService totalsService;
	
	/**
	 * 统计行业
	 * @return
	 */
	public String findVocations(){
		List<Object[]> list = totalsService.findVocations();
		ActionContext.getContext().getValueStack().set("list", list);
		return "findVocations";
	}
	
	/**
	 * 统计来源
	 * @return
	 */
	public String findSources(){
		List<Object[]> list = totalsService.findSource();
		ActionContext.getContext().getValueStack().set("list", list);
		return "findSources";
	}
	
	
}
