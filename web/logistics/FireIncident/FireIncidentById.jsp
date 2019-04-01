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
<%@ include file="../info.jsp" %>
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
                <span class="x-red"></span>出动时间
            </label>
            <div class="layui-input-block">

                <input type="text" class="layui-input" readonly="readonly"
                       value="<fmt:formatDate value="${incident.alarmTime}" pattern="yyyy-MM-dd HH:mm:ss" />">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>区域
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly" value="${incident.incidentLocale}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>人员
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly" value="${incident.staffNames}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>起因
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly" value="${incident.cause}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>损失
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly="readonly" value="${incident.loss}">
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

