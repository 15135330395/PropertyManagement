<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/30
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/info.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>绩效评分</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <div>评分必须在0到10之间（0表示删除评分）</div>
            <label for="kpiId" class="layui-form-label">
            </label>
            <div class="layui-input-inline">
                <input type="hidden" value="${kpi.kpiId}" id="kpiId" name="kpiId" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="evaluateGrade" class="layui-form-label">
                绩效评分
            </label>
            <div class="layui-input-inline">
                <input type="number" id="evaluateGrade" name="evaluateGrade" required="" lay-verify="evaluateGrade"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="add" lay-submit="">
                添加
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;
        //自定义验证规则
        form.verify({
            evaluateGrade: function (value) {
                if (value < 0 || value > 10) {
                    return '评分必须在0到10之间';
                }
            }
        });
        //监听提交
        form.on('submit(add)', function (data) {
            //发异步，把数据提交给Servlet
            $.ajax({
                type: "post",
                url: "<%=request.getContextPath()%>/KpiServlet",
                data: {
                    action: "addEvaluateGrade",
                    kpiId: data.field.kpiId,
                    evaluateGrade: data.field.evaluateGrade
                },
                success: function (msg) {
                    if (msg == 1) {
                        layer.alert("添加成功", {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            // 关闭当前frame
                            parent.layer.close(index);
                            // 刷新父frame
                            window.parent.location.reload();
                        });
                    } else {
                        layer.msg("添加失败")
                    }
                },
                error: function () {
                    layer.msg("添加异常")
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
