<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/31
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../commons/info.jsp"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/equbackground/ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">ID：</label>
            <div class="layui-input-block">
                <input type="text" name="id" required  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">合同编号</label>
            <div class="layui-input-block">
                <input type="text" name="contractId" autocomplete="off" placeholder="请输入合同编号" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">合同名称：</label>
            <div class="layui-input-block">
                <input type="text" name="contractName" required  lay-verify="required" placeholder="请输入合同名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">甲方：</label>
            <div class="layui-input-inline">
                <input type="text" name="firstParty" required lay-verify="required" placeholder="请输入甲方名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">乙方：</label>
            <div class="layui-input-inline">
                <input type="text" name="secondParty" required lay-verify="required" placeholder="请输入乙方名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">签约日期：</label>
            <div class="layui-input-inline">
                <input type="datetime" name="sigingDate" lay-verify="required" class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">项目位置：</label>
            <div class="layui-input-inline">
                <input type="text" name="projectLocation" lay-verify="required" class="layui-input"  >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">费用：</label>
            <div class="layui-input-inline">
                <input type="text" name="cost" required lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">供应链：</label>
            <div class="layui-input-inline">
                <input type="text" name="supplyChain" lay-verify="required" class="layui-input"  >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">付款周期：</label>
            <div class="layui-input-inline">
                <input type="text" name="paymentCycle" lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验收结果：</label>
            <div class="layui-input-inline">
                <input type="text" name="acceptanceResult" lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">合同内容：</label>
            <div class="layui-input-block">
                <textarea id="content" name="content"  cols="20" rows="2" class="ckeditor" > </textarea>
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
            layer.msg(JSON.stringify(data.field)+"==="+CKEDITOR.instances.content.getData());
            var id = data.field.id;
            var contractId = data.field.contractId;
            var contractName = data.field.contractName;
            var firstParty = data.field.firstParty;
            var secondParty = data.field.secondParty;
            var sigingDate = data.field.sigingDate;
            var projectLocation = data.field.projectLocation;
            var cost = data.field.cost;
            var supplyChain = data.field.supplyChain;
            var paymentCycle = data.field.paymentCycle;
            var acceptanceResult = data.field.acceptanceResult;
            var content =  CKEDITOR.instances.content.getData();
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/ContractServlet",
                data:{
                    "action": "add",
                    "id": id,
                    "contractId": contractId,
                    "contractName": contractName,
                    "firstParty": firstParty,
                    "secondParty": secondParty,
                    "sigingDate": sigingDate,
                    "projectLocation": projectLocation,
                    "cost": cost,
                    "supplyChain": supplyChain,
                    "paymentCycle": paymentCycle,
                    "acceptanceResult": acceptanceResult,
                    "content": content
                },
                success:function(msgdata){
                    layer.msg("添加成功",{icon:1,time:2000});
                    /*setTimeout("location.reload()",3000)*/
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


