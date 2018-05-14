<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path = request.getContextPath();//获取到项目的跟路径即WebContent
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户拜访</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=basePath%>css/Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath%>css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>jquery/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">
	$(function(){
		//时间控件		
		//使用class属性处理,'yy-mm-dd'设置格式为"yyyy/mm/dd"
		$("#timeId").datepick({dateFormat:'yy-mm-dd'});
		$("#nextTimeId").datepick({dateFormat:'yy-mm-dd'});
		
		//显示客户下拉列表
		url="<%=basePath%>customer_findAllCustomer.action";
		$.post(url, function(data){
			$(data).each(function(){
				$("#customerId").append("<option value='"+this.cust_id+"'>"+this.cust_name+"</option>");
			});
		},"json");
		
	});
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="<%=basePath%>visit_add.action" method=post>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="<%=basePath%>images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="<%=basePath%>images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="<%=basePath%>images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="<%=basePath%>images/new_022.jpg"><IMG
						src="<%=basePath%>images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户拜访管理 &gt; 添加客户拜访</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>客户名称：</td>
								<td>
									<select id="customerId" style="WIDTH: 180px" maxLength=50 name="customer.cust_id"></select>
								</td>
								
								<td>拜访时间：</td>
								<td>
									<INPUT class=textbox id="timeId" style="WIDTH: 180px" maxLength=50 name="visit_time" 
										value="<fmt:formatDate value="${visit.visit_time}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="readonly">
								</td>
								
							</tr>
							
							<TR>
								<td>被拜访人：</td>
								<td>
									<INPUT class=textbox style="WIDTH: 180px" maxLength=50 name="visit_interviewee">
								</td>
								<td>拜访地点：</td>
								<td>
									<INPUT class=textbox style="WIDTH: 180px" maxLength=50 name="visit_addr">
								</td>
							</TR>
							
							<TR>
								<td>下次拜访时间 ：</td>
								<td>
									<INPUT class=textbox id="nextTimeId" style="WIDTH: 180px" maxLength=50 name="visit_nexttime" 
										value="<fmt:formatDate value="${visit.visit_nexttime}" pattern="yyyy-MM-dd"/>" readonly="readonly">
								</td>
								
							</TR>
							
							<TR>	
								<td>拜访详情 ：</td>
								<td>
									<textarea rows="5" cols="26" name="visit_detail"></textarea>
								</td>
							</TR>
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
					</TD>
					<TD width=15 background="<%=basePath%>images/new_023.jpg">
					<IMG src="<%=basePath%>images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="<%=basePath%>images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="<%=basePath%>images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="<%=basePath%>images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
