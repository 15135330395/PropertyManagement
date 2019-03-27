<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26 0026
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%
  request.getRequestDispatcher("/shouFei/payItems.jsp").forward(request,response);
    //request.getRequestDispatcher("/shouFei/payItemsAdd.jsp").forward(request,response);
%>
  </body>
</html>
