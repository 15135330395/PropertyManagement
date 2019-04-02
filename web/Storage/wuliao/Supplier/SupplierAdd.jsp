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
    <title>供应商添加页面</title>
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
            <label for="sId" class="layui-form-label">
                <span class="x-red">*</span>供应商编号
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="sId" name="sId" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="names" class="layui-form-label">
                <span class="x-red">*</span>供应商名称
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="names" name="names" required="" lay-verify=""
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
                <span class="x-red">*</span>物品价格
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
                添加
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //监听提交
        form.on('submit(update)', function(data){
            sId=document.getElementById("sId").value;
            names=document.getElementById("names").value;
            contactPerson=document.getElementById("contactPerson").value;
            contactPhone=document.getElementById("contactPhone").value;
            goodName=document.getElementById("goodName").value;
            goodPrice=document.getElementById("goodPrice").value;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/SupplierServlet",
                data:{
                    "action":"add",
                    "id":sId,
                    "name":names,
                    "contactPerson":contactPerson,
                    "contactPhone":contactPhone,
                    "goodName":goodName,
                    "goodPrice":goodPrice
                },
                success:function (msg) {
                    if(msg=="1"){
                        //发异步，把数据提交给java
                        layer.alert("添加成功！", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg(msg);
                    }
                },
                error:function () {
                    layer.msg("添加异常！");
                }
            })
            return false;
        });
    });
</script>
</body>

</html>


