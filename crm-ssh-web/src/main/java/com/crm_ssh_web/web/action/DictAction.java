package com.crm_ssh_web.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crm_ssh_common.utils.FastJsonUtil;
import com.crm_ssh_domain.domain.Dict;
import com.crm_ssh_service.service.DictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 字典的表现层
 * @author Peter
 *
 */
public class DictAction extends ActionSupport implements ModelDriven<Dict>{

	private static final long serialVersionUID = -3068206541881175243L;
	private Dict dict = new Dict();
	public Dict getModel() {
		return dict;
	}
	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	/**
	 * 通过dict_type_code查找Dict
	 * @return
	 */
	public String findDictByCode(){
		String dict_type_code = dict.getDict_type_code();
		List<Dict> list = dictService.findDictByCode(dict_type_code);
		String jsonStr = FastJsonUtil.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonStr);
		return NONE;
	}
}
