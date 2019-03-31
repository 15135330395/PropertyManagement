<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/31
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>薪资详情信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <div class="layui-form-item">
        <label class="layui-form-label">薪资编号：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="salaryId" value="${salary.salaryId}" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">工号：</label>
        <div class="layui-input-inline">
            <input  readonly type="text" name="staffId" value="${salary.staffId}" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">员工姓名：</label>
        <div class="layui-input-inline">
            <c:forEach items="${staffList}" var="list">
                <c:if test="${list.staffId == salary.staffId}">
                    <input readonly type="text"  value="${list.staffName}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="layui-form-item">

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">基本工资：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="basicSalary" required value="${salary.basicSalary}"  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">绩效奖金：</label>
        <div class="layui-input-inline">
            <input readonly type="number" name="bonuses" required value="${salary.bonuses}"  lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">五险一金：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="insurance" value="${salary.insurance}"   lay-verify="required" class="layui-input" id="test4">
        </div>
    </div>
    <div class="layui-form-item">

        <label class="layui-form-label">请假：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="leavePay"  value="${salary.leavePay}"   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">旷工费：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="abnormalPay" required lay-verify="required" value="${salary.abnormalPay}"   autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">加班费：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="ondutyPay" required lay-verify="required" value="${salary.ondutyPay}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">考勤：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="actualAttendance" required lay-verify="required" value="${salary.actualAttendance}"  placeholder="请输入所在城市" autocomplete="off" class="layui-input">
        </div>
    </div>
</div>
</body>
</html>
