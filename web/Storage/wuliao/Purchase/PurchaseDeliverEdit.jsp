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
                <input value="" disabled="disabled" type="text" id="id" name="id" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="goodName" class="layui-form-label">
                <span class="x-red">*</span>物品名称
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="goodName" name="goodName" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier1Name" class="layui-form-label">
                <span class="x-red">*</span>供应商一名称
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="supplier1Name" name="supplier1Name" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier1Price" class="layui-form-label">
                <span class="x-red">*</span>供应商一价格
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="supplier1Price" name="supplier1Price" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier1Numbers" class="layui-form-label">
                <span class="x-red">*</span>供应商一分单数量
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="supplier1Numbers" name="supplier1Numbers" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier2Name" class="layui-form-label">
                <span class="x-red">*</span>供应商二名称
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="supplier2Name" name="supplier2Name" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier2Price" class="layui-form-label">
                <span class="x-red">*</span>供应商二价格
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="supplier2Price" name="supplier2Price" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="supplier2Numbers" class="layui-form-label">
                <span class="x-red">*</span>供应商二分单数量
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="supplier2Numbers" name="supplier2Numbers" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="total" class="layui-form-label">
                <span class="x-red">*</span>总花费
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="total" name="total" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="update" lay-submit="">
                通过
            </button>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="del" lay-submit="">
                否决
            </button>
        </div>
    </form>
</div>
<script>
    var id;
    var goodName;
    var supplier1Name;
    var supplier1Price;
    var supplier1Numbers;
    var supplier2Name;
    var supplier2Price;
    var supplier2Numbers;
    var total;
    function child(purchaseDeliver) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        id = purchaseDeliver.id;
        goodName = purchaseDeliver.goodName;
        supplier1Name = purchaseDeliver.supplier1Name;
        supplier1Price = purchaseDeliver.supplier1Price;
        supplier1Numbers = purchaseDeliver.supplier1Numbers;
        supplier2Name = purchaseDeliver.supplier2Name;
        supplier2Price = purchaseDeliver.supplier2Price;
        supplier2Numbers = purchaseDeliver.supplier2Numbers;
        total=purchaseDeliver.total;

        $("#id").attr("value", id);
        $("#goodName").attr("value", goodName);
        $("#supplier1Name").attr("value", supplier1Name);
        $("#supplier1Price").attr("value", supplier1Price);
        $("#supplier1Numbers").attr("value", supplier1Numbers);
        $("#supplier2Name").attr("value", supplier2Name);
        $("#supplier2Price").attr("value", supplier2Price);
        $("#supplier2Numbers").attr("value", supplier2Numbers);
        $("#total").attr("value", total);
    }

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

        //监听提交   通过
        form.on('submit(update)', function(data){
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/PurchaseServlet",
                data:{
                    "action":"PurchaseDeliverDeleteAddList",
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
                        layer.alert("审核通过!", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg("审核失败，填写数据有误！");
                    }
                },
                error:function () {
                    layer.msg("修改异常");
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


