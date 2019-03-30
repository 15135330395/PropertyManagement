<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/30
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <input type="hidden" name="labourContractId" value="${labourContract.labourContractId}" autocomplete="off" class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">甲方：</label>
            <div class="layui-input-inline">
                <input type="text" name="companyName" required value="${labourContract.companyName}"  lay-verify="required" placeholder="请输入甲方" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">劳动者：</label>
            <div class="layui-input-inline">
                <input type="text" name="staffName" required value="${labourContract.staffName}"  lay-verify="required" placeholder="请输入劳动者" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">合同时间：</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" name="jobTime" value="${labourContract.jobTime}"lay-verify="required" id="test2"
                       placeholder="yyyy-MM-dd HH:mm">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">签订时间：</label>
            <div class="layui-input-inline">
                <input type="text" name="signTime" value="<fmt:formatDate value="${labourContract.signTime}" pattern="yyyy-MM-dd " />"  lay-verify="required" placeholder="请选择签订时间"class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">基本工资：</label>
            <div class="layui-input-inline">
                <input type="text" name="basicSalary" required lay-verify="required" value="${labourContract.basicSalary}"  placeholder="请输入工资" autocomplete="off" class="layui-input">
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

            var labourContractId = data.field.labourContractId;
            var staffName = data.field.staffName;
            var companyName = data.field.companyName;
            var jobTime = data.field.jobTime;
            var signTime = data.field.signTime;
            var basicSalary = data.field.basicSalary

            if(labourContractId!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/labourContractServlet",
                    data:{
                        "action":"update",
                        "labourContractId":labourContractId,
                        "companyName":companyName,
                        "staffName":staffName,
                        "jobTime":jobTime,
                        "signTime":signTime,
                        "basicSalary":basicSalary
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
                    url:"<%=request.getContextPath()%>/labourContractServlet",
                    data:{
                        "action":"add",
                        "companyName":companyName,
                        "staffName":staffName,
                        "jobTime":jobTime,
                        "signTime":signTime,
                        "basicSalary":basicSalary
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

        laydate.render({
            elem: '#test1', //指定元素
            type:'datetime'
        });
        laydate.render({
            elem: '#test2', //指定元素
            type: 'datetime'
            , range: true
        });
    });
</script>
</body>
</html>
