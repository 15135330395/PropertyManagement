<%--
  Created by IntelliJ IDEA.
  User: 15087
  Date: 2019/3/20
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- css和js的引用封装在info.jsp -->
<%@ include file="../../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>添加任务</title>
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
                <span class="x-red">*</span>任务编号
            </label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" class="layui-input" value="${task.taskId}" name="taskId">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>任务类型
            </label>
            <div class="layui-input-inline">
                <select name="taskType" lay-verify="required" lay-search="">
                    <option value=""></option>
                    <option value="日常保洁" <c:if test="${task.taskType=='日常保洁'}">selected=""</c:if>>日常保洁</option>
                    <option value="日常绿化" <c:if test="${task.taskType=='日常绿化'}">selected=""</c:if>>日常绿化</option>
                    <option value="定期保洁" <c:if test="${task.taskType=='定期保洁'}">selected=""</c:if>>定期保洁</option>
                    <option value="定期绿化" <c:if test="${task.taskType=='定期绿化'}">selected=""</c:if>>定期绿化</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>任务时间
            </label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" value="${task.taskTime}" name="taskTime" id="test1"
                       placeholder="yyyy-MM-dd HH:mm">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="taskArea" class="layui-form-label">
                <span class="x-red">*</span>区域
            </label>
            <div class="layui-input-inline">
                <input type="text" id="taskArea" name="taskArea" value="${task.taskArea}" required=""
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="staffName" class="layui-form-label">
                <span class="x-red">*</span>员工姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="staffName" name="staffName" value="${task.staffName}" required=""
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
                url: "<%=request.getContextPath()%>/CleaningTaskServlet",
                data: {
                    action: "updateTask",
                    taskId: data.field.taskId,
                    taskType: data.field.taskType,
                    taskTime: data.field.taskTime,
                    taskArea: data.field.taskArea,
                    staffName: data.field.staffName
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
            , min: 0
            , max: 30
            , range: true
        });
    });
</script>
</body>
</html>

