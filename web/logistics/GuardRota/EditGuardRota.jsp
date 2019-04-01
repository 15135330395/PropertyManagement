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
<%@ include file="../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>修改排班</title>
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
                <span class="x-red">*</span>排班编号
            </label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" readonly="readonly" name="rotaId" lay-verify="required"
                       value="${rota.rotaId}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>排班时段
            </label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" name="rotaTime" lay-verify="required" id="test1"
                       value="${rota.rotaTime}"
                       placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="staffId" class="layui-form-label">
                <span class="x-red">*</span>员工姓名
            </label>
            <div class="layui-input-inline">
                <select id="staffId" name="staffId" lay-verify="required" lay-search="">
                    <option value=""></option>
                    <c:forEach items="${guardList}" var="guard">
                        <option value="${guard.staffId}"
                                <c:if test="${guard.staffId==rota.staffId}">selected=""</c:if> >${guard.staffName}</option>
                    </c:forEach>
                </select>
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
                url: "<%=request.getContextPath()%>/GuardRotaServlet",
                data: {
                    action: "updateRota",
                    rotaId: data.field.rotaId,
                    rotaTime: data.field.rotaTime,
                    staffId: data.field.staffId,
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

