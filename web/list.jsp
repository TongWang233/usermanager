<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.neusoft.pojo.User" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    <%
                String msg = (String) session.getAttribute("msg");
                if (msg!=""&&msg!=null) {
                    out.print("alert('"+msg+"');");
                    session.setAttribute("msg","");
                }

    %>

    function delUser(id) {
        if (confirm("您确定删除本条记录吗?")) {
            location.href = "${pageContext.request.contextPath}/deleteUserServlet?id=" + id;
        }
    }

    window.onload = function () {
        document.getElementById("delSelected").onclick = function () {
            if (confirm("您确定删除本条记录吗?")) {
                var flag = false;
                var cbs = document.getElementsByName("uid");
                for (var i = 0; i < cbs.length; i++) {
                    if (cbs[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    document.getElementById("myform").submit();
                }
            }
        }


        document.getElementById("firstCb").onclick = function () {
            var cbs = document.getElementsByName("uid");
            for (var i = 0; i < cbs.length; i++) {
                cbs[i].checked = this.checked;
            }
        }
    }
</script>

<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <form action="${pageContext.request.contextPath}/delSelectedServlet" method="post" id="myform">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>id</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="s">
                <tr class="success">
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <th>${s.count}</th>
                    <th>${user.id}</th>
                    <th>${user.username}</th>
                    <th>${user.gender}</th>
                    <th>${user.age}</th>
                    <th>${user.address}</th>
                    <th>${user.qq}</th>
                    <th>${user.email}</th>
                    <td>
                        <a class="btn btn-default btn-sm" href="findUserByIdServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default b（）tn-sm" href="javascript:delUser(${user.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="10" align="center">
                    <a class="btn btn-primary" href="add.jsp">添加联系人</a>
                    <a class="btn btn-primary" id="delSelected" href="javascript:void(0);">删除选中</a>
                </td>

            </tr>
        </table>
    </form>
</div>
</body>
</html>
