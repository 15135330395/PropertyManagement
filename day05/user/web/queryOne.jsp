<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/15
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>序号</td>
        <td>名称</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>
            <a href="/update.jsp">修改</a>
           <%-- <a href="UserServlet?method=update&id=${user.id}">修改</a>--%>
        <a href="UserServlet?method=delete&id=${user.id}">删除</a></td>
    </tr>
</table>



</body>
</html>
