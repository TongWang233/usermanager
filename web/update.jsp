<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.neusoft.pojo.User" %>
<%@ page import="java.util.*" %>
<%@ page import="java.awt.*" %>
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <%
        User user = (User) request.getAttribute("user");
        String msg = (String) session.getAttribute("msg");
        if (msg != "" && msg != null) {
            out.print("alert('" + msg + "');");
            session.setAttribute("msg", "");
        }
    %>
    <body>
    <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
            <div class="form-group">
                <input type="hidden" class="form-control" name="id" value="<%=user.getId()%>">
            </div>

            <div class="form-group">
                <label>姓名：</label>
                <input type="text" class="form-control" readonly="readonly" name="name" value="<%=user.getUsername()%>">
            </div>

            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="sex" value="男" checked="checked"/>男
                <input type="radio" name="sex" value="女"/>女
            </div>

            <div class="form-group">
                <label>年龄：</label>
                    <input type="text" class="form-control"  name="age" value="<%=user.getAge()%>" >
                </div>

                <div class="form-group">
                    <label >籍贯：</label>
                    <select name="address" class="form-control" id="jiguan">
                        <option value="广东">广东</option>
                        <option value="广西">广西</option>
                        <option value="湖南">湖南</option>
                    </select>
                </div>

                <div class="form-group">
                    <label >QQ：</label>
                    <input type="text" class="form-control" name="qq" value="<%=user.getQq()%>" />
                </div>

                <div class="form-group">
                    <label >Email：</label>
                    <input type="text" class="form-control" name="email" value="<%=user.getEmail()%>"/>
                </div>

                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交" />
                    <input class="btn btn-default" type="reset" value="重置" />
                    <input class="btn btn-default" type="button" value="返回" />
                </div>
                <!-- 出错显示的信息框 -->
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" >
                        <span>&times;</span></button>
                    <strong>${msg}</strong>
                </div>
            </form>
        </div>
    </body>
</html>