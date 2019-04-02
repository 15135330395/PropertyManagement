<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/31
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>添加信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <input type="hidden" name="salaryId" value="${salary.salaryId}" autocomplete="off" class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名：</label>
            <div class="layui-input-inline">
                <select name="staffId" lay-verify="required" lay-filter="staffSel">
                    <option value=""></option>
                    <c:forEach items="${staffList}" var="list">
                            <option id="staff" value="${list.staffId}">${list.staffName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">基本工资：</label>
            <div class="layui-input-inline">
                <input type="number" name="basicSalary" value="${salary.basicSalary}"  lay-verify="required" placeholder="请输入基本工资" autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">考勤编号：</label>
            <div class="layui-input-inline">
                <input readonly id="attantance"  type="number" name="attantanceId" required lay-verify="required" value=""  placeholder="暂未添加考勤"  autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">绩效编号：</label>
            <div class="layui-input-inline">
                <input readonly id="kpi" type="number" name="kpiId" required lay-verify="required" value=""  placeholder="暂未添加绩效" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">社保编号：</label>
            <div class="layui-input-inline">
                <input readonly id="securityInsurance" type="number" name="securityInsuranceId" required lay-verify="required" value=""  placeholder="暂未添加社保" autocomplete="off" class="layui-input">
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
    layui.use(['laydate','form','upload'], function(){
        var form = layui.form;
        var laydate = layui.laydate;
        //监听提交
        form.on('submit(submitSave)', function(data){
            var salaryId = data.field.salaryId;
            var staffId = data.field.staffId;
            var basicSalary = data.field.basicSalary;
            var attantanceId = data.field.attantanceId;
            var kpiId = data.field.kpiId;
            var securityInsuranceId = data.field.securityInsuranceId;
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/SalaryServlet",
                    data:{
                        "action":"add",
                        "staffId":staffId,
                        "basicSalary":basicSalary,
                        "attantanceId":attantanceId,
                        "kpiId":kpiId,
                        "securityInsuranceId":securityInsuranceId
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
        form.on('select(staffSel)', function (data) {
            $("#attantance").val('');
            $("#kpi").val('');
            $("#securityInsurance").val('');
            $.ajax({
                url: "<%=request.getContextPath()%>/SalaryServlet",
                data: {
                    action: "queryAttantanceId",
                    staffId: data.value
                },
                success: function (result) {
                    var arr = eval("("+result+")");
                        $("#attantance").val(arr)
                }
            });
            $.ajax({
                url: "<%=request.getContextPath()%>/SalaryServlet",
                data: {
                    action: "querySecurityInsuranceId",
                    staffId: data.value
                },
                success: function (result) {
                    var arr = eval("("+result+")");
                    $("#securityInsurance").val(arr)
                }
            });
            $.ajax({
                url: "<%=request.getContextPath()%>/SalaryServlet",
                data: {
                    action: "queryKpiId",
                    staffId: data.value
                },
                success: function (result) {
                    var arr = eval("("+result+")");
                    $("#kpi").val(arr)
                }
            });
        });
    });
</script>
</body>
</html>
