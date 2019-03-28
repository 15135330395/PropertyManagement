<%--
  Created by IntelliJ IDEA.
  User: 15087
  Date: 2019/3/20
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- css和js的引用封装在info.jsp -->
<%@ include file="../../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>查询事故</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
</head>
<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>排班时段
            </label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" readonly="readonly" value="${rota.rotaTime}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>员工编号
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly" value="${rota.staffId}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>员工姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly" value="${rota.staffName}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>上班打卡
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly"
                       value="<c:if test="${rota.clockIn==null}">尚未打卡</c:if> <c:if test="${rota.clockIn!=null}"><fmt:formatDate value="${rota.clockIn}" pattern="yyyy-MM-dd HH:mm:ss" /></c:if>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>下班打卡
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly"
                       value="<c:if test="${rota.clockOut==null}">尚未打卡</c:if> <c:if test="${rota.clockOut!=null}"><fmt:formatDate value="${rota.clockOut}" pattern="yyyy-MM-dd HH:mm:ss" /></c:if>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="close" lay-submit="">
                关闭
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer', 'laydate'], function () {
        $ = layui.jquery;
        var form = layui.form;
        form.on('submit(close)', function (data) {
            // 获得frame索引
            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);
        });
    });
</script>
</body>
</html>

