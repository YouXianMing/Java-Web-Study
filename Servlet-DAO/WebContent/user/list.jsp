<%@page import="com.models.*"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<link type="text/css" href="../css/reset.css" rel="stylesheet">
<link type="text/css" href="../css/layout.css" rel="stylesheet">
<link type="text/css" href="../css/common.css" rel="stylesheet">
</head>

<body>
	<div class="main-content">

		<h1>学生列表</h1>

		<table class="main-table">

			<tr class="main-table-title">
				<th>用户id</th>
				<th>用户姓名</th>
				<th>用户电话</th>
				<th>用户密码</th>
			</tr>

			<!-- 程序段 -->
			<%
				UserDaoImpl impl = new UserDaoImpl();
				List<User> list = impl.findAll();

				for (User u : list) {
					String str = String.format(
							"<tr class=\"main-table-content\"><td><a href=\"./edit.jsp?id=%d\">%d</a></td><td>%s</td><td>%d</td><td>%d</td></tr>",
							u.getId(), u.getId(), u.getName(), u.getTel(), u.getPasswd());
					out.append(str);
				}
			%>

		</table>

		<a href="insert.html">点击插入学生</a> <br /> <a href="../index.html">返回首页</a>

	</div>
</body>

</html>
