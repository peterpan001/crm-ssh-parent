package com.crm_ssh_web.web.action.interceptor;

import org.apache.struts2.ServletActionContext;

import com.crm_ssh_domain.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -3954880711389298269L;

	protected String doIntercept(ActionInvocation invoke) throws Exception {
		User u1 = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(u1==null){
			return "login";
		}
		return invoke.invoke();
	}

}
