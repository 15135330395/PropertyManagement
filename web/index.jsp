<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/4/2
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //request.getRequestDispatcher("/shouFei/items/payItems.jsp").forward(request,response);
    //request.getRequestDispatcher("/shouFei/norm/payNorm.jsp").forward(request,response);
    //request.getRequestDispatcher("/shouFei/mReading/mReadingList.jsp").forward(request,response);
    //request.getRequestDispatcher("/shouFei/rule/ruleList.jsp").forward(request,response);
    //request.getRequestDispatcher("/Backstage_login.jsp").forward(request,response);
   //request.getRequestDispatcher("/shouFei/receipt/receiptList.jsp").forward(request,response);
    //request.getRequestDispatcher("/shouFei/pay/payList.jsp").forward(request,response);


%>
<iframe src="http://localhost:8080/ReportServer?reportlet=pay.cpt" width="800px" scrolling="no" style="overflow: hidden" height="500px"> </iframe>
<iframe src="http://localhost:8080/ReportServer?reportlet=receipt.cpt" width="800px" scrolling="no" style="overflow: hidden" height="500px"> </iframe>

</body>
</html>
