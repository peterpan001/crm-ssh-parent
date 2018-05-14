package com.crm_ssh_web.web.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm_ssh_common.utils.FastJsonUtil;
import com.crm_ssh_common.utils.PageBean;
import com.crm_ssh_common.utils.UploadUtils;
import com.crm_ssh_domain.domain.Customer;
import com.crm_ssh_service.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 客户的表现层
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1101612588893943907L;
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	/**
	 * 跳转到初始化添加客户页面
	 * @return
	 */
	public String initAddUI(){
		return "addCustomer";
	}

	/**
	 * 保存客户
	 * @return
	 * @throws Exception
	 */
	private File upload;//表示要上传的文件
	private String uploadFileName;//表示要上传文件的名字
	private String uploadContentType;//表示要上传文件的类型
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String add()throws Exception{
		//保存客户时先要判断客户是否上传了附件
		if(uploadFileName!=null){ //表示客户上传了附件
			//利用uuid处理附件的名字使其全局唯一
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			//声明保存的路径
			String path = "D:\\program\\eclipse_mars_chuanzhiboke\\tomat\\apache-tomcat-7.0.53\\webapps\\upload\\";
			//保存客户附件
			File file = new File(path + uuidName);
			FileUtils.copyFile(upload, file);
			customer.setCust_file_path(path + uuidName);
		}
		customerService.saveCustomer(customer);
		return "saveCustomer";
	}
	/**
	 * 按条件查询客户列表
	 * @return
	 */
	private Integer pageCode=1;
	private Integer pageSize=5;
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
		if(pageSize==null){
			pageSize = 5;
		}
		this.pageSize = pageSize;
	}
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		String cust_name = customer.getCust_name();
		if(cust_name!=null && !cust_name.trim().isEmpty()){
			criteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		
		if(customer.getSource()!=null && !customer.getSource().getDict_id().trim().isEmpty()){
			criteria.add(Restrictions.eq("source.dict_id", customer.getSource().getDict_id()));
		}
		
		if(customer.getLevel()!=null && !customer.getLevel().getDict_id().trim().isEmpty()){
			criteria.add(Restrictions.eq("level.dict_id", customer.getLevel().getDict_id()));
		}
		
		if(customer.getIndustry()!=null && !customer.getIndustry().getDict_id().trim().isEmpty()){
			criteria.add(Restrictions.eq("industry.dict_id", customer.getIndustry().getDict_id()));
		}
		PageBean<Customer> page = customerService.findByPage(this.getPageCode(), this.getPageSize(), criteria);
		ActionContext.getContext().getValueStack().set("page", page);
		
		return "listCustomer";
	}
	
	/**
	 * 跳转到初始化编辑页面
	 * @return
	 */
	public String initEdit(){
		Long cust_id = customer.getCust_id();
		customer = customerService.findCustomerById(cust_id);
		return "initEdit";
	}
	
	/**
	 * 修改客户
	 * @return
	 */
	public String edit()throws Exception{
		if(uploadFileName!=null){
			String cust_file_path = customer.getCust_file_path();
			if(cust_file_path!=null && !cust_file_path.trim().isEmpty()){
				File file = new File(cust_file_path);
				if(file.exists()){
					file.delete();
				}
			}
			//生成全局唯一的名字
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			//设置路径
			String path = "D:\\program\\eclipse_mars_chuanzhiboke\\tomat\\apache-tomcat-7.0.53\\webapps\\upload\\";
			File file = new File(path + uuidName);
			FileUtils.copyFile(upload, file);
			customer.setCust_file_path(path + uuidName);
		}
		customerService.updateCustomer(customer);
		return "editCustomer";
	}
	
	/**
	 * 删除客户
	 * @return
	 */
	public String delete(){
		Long cust_id = customer.getCust_id();
		Customer c1 = customerService.findCustomerById(cust_id);
		if(c1.getCust_file_path()!=null){
			File file = new File(c1.getCust_file_path());
			if(file.exists()){
				file.delete();
			}
		}
		customerService.deleteCustomer(c1);
		return "deleteCustomer";
	}
	
	/**
	 * 查询所有客户
	 * @return
	 */
	public String findAllCustomer(){
		
		List<Customer> list = customerService.findAllCustomer();
		String jsonStr = FastJsonUtil.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonStr);
		return NONE;
	}
}
