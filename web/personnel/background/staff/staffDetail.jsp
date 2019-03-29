<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29 0029
  Time: 上午 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>员工基本信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <div class="layui-form-item">
        <label class="layui-form-label">工号：</label>
        <div class="layui-input-inline">
            <input  readonly type="text" name="staffId" value="${staff.staffId}" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">所属部门：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="departmentName" value="${staff.departmentName}" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">职位：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="station" required lay-verify="required" value="${staff.station}"  placeholder="请输入职位" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工姓名：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="staffName" required value="${staff.staffName}"  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">年龄：</label>
        <div class="layui-input-inline">
            <input readonly type="number" name="age" required value="${staff.age}"  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-upload " >
            <label class="layui-form-label">照片：</label>
            <div class="layui-input-inline">
                <img class="layui-upload-img" id="demo1" style="width: 87px;height: 130px;" src="/${staff.staffImage}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入职时间：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="joinTime" value="<fmt:formatDate value="${staff.joinTime}" pattern="yyyy-MM-dd " />"  lay-verify="required" placeholder="请选择入职时间"class="layui-input" id="test4">
        </div>
        <label class="layui-form-label">家庭住址：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="address" required lay-verify="required" value="${staff.address}"  placeholder="请输入家庭住址" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">性别：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="sex" required lay-verify="required" value="${staff.sex}"   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="email" required lay-verify="email" value="${staff.email}"  placeholder="请输入邮箱" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">所在城市：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="city" required lay-verify="required" value="${staff.city}"  placeholder="请输入所在城市" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">籍贯：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="household" required lay-verify="required" value="${staff.household}"  placeholder="请输入籍贯" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="identityCard" required lay-verify="identity" value="${staff.identityCard}"  placeholder="请输入身份证" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">学历：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="education" required lay-verify="required" value="${staff.education}"  placeholder="请输入学历" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">电话号码：</label>
        <div class="layui-input-inline">
            <input readonly type="tel" name="phone" required lay-verify="phone" value="${staff.phone}"  placeholder="请输入电话号码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">

        <label class="layui-form-label">社保号：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="securityInsuranceId" value="${staff.securityInsuranceId}"  lay-verify="required" class="layui-input" placeholder="请输入社保号" >
        </div>
        <label class="layui-form-label">工资号：</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="salaryId" value="${staff.salaryId}"  lay-verify="required" class="layui-input" placeholder="请输入工资号">
        </div>
    </div>
</div>
</body>
</html>
