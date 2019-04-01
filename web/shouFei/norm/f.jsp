<%--
  Created by IntelliJ IDEA.
  User: qiqi
  Date: 2019/3/31
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>try</title>
</head>
<body>
<table border="1px" cellspacing="0">
    <tr>
        <td>normId</td>
        <td>payId</td>
        <td>标准名称</td>
        <td>金额计算方式</td>
        <td>单价</td>
        <td>计量方式</td>
        <td>固定金额</td>
        <td>自定义公式</td>
        <td>收费周期</td>
    </tr>
    <c:forEach var="b" items="${byPayId}">
        <tr>
            <td> ${b.normId}</td>
            <td> ${b.payId}</td>
            <td> ${b.normName}</td>
            <td> ${b.computeMode}</td>
            <td> ${b.price}</td>
            <td> ${b.fillingType}</td>
            <td> ${b.closeEnd}</td>
            <td> ${b.customFormula}</td>
            <td> ${b.chargeCycle}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
