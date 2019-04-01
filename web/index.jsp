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
  // request.getRequestDispatcher("/shouFei/items/payItems.jsp").forward(request,response);
  //request.getRequestDispatcher("/shouFei/norm/payNorm.jsp").forward(request,response);
  request.getRequestDispatcher("/shouFei/mReading/mReadingList.jsp").forward(request,response);
    //request.getRequestDispatcher("/shouFei/pay/payList.jsp").forward(request,response);
   //request.getRequestDispatcher("/shouFei/receipt/receiptList.jsp").forward(request,response);
%>
 <%--<ifram src="http://localhost:8080/ReportServer?WorkBook1.cpt" width="1000px" height="1000px"></ifram>--%>
  <%--把帆软？后面的复制过来--%>
  </body>
</html>
