<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/15
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UserServlet">
  <input type="hidden" name="method" value="add">
    <table>
        <tr>
            <td>id</td>
            <td><input type="text" name="id" ></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input type="text" name="name"  ></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password"  ></td>
        </tr>
        <tr>
            <td colspan="2">
            <input type="submit" value="add">
            <input type="submit" value="reset"></td>
        </tr>
    </table>
</form>



</body>
</html>
