<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1 0001
  Time: 上午 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>考勤详情信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <div class="layui-form-item ">
        <label class="layui-form-label">编号：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="attendanceId" value="${attendance.attendanceId}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工姓名：</label>
        <div class="layui-input-inline">
            <c:forEach items="${staffList}" var="list">
                <c:if test="${list.staffId == attendance.staffId}">
                    <input readonly type="text"  value="${list.staffName}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属部门：</label>
        <div class="layui-input-inline">
            <c:forEach items="${departmentList}" var="list">
                <c:if test="${list.departmentId == attendance.departmentId}">
                    <input readonly type="text"  value="${list.departmentName}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工作日：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="workDay" required lay-verify="required" value="${attendance.workDay}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">病假：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="sickLeave" required lay-verify="required" value="${attendance.sickLeave}"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">事假：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="affairLeave" required lay-verify="required" value="${attendance.affairLeave}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">加班：</label>
        <div class="layui-input-inline">
            <input readonly type="number" name="onduty" required lay-verify="required" value="${attendance.onduty}"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">旷工：</label>
        <div class="layui-input-inline">
            <input readonly type="number" name="abnormal" required lay-verify="required" value="${attendance.abnormal}"  placeholder="请输入旷工天数" autocomplete="off" class="layui-input">
        </div>
    </div>
</div>

