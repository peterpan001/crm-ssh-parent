<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取到项目的跟路径即WebContent
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
TD {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
.error{
	color:red;
}
</STYLE>

<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
<!-- 引入JQuery -->
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function checkPwd1(){
		var userPwd1 = $("#user_pwd1").val();
		if(userPwd1.trim()==""){
			$("#pwdId1").addClass("error");
			$("#pwdId1").html("密码不能为空");
		}else{
			$("#pwdId1").removeClass("error");
			$("#pwdId1").html("ok");
		}
	}
	function checkPwd_1(){
		$("#pwdId1").html("请输入旧密码");
	}
	function checkPwd2(){
		/* var userPwd2 = $("#user_pwd2").val().trim();
		if(userPwd2.length < 6){
			$("#pwdId2").addClass("error");
			$("#pwdId2").html("密码的长度不能低于6位");
		}else{
			$("#pwdId2").removeClass("error");
			$("#pwdId2").html("ok");
		} */
		var regp =/^(?=.*[a-zA-Z]+)(?=.*[0-9]+)[a-zA-Z0-9]+$/;  
		var userPwd2 = $("#user_pwd2").val().trim()
		if(!regp.test(userPwd2) || userPwd2.length<6 || userPwd2.length>20){  
			$("#pwdId2").addClass("error");
			$("#pwdId2").html("密码的长度必须为6-20位且包含数字和字母");
		}else{
			$("#pwdId2").removeClass("error");
			$("#pwdId2").html("ok");
		}
	}
	
	function checkPwd3(){
		var userPwd3 = $("#user_pwd3").val().trim();
		var userPwd2 = $("#user_pwd2").val().trim();
		if(userPwd2 != userPwd3){
			$("#pwdId3").addClass("error");
			$("#pwdId3").html("密码前后不一致");
		}else{
			$("#pwdId3").removeClass("error");
			$("#pwdId3").html("ok");
		}
	}
	
	function checkForm(){
		checkPwd1();
		checkPwd2();
		checkPwd3();
		if($(".error").size()>0){
			return false;
		}
	}
</script>
</HEAD>
<BODY>
<FORM id=form1 name=form1 action="<%=basePath%>user_resetPwd.action" method="post" onsubmit="return checkForm()">

<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px"><IMG src="<%=basePath%>images/login_1.gif" 
  border=0></TD></TR>
  <TR>
    <TD background=<%=basePath%>images/login_2.jpg height=300>
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=35></TD></TR>
        <TR>
          <TD width=360></TD>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD style="HEIGHT: 28px" width=80>旧密码：</TD>
                <TD style="HEIGHT: 28px" width=150>
                	<INPUT id="user_pwd1" style="WIDTH: 130px" type=password name="user_pwd1" onblur="checkPwd1()" onclick="checkPwd_1()">
                </TD>
                <TD style="HEIGHT: 28px" width=370>
                	<SPAN id="pwdId1" style="FONT-WEIGHT: bold;"></SPAN>
                </TD>
              </TR>
              <TR>
                <TD style="HEIGHT: 28px">新密码：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_pwd2" style="WIDTH: 130px" type=password name="user_pwd2"  onblur="checkPwd2()">
                </TD>
                <TD style="HEIGHT: 28px">
                	<SPAN id="pwdId2" style="FONT-WEIGHT: bold;"></SPAN>
                </TD>
              </TR>
              <TR>
                <TD style="HEIGHT: 28px">确认密码：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_pwd3" style="WIDTH: 130px" type=password name="user_pwd3" onblur="checkPwd3()">
                </TD>
                <TD style="HEIGHT: 28px">
					<SPAN id="pwdId3" style="FONT-WEIGHT: bold;"></SPAN>
				</TD></TR>
              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px">
                	<SPAN id="errorMsg" style="FONT-WEIGHT: bold; color:red;">
                		${errorMsg}
                	</SPAN>
                </TD>
                <TD style="HEIGHT: 18px"></TD></TR>
              <TR>
                <TD></TD>
                <TD>
                	<input type="submit" value="确认修改"/>
              	</TD>
             </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="<%=basePath%>images/login_3.jpg" 
border=0></TD></TR></TBODY></TABLE></DIV></DIV>


</FORM></BODY></HTML>


</body>
</html>