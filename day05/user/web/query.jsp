<%@ page import="com.hibernate.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <%
      List<User> list=(List<User>) request.getAttribute("userList");
     if(list!=null){
         for(User user:list){
        %>
   <tr>
    <td><%=user.getId()%></td>
    <td><%=user.getName()%></td>
    <td><%=user.getPassword()%></td>
    <td>查看</td>
   </tr>
         <%
         }
     }
    %>



  //动态
    <c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td><a href="UserServlet?method=queryOne&id=${user.id}">查看</a>
             <a href="/add.jsp">添加</a></td>
    </tr>
    </c:forEach>

    <tr>
        <td colspan="4">
            <c:forEach var="i" begin="1" end="${pages}" step="1">
                <a href="/UserServlet?method=queryPage&pageIndex=${i}">[${i}]</a>
            </c:forEach>
        </td>
    </tr>
</table>
<div>

    <c:forEach var="i" begin="1" end="${pages}">
        <a href="/UserServlet?method=queryPage&pageIndex=${i}">
            ${i}
        </a>


    </c:forEach>
</div>





</body>
</html>
