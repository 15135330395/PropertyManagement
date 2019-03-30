<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/30
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>详情信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <div class="layui-form-item">
        <label class="layui-form-label">劳动者：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="labourContractId" value="${labourContract.labourContractId}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">甲方：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="companyName" required value="${labourContract.companyName}"  lay-verify="required"  autocomplete="off" class="layui-input">
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">劳动者：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="staffName" required value="${labourContract.staffName}"  lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">合同时间：</label>
        <div class="layui-input-block">
            <input readonly type="text" class="layui-input" name="jobTime" value="${labourContract.jobTime}"lay-verify="required" id="test2">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">签订时间：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="signTime" value="<fmt:formatDate value="${labourContract.signTime}" pattern="yyyy-MM-dd " />"  lay-verify="required" class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">基本工资：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="basicSalary" required lay-verify="required" value="${labourContract.basicSalary}"   autocomplete="off" class="layui-input">
        </div>
    </div>
</div>
