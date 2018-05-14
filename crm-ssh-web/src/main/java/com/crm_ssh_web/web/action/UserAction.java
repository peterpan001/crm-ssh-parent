package com.crm_ssh_web.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crm_ssh_common.utils.MD5Utils;
import com.crm_ssh_domain.domain.User;
import com.crm_ssh_service.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 用户的Action
 * @author Peter
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = -215119291303819022L;
	//模型驱动加载前台表单数据
	private User user = new User();
	public User getModel() {
		return user;
	}
	//set方法注入userService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 注册时检查用名是否存在
	 * @return
	 * @throws IOException
	 */
	public String checkCode() throws IOException{
		String user_code = user.getUser_code();
		User u = userService.findCode(user_code);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		if(u==null){
			writer.print("yes");
		}else{
			writer.print("no");
		}
		return NONE;
	}
	
	/**
	 * 用户的注册
	 * @return
	 */
	public String regist(){
		//接收前台传来的参数进行用户注册
		userService.save(user);
		return "login";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		User existUser = userService.findUser(user);
		if(existUser==null){
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名或者密码错误");
			ServletActionContext.getRequest().setAttribute("user_code", user.getUser_code());
			return "login";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginOk";
		}
	}
	
	/**
	 * 用户退出登录
	 * @return
	 */
	public String loginOut(){
		ServletActionContext.getRequest().getSession().removeAttribute("existUser");
		return "login";
	}
	
	/**
	 * 跳转到修改密码页面
	 * @return
	 */
	public String initResetPwdUI(){
		return "initResetPwdUI";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String resetPwd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String pwdId1 = request.getParameter("user_pwd1");
		String pwdId2 = request.getParameter("user_pwd2");
		User u1 = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		boolean flag = userService.updatePwd(MD5Utils.md5(pwdId1), MD5Utils.md5(pwdId2), u1);
		if(flag==true){
			return "login";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "对不起你输入的密码错误");
			return "initResetPwdUI";
		}
		
	}
	
}
