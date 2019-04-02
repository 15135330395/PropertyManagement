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
    <title>供应商信息更新页面</title>
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
                <span class="x-red">*</span>编号
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="id" name="id" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>供应商名称
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="name" name="name" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="contactPerson" class="layui-form-label">
                <span class="x-red">*</span>联系人
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="contactPerson" name="contactPerson" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="contactPhone" class="layui-form-label">
                <span class="x-red">*</span>联系方式
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="contactPhone" name="contactPhone" required="" lay-verify=""
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
            <label for="goodPrice" class="layui-form-label">
                <span class="x-red">*</span>物品单价
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="goodPrice" name="goodPrice" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="update" lay-submit="">
                更新
            </button>
        </div>
    </form>
</div>
<script>
    var id;
    var name;
    var contactPerson;
    var contactPhone;
    var goodName;
    var goodPrice;
    function child(supplier) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        id = supplier.id;
        name = supplier.name;
        contactPerson = supplier.contactPerson;
        contactPhone = supplier.contactPhone;
        goodName = supplier.goodName;
        goodPrice = supplier.goodPrice;
        $("#id").attr("value", id);
        $("#name").attr("value", name);
        $("#contactPerson").attr("value", contactPerson);
        $("#contactPhone").attr("value", contactPhone);
        $("#goodName").attr("value", goodName);
        $("#goodPrice").attr("value", goodPrice);
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

        //监听提交
        form.on('submit(update)', function(data){
            id=document.getElementById("id").value;
            name=document.getElementById("name").value;
            contactPerson=document.getElementById("contactPerson").value;
            contactPhone=document.getElementById("contactPhone").value;
            goodName=document.getElementById("goodName").value;
            goodPrice=document.getElementById("goodPrice").value;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/SupplierServlet",
                data:{
                    "action":"update",
                    "id":id,
                    "name":name,
                    "contactPerson":contactPerson,
                    "contactPhone":contactPhone,
                    "goodName":goodName,
                    "goodPrice":goodPrice
                },
                success:function (msg) {
                    if(msg=="1"){
                        //发异步，把数据提交给java
                        layer.alert("更新成功!", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg("更新失败，该仓库或不存在！");
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


