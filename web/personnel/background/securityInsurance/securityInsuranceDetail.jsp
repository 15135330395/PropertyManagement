<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1 0001
  Time: 上午 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>社保详情信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <div class="layui-form-item ">
        <label class="layui-form-label">编号：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="securityInsuranceId" value="${securityInsurance.securityInsuranceId}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工姓名：</label>
        <div class="layui-input-inline">
            <c:forEach items="${staffList}" var="list">
                <c:if test="${list.staffId == securityInsurance.staffId}">
                    <input readonly type="text"  value="${list.staffName}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <label class="layui-form-label">养老保险：</label>
            <input readonly type="checkbox" name="endowmentInsurance" title="养老保险" <c:if test="${securityInsurance.endowmentInsurance==1}">checked</c:if>>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <label class="layui-form-label">医疗保险：</label>
            <input readonly type="checkbox" name="medicalInsurance" title="医疗保险" <c:if test="${securityInsurance.medicalInsurance==1}">checked</c:if>>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <label class="layui-form-label">失业保险：</label>
            <input readonly type="checkbox" name="unemploymentInsurance" title="失业保险" <c:if test="${securityInsurance.unemploymentInsurance==1}">checked</c:if>>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <label class="layui-form-label">工伤保险：</label>
            <input readonly type="checkbox" name="employmentInjuryInsurance" title="工伤保险" <c:if test="${securityInsurance.employmentInjuryInsurance==1}">checked</c:if>>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <label class="layui-form-label">生育保险：</label>
            <input readonly type="checkbox" name="maternityInsurance" title="生育保险" <c:if test="${securityInsurance.maternityInsurance==1}">checked</c:if>>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <label class="layui-form-label">公积金：</label>
            <c:if test="${securityInsurance.publicHousingFunds==1}">
                <input  type="checkbox" name="publicHousingFunds" title="住房公积金" checked >
            </c:if>
            <c:if test="${securityInsurance.publicHousingFunds!=1}">
                <input  type="checkbox" name="publicHousingFunds" title="住房公积金" >
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
