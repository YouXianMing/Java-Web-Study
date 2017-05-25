<%@page import="com.dao.*"%>
<%@page import="com.models.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改学生</title>
<link type="text/css" href="../css/reset.css" rel="stylesheet">
<link type="text/css" href="../css/layout.css" rel="stylesheet">
<link type="text/css" href="../css/common.css" rel="stylesheet">
</head>

<body>
	<div class="main-content">

		<h1 style="text-align: left; line-height: 40px;">修改学生</h1>

		<form action="editUser.do" method="post">
			<div class="insertUser-form">

				<%
					User user = (User) request.getAttribute("user");

					out.append(String.format(
							"<div><span>id</span><input type=\"text\" name=\"id\" value=\"%d\" readonly=\"true\"></div>",
							user.getId()));
					out.append(String.format("<div><span>用户名</span><input type=\"text\" name=\"name\" value=\"%s\"></div>",
							user.getName()));
					out.append(String.format("<div><span>电话</span><input type=\"text\" name=\"tel\" value=\"%d\"></div>",
							user.getTel()));
					out.append(String.format("<div><span>密码</span><input type=\"text\" name=\"passwd\" value=\"%d\"></div>",
							user.getPasswd()));
				%>

				<!-- 				<div>
					<span>id</span><input type="text" name="id" value="10"
						readonly="true">
				</div>
				<div>
					<span>用户名</span><input type="text" name="name">
				</div>
				<div>
					<span>电话</span><input type="text" name="tel">
				</div>
				<div>
					<span>密码</span><input type="text" name="passwd">
				</div> -->
				<input type="submit" value="更新数据">
			</div>
		</form>

		<a href="list.jsp">返回上一页</a>

	</div>
</body>

</html>