<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/equbackground/ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="mid" required  lay-verify="required" value="${equmalfunction.mid}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设备名称</label>
            <div class="layui-input-block">
                <input type="text" name="ename" autocomplete="off" value="${equmalfunction.ename}"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设备编号：</label>
            <div class="layui-input-block">
                <input type="text" name="eno" required  lay-verify="required" value="${equmalfunction.eno}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">发生故障日期：</label>
            <div class="layui-input-inline">
                <input name="mdate" required lay-verify="required" id="test1" autocomplete="off" class="layui-input"
                  <fmt:formatDate value="${equmalfunction.mdate}" pattern="yyyy-MM-dd HH:mm:ss"/> >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">处理人：</label>
            <div class="layui-input-inline">
                <input type="text" name="handler" required lay-verify="required" value="${equmalfunction.handler}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">安装详情：</label>
            <div class="layui-input-inline">
                <input type="text" name="installdetail" lay-verify="required" value="${equmalfunction.installdetail}" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">运行情况：</label>
            <div class="layui-input-inline">
                <input type="text" name="operation" lay-verify="required" class="layui-input" value="${equmalfunction.operation}" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">保养情况：</label>
            <div class="layui-input-inline">
                <input type="text" name="maintenance" required lay-verify="required" autocomplete="off" class="layui-input" value="${equmalfunction.maintenance}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">报废：</label>
            <div class="layui-input-inline">
                <input type="text" name="rejection" lay-verify="required" class="layui-input" value="${equmalfunction.rejection}">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="submitSave">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    //Demo
    layui.use(['laydate','form'], function(){
        var form = layui.form;
        var laydate = layui.laydate;
        //监听提交
        form.on('submit(submitSave)', function(data){
            layer.msg(JSON.stringify(data.field));
            var mid = data.field.mid;
            var ename = data.field.ename;
            var eno = data.field.eno;
            var mdate = data.field.mdate;
            var handler = data.field.handler;
            var installdetail = data.field.installdetail;
            var operation = data.field.operation;
            var maintenance = data.field.maintenance;
            var rejection = data.field.rejection;

            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/EqumalfunctionServlet",
                data:{
                    "action": "update",
                    "mid": mid,
                    "ename": ename,
                    "eno": eno,
                    "mdate": mdate,
                    "handler": handler,
                    "installdetail": installdetail,
                    "operation": operation,
                    "maintenance": maintenance,
                    "rejection": rejection
                },
                success:function(msgdata){
                    layer.msg("修改成功",{icon:1,time:2000});
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                    window.parent.location.reload();
                }
            })
            return false;
        });
        laydate.render({
            elem: '#test1', //指定元素
            type:'datetime'
        });
    });
</script>
</body>
</html>

