<%--
  Created by IntelliJ IDEA.
  User: 15087
  Date: 2019/3/20
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- css和js的引用封装在info.jsp -->
<%@ include file="../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>修改消防事故</title>
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
                <span class="x-red">*</span>事故编号
            </label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" class="layui-input" value="${incident.incidentId}"
                       name="incidentId">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>出动时间
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" lay-verify="required" name="alarmTime" id="test1"
                       placeholder="yyyy-MM-dd HH:mm:ss"
                       value="<fmt:formatDate value="${incident.alarmTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="incidentLocale" class="layui-form-label">
                <span class="x-red">*</span>区域
            </label>
            <div class="layui-input-inline">
                <input type="text" id="incidentLocale" name="incidentLocale" value="${incident.incidentLocale}"
                       required=""
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="staffNames" class="layui-form-label">
                <span class="x-red">*</span>人员
            </label>
            <div class="layui-input-inline">
                <input type="text" id="staffNames" name="staffNames" value="${incident.staffNames}" required=""
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="cause" class="layui-form-label">
                <span class="x-red">*</span>起因
            </label>
            <div class="layui-input-inline">
                <input type="text" id="cause" name="cause" value="${incident.cause}" required=""
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="loss" class="layui-form-label">
                <span class="x-red">*</span>损失
            </label>
            <div class="layui-input-inline">
                <input type="text" id="loss" name="loss" value="${incident.loss}" required=""
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="update" lay-submit="">
                保存
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer', 'laydate'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate;
        //监听提交
        form.on('submit(update)', function (data) {
            //发异步，把数据提交给Servlet
            $.ajax({
                type: "post",
                url: "<%=request.getContextPath()%>/FireIncidentServlet",
                data: {
                    action: "updateIncident",
                    incidentId: data.field.incidentId,
                    alarmTime: data.field.alarmTime,
                    incidentLocale: data.field.incidentLocale,
                    staffNames: data.field.staffNames,
                    cause: data.field.cause,
                    loss: data.field.loss
                },
                success: function (msg) {
                    if (msg == 1) {
                        layer.alert("修改成功", {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            // 关闭当前frame
                            parent.layer.close(index);
                            // 刷新父frame
                            window.parent.location.reload();
                        });
                    } else {
                        layer.msg("修改失败")
                    }
                },
                error: function () {
                    layer.msg("修改异常")
                }
            });
            return false;
        });

        laydate.render({
            elem: '#test1', //指定元素
            type: 'datetime'
            , min: -7
            , max: 0
        });
    });
</script>
</body>
</html>

