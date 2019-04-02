<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29
  Time: 15:21
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
            <div class="layui-input-inline">
                <input type="hidden" name="reportId" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">签报标题：</label>
            <div class="layui-input-inline">
                <input type="text" name="reportTitle" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">签报日期：</label>
            <div class="layui-input-inline">
                <input  name="reportDate" lay-verify="required" class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">呈报单位：</label>
            <div class="layui-input-inline">
                <input type="text" name="reportingUnit" lay-verify="required" placeholder="请输入呈报单位" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">费用：</label>
            <div class="layui-input-inline">
                <input type="text" name="reportCost" lay-verify="required" placeholder="请输入费用" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">承办人：</label>
            <div class="layui-input-inline">
                <input type="text" name="reportName" lay-verify="required" class="layui-input"  >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系电话：</label>
            <div class="layui-input-inline">
                <input type="tel" name="reportPhone" lay-verify="required|phone" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">领导批示：</label>
            <div class="layui-input-inline">
                <select name="instructions" lay-verify=" ">
                    <option value=""></option>
                    <option value="同意">同意</option>
                    <option value="不同意">不同意</option>

                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">执行情况：</label>
            <div class="layui-input-inline">
                <select name="executiveResult" lay-verify=" ">
                    <option value=""></option>
                    <option value="已执行">已执行</option>
                    <option value="未执行">未执行</option>

                </select>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">签报内容：</label>
            <div class="layui-input-block">
                <textarea id="reportContent" name="reportContent"  cols="20" rows="2" class="ckeditor" > </textarea>
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
            layer.msg(JSON.stringify(data.field)+"==="+CKEDITOR.instances.reportContent.getData());
            var reportId = data.field.reportId;
            var reportTitle = data.field.reportTitle;
            var reportDate = data.field.reportDate;
            var reportingUnit = data.field.reportingUnit;
            var reportCost = data.field.reportCost;
            var reportName = data.field.reportName;
            var reportPhone = data.field.reportPhone;
            var instructions = data.field.instructions;
            var executiveResult = data.field.executiveResult;
            var reportContent =  CKEDITOR.instances.reportContent.getData();
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/ReportServlet",
                data:{
                    "action": "add",
                    "reportId": reportId,
                    "reportTitle": reportTitle,
                    "reportDate": reportDate,
                    "reportingUnit": reportingUnit,
                    "reportCost": reportCost,
                    "reportName": reportName,
                    "reportPhone": reportPhone,
                    "instructions": instructions,
                    "executiveResult": executiveResult,
                    "reportContent": reportContent
                },
                success:function(msgdata){
                    layer.msg("添加成功",{icon:1,time:2000});
                    setTimeout("location.reload()",3000)
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

