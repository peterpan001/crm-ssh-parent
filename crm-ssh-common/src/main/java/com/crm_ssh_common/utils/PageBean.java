package com.crm_ssh_common.utils;

import java.util.List;

/**
 * 分页
 * @author Peter
 * @param <T>
 */
public class PageBean<T> {

	//当前页
	private Integer pageCode;
	//每页显示的记录数
	private Integer pageSize;
	//总记录数
	private Integer totalCount;
	//每页显示的数据
	private List<T> beanList;
	
	public Integer getPageCode() {
		return pageCode;
	}
	public void setPageCode(Integer pageCode) {
		this.pageCode = pageCode;
	}
	
	/**
	 * 调用getTotalPage() 获取到总页数
	 * JavaBean的属性规定：totalPage是JavaBean是属性 ${pageBean.totalPage}
	 * @return
	 */
	public Integer getTotalPage() {
		// 计算
		int totalPage = totalCount / pageSize;
		// 说明整除
		if(totalCount % pageSize == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
}
