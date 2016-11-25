<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<!-- String bill = request.getParameter("bill");
		String senderPhone = request.getParameter("senderPhone");
		String recieveName = request.getParameter("recieveName");
		String recievePhone = request.getParameter("recievePhone");
		String senderName = request.getParameter("senderName");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		String birthday = request.getParameter("birthday");
		String addr = request.getParameter("addr");
		String idcard = request.getParameter("idcard"); -->
	
		<form action="<%=basePath %>save" method="post" enctype="multipart/form-data" >
			<input type="file" name="img1">
			<input type="file" name="img2">
			<input type="file" name="img3">
			运单号<input type="text" name="bill">
			寄件人电话<input type="text" name="senderPhone">
			收件人姓名<input type="text" name="recieveName">
			收件人电话<input type="text" name="recievePhone">
			发送人姓名<input type="text" name="senderName">
			性别<input type="text" name="sex">
			国家<input type="text" name="nation">
			生日<input type="text" name="birthday">
			地址<input type="text" name="addr">
			身份证号码<input type="text" name="idcard">
			
			<button type="submit">提交</button>
		</form>
</body>
</html>