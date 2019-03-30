<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/29
  Time: 23:17
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
        <input type="hidden" name="interviewId" value="${interview.interviewId}" autocomplete="off" class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">申请人：</label>
            <div class="layui-input-inline">
                <input type="text" name="applyName" required value="${interview.applyName}"  lay-verify="required" placeholder="请输入申请人姓名" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">申请职位：</label>
            <div class="layui-input-inline">
                <input type="text" name="applyPosition" required value="${interview.applyPosition}"  lay-verify="required" placeholder="请输入申请职位" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门名称：</label>
            <div class="layui-input-inline">
                <input type="text" name="departmentName" required lay-verify="required" value="${interview.departmentName}"  placeholder="请输入部门名称" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">面试官：</label>
            <div class="layui-input-inline">
                <input type="text" name="interviewer" required lay-verify="required" value="${interview.interviewer}"  placeholder="请输入面试官" autocomplete="off" class="layui-input">
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

            var applyName = data.field.applyName;
            var applyPosition = data.field.applyPosition;
            var interviewer = data.field.interviewer;
            var departmentName = data.field.departmentName;
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/InterviewServlet",
                    data:{
                        "action":"add",
                        "applyName":applyName,
                        "applyPosition":applyPosition,
                        "interviewer":interviewer,
                        "departmentName":departmentName
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:1000});
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        setTimeout("parent.layer.close(index)",1000)
                        setTimeout("window.parent.location.reload()",1000)
                    }
                })
            return false;
        })
    });
</script>
</body>
</html>
