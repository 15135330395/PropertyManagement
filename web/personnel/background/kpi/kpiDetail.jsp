<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1 0001
  Time: 上午 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>绩效详情信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">

    <div class="layui-form-item ">
        <label class="layui-form-label">编号：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="kpiId" value="${kpi.kpiId}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工姓名：</label>
        <div class="layui-input-inline">
            <c:forEach items="${staffList}" var="list">
                <c:if test="${list.staffId == kpi.staffId}">
                    <input readonly type="text"  value="${list.staffName}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">评价人：</label>
        <div class="layui-input-inline">
            <input readonly type="text"   name="evaluatePerson"  value="${kpi.evaluatePerson}"  lay-verify="required" placeholder="请输入评价人"class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">评价内容：</label>
        <div class="layui-input-block">
            <textarea  readonly name="evaluateContent"  cols="20" rows="2" class="layui-textarea">${kpi.evaluateContent}</textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">评分：</label>
        <div class="layui-input-inline">
            <input readonly type="text"   name="evaluateGrade"  value="${kpi.evaluateGrade}"  lay-verify="required"class="layui-input">
        </div>
    </div>

</div>
