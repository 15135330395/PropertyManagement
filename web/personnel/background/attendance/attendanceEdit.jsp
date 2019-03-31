<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/31
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>编辑信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item ">
            <label class="layui-form-label">编号：</label>
            <div class="layui-input-inline">
                <input readonly type="text" name="attendanceId" value="${attendance.attendanceId}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名：</label>
            <div class="layui-input-inline">
                <input  type="hidden" name="staffId" value="${attendance.staffId}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                <c:forEach items="${staffList}" var="list">
                    <c:if test="${list.staffId == attendance.staffId}">
                        <input readonly type="text"  value="${list.staffName}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属部门：</label>
            <div class="layui-input-inline">
                <select name="departmentId" lay-verify="required" value="${attendance.departmentId}">
                    <option value=""></option>
                    <c:forEach items="${departmentList}" var="list">
                        <c:if test="${list.departmentId == attendance.departmentId}">
                            <option selected value="${list.departmentId}">${list.departmentName}</option>
                        </c:if>
                        <c:if test="${list.departmentId != attendance.departmentId}">
                            <option value="${list.departmentId}">${list.departmentName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">工作日：</label>
            <div class="layui-input-inline">
                <input type="number" name="workDay" required lay-verify="required" value="${attendance.workDay}"  placeholder="请输入工作日" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">病假：</label>
            <div class="layui-input-inline">
                <input type="number" name="sickLeave" required lay-verify="required" value="${attendance.sickLeave}"  placeholder="请输入病假天数" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">事假：</label>
            <div class="layui-input-inline">
                <input type="number" name="affairLeave" required lay-verify="required" value="${attendance.affairLeave}"  placeholder="请输入事假天数" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">加班：</label>
            <div class="layui-input-inline">
                <input type="number" name="onduty" required lay-verify="required" value="${attendance.onduty}"  placeholder="请输入加班天数" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">旷工：</label>
            <div class="layui-input-inline">
                <input type="number" name="abnormal" required lay-verify="required" value="${attendance.abnormal}"  placeholder="请输入旷工天数" autocomplete="off" class="layui-input">
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
            var attendanceId = data.field.attendanceId;
            var staffId = data.field.staffId;
            var departmentId = data.field.departmentId;
            var workDay = data.field.workDay;
            var sickLeave = data.field.sickLeave;
            var affairLeave = data.field.affairLeave;
            var onduty = data.field.onduty;
            var abnormal = data.field.abnormal;
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/AttendanceServlet",
                    data:{
                        "action":"update",
                        "attendanceId":attendanceId,
                        "staffId":staffId,
                        "departmentId":departmentId,
                        "workDay":workDay,
                        "sickLeave":sickLeave,
                        "affairLeave":affairLeave,
                        "onduty":onduty,
                        "abnormal":abnormal
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
            return false;
        });

    });
</script>
</body>
</html>
