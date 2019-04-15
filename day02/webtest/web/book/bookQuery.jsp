<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/10
  Time: 19:59
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
            <td>xulie</td>
            <td>name</td>
            <td>price</td>
            <td>publish</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.bId}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.publishDate}</td>
            <td><a href="/BookServlet?action=delete&bId=${book.bId}"></a> </td>
        </tr>
        </c:forEach>

    </table>










</body>
</html>
