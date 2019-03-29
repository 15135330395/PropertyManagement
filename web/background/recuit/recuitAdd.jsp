<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29 0029
  Time: 下午 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <input type="hidden" name="recuitId" value="${recuit.recuitId}" autocomplete="off" class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">招聘岗位：</label>
            <div class="layui-input-inline">
                <input type="text" name="recuitPosition" required value="${recuit.recuitPosition}"  lay-verify="required" placeholder="请输入岗位名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">招聘人数：</label>
            <div class="layui-input-inline">
                <input type="number" name="recuitCount" required value="${recuit.recuitCount}"  lay-verify="required" placeholder="请输入人数" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">基本工资：</label>
            <div class="layui-input-inline">
                <input type="text" name="basicSalary" value="${recuit.basicSalary}"  lay-verify="required" placeholder="请选择基本工资"class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">岗位职责：</label>
            <div class="layui-input-block">
                <textarea   name="duty"  cols="20" rows="2" class="layui-textarea">${recuit.duty}</textarea>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">任职要求：</label>
            <div class="layui-input-block">
                <textarea   name="demand"  cols="20" rows="2" class="layui-textarea">${recuit.demand}</textarea>
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
            var recuitId = data.field.recuitId;
            var recuitPosition = data.field.recuitPosition;
            var recuitCount = data.field.recuitCount;
            var basicSalary = data.field.basicSalary;
            var duty =  data.field.duty;
            var demand =  data.field.demand;

            if(recuitId!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/RecuitServlet",
                    data:{
                        "action":"update",
                        "recuitId":recuitId,
                        "recuitPosition":recuitPosition,
                        "recuitCount":recuitCount,
                        "basicSalary":basicSalary,
                        "duty":duty,
                        "demand":demand
                    },
                    success:function(msgData){
                        layer.msg("修改成功",{icon:1,time:1000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        setTimeout("parent.layer.close(index)",1000)
                        setTimeout("window.parent.location.reload()",1000)
                    }
                })
            }else {
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/RecuitServlet",
                    data:{
                        "action":"add",
                        "recuitPosition":recuitPosition,
                        "recuitCount":recuitCount,
                        "basicSalary":basicSalary,
                        "duty":duty,
                        "demand":demand
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:1000});
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        setTimeout("parent.layer.close(index)",1000)
                        setTimeout("window.parent.location.reload()",1000)
                    }

                })
            }

            return false;
        });
    });
</script>
</body>
</html>
