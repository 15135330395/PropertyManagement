<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1 0001
  Time: 下午 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/info.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="layui-table">
    <thead>
    <tr>
        <th>工号</th>
        <th>员工姓名</th>
        <th>职位</th>
        <th>入职时间</th>
        <th>部门名称</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${staffList}" var="list">
        <tr>
            <td>${list.staffId}</td>
            <td>${list.staffName}</td>
            <td>${list.station}</td>
            <td>${list.joinTime}</td>
            <td>${list.departmentName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>