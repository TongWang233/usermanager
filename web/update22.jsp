<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.neusoft.pojo.User" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联系人信息修改</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

</head>
<%
 User user = (User) request.getAttribute("user");
%>
<body>
	<form id="postForm" action="updateUserServlet"
		enctype="multipart/form-data" method="post">
		<div class="wrap">
			</div>
			<div class="login logns produce">
				<dl>
					<dd>
						<label>名称：</label> <input type="text"
						  name="id"
						value="<%=user.getId()%>" />
					</dd>
					<dd>
						<label>名称：</label> <input type="text"
							name="name"
							value="<%=user.getUsername()%>" />
					</dd>
					<dd>
						<label>性别：</label> <input type="text"
							name="gender"
							value="<%=user.getGender()%>" />
					</dd>
					<dd>
						<label>年龄：</label> <input type="text" name="age"
							value="<%=user.getAge()%>" />
					</dd>
					<dd>
						<label>籍贯：</label> <input type="text" name="address"
							 value="<%=user.getAddress()%>" />
					</dd>
					<dd>
						<label>QQ：</label> <input type="text" name="qq"
						 value="<%=user.getQq()%>" />
					</dd>
					<dd>
						<label>邮箱：</label> <input type="text" name="email"
												  value="<%=user.getQq()%>" />
					</dd>
					<dd class="hegas">
						<input class="btn btn-primary" type="submit" value="提交" />
						<a href="list.jsp"><input class="btn btn-default" type="button" value="返回"/></a>

					</dd>
				</dl>
			</div>
			<!-- main end-->
			<!-- footer begin-->
		</div>
		<!--footer end-->
	</form>
</body>
</html>
