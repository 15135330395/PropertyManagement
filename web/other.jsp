<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-01
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
String user=(String)session.getAttribute("username");
if (user==null){
    request.setAttribute("msg","你还没有登录");
    request.getRequestDispatcher("login.jsp").forward(request,response);
}
%>
欢迎<%=session.getAttribute("username")%>other.jsp登录成功！
</body>
</html>
