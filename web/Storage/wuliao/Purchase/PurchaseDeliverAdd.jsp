<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>采购分单填写页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%@include file="../../background/commons/info.jsp"%>
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="linkId" class="layui-form-label">
                <span class="x-red"></span>
            </label>
            <div class="layui-input-inline">
                <input value="" type="hidden" id="linkId" name="linkId" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="id" class="layui-form-label">
                <span class="x-red">*</span>仓库编号
            </label>
            <div class="layui-input-inline">
                <input placeholder="1总部 2分部一 3分部二" value="" type="text" id="id" name="id" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="goodName" class="layui-form-label">
                <span class="x-red">*</span>物品名称
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="goodName" name="goodName" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier1Name" class="layui-form-label">
                <span class="x-red">*</span>供应商一名称
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="supplier1Name" name="supplier1Name" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier1Price" class="layui-form-label">
                <span class="x-red">*</span>供应商一价格
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="supplier1Price" name="supplier1Price" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier1Numbers" class="layui-form-label">
                <span class="x-red">*</span>供应商一分单数量
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="supplier1Numbers" name="supplier1Numbers" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier2Name" class="layui-form-label">
                <span class="x-red">*</span>供应商二名称
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="supplier2Name" name="supplier2Name" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier2Price" class="layui-form-label">
                <span class="x-red">*</span>供应商二价格
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="supplier2Price" name="supplier2Price" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier2Numbers" class="layui-form-label">
                <span class="x-red">*</span>供应商二分单数量
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="supplier2Numbers" name="supplier2Numbers" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="update" lay-submit="">
                申请
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        // //自定义验证规则
        // form.verify({
        //     nikename: function(value){
        //         if(value.length < 5){
        //             return '昵称至少得5个字符啊';
        //         }
        //     }
        //     ,pass: [/(.+){6,12}$/, '密码必须6到12位']
        //     ,repass: function(value){
        //         if($('#L_pass').val()!=$('#L_repass').val()){
        //             return '两次密码不一致';
        //         }
        //     }
        // });

        //监听提交   提交申请
        form.on('submit(update)', function(data){
            var id=document.getElementById("id").value;
            var goodName=document.getElementById("goodName").value;
            var supplier1Name=document.getElementById("supplier1Name").value;
            var supplier1Price=document.getElementById("supplier1Price").value;
            var supplier1Numbers=document.getElementById("supplier1Numbers").value;
            var supplier2Name=document.getElementById("supplier2Name").value;
            var supplier2Price=document.getElementById("supplier2Price").value;
            var supplier2Numbers=document.getElementById("supplier2Numbers").value;
            var total=(supplier1Price*supplier1Numbers)+(supplier2Price*supplier2Numbers);
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/PurchaseServlet",
                data:{
                    "action":"PurchaseDeliverAdd",
                    "id":id,
                    "goodName":goodName,
                    "supplier1Name":supplier1Name,
                    "supplier1Price":supplier1Price,
                    "supplier1Numbers":supplier1Numbers,
                    "supplier2Name":supplier2Name,
                    "supplier2Price":supplier2Price,
                    "supplier2Numbers":supplier2Numbers,
                    "total":total
                },
                success:function (msg) {
                    if(msg=="1"){
                        //发异步，把数据提交给java
                        layer.alert("申请成功，等待审核!", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg("申请失败！采购信息填写有误！");
                    }
                },
                error:function () {
                    layer.msg("必填项不能为空！");
                }
            })
            return false;
        });

        //否决
        form.on('submit(del)', function(data){
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/PurchaseServlet",
                data:{
                    "action":"PurchaseDeliverDelete",
                    "id":id,
                    "goodName":goodName
                },
                success:function (msg) {
                    if(msg=="1"){
                        //发异步，把数据提交给java
                        layer.alert("否决成功!", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg("否决失败！采购申请不存在！");
                    }
                },
                error:function () {
                    layer.msg("修改异常");
                }
            })
            return false;
        });
    });
</script>
</body>

</html>


