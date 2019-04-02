<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/30
  Time: 12:46
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
        <input type="hidden" name="kpiId" value="${kpi.kpiId}" autocomplete="off" class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名：</label>
            <div class="layui-input-inline">
                <select name="staffId" lay-verify="required" >
                    <option value=""></option>
                    <c:forEach items="${staffList}" var="list">
                        <option   value="${list.staffId}">${list.staffName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">评价人：</label>
            <div class="layui-input-inline">
                <input type="text"   name="evaluatePerson"    lay-verify="required" placeholder="请输入评价人"class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">评价内容：</label>
            <div class="layui-input-block">
                <textarea   name="evaluateContent"  cols="20" rows="2" class="layui-textarea">${kpi.evaluateContent}</textarea>
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
            var kpiId = data.field.kpiId;
            var staffId = data.field.staffId;
            var evaluatePerson =  data.field.evaluatePerson;
            var evaluateContent =  data.field.evaluateContent;
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/KpiServlet",
                    data:{
                        "action":"add",
                        "staffId":staffId,
                        "evaluatePerson":evaluatePerson,
                        "evaluateContent":evaluateContent
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
        });
    });
</script>
</body>
</html>

