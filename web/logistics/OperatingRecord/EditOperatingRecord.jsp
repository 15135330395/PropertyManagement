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
    <title>修改安保器材使用记录</title>
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
                <span class="x-red">*</span>记录编号
            </label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" class="layui-input" value="${record.recordId}"
                       name="recordId">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="staffName" class="layui-form-label">
                <span class="x-red">*</span>借用人员
            </label>
            <div class="layui-input-inline">
                <input type="text" id="staffName" name="staffName" value="${record.staffName}" required=""
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="equipmentName" class="layui-form-label">
                <span class="x-red">*</span>器材名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="equipmentName" name="equipmentName" value="${record.equipmentName}" required=""
                       lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>借出时间
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" lay-verify="required" name="borrowingTime" id="test1"
                       placeholder="yyyy-MM-dd HH:mm:ss"
                       value="<fmt:formatDate value="${record.borrowingTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />">
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
                url: "<%=request.getContextPath()%>/OperatingRecordServlet",
                data: {
                    action: "updateRecord",
                    recordId: data.field.recordId,
                    staffName: data.field.staffName,
                    equipmentName: data.field.equipmentName,
                    borrowingTime: data.field.borrowingTime
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
            , min: -3
            , max: 0
        });
    });
</script>
</body>
</html>

