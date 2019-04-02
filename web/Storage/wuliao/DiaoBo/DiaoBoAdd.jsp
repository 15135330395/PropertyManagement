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
    <title>调拨页面</title>
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
            <label for="outId" class="layui-form-label">
                <span class="x-red">*</span>出库仓库ID
            </label>
            <div class="layui-input-inline">
                <input value="" placeholder="1总部 2分部一 3分部二" type="text" id="outId" name="outId" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="inId" class="layui-form-label">
                <span class="x-red">*</span>入库仓库ID
            </label>
            <div class="layui-input-inline">
                <input value="" placeholder="1总部 2分部一 3分部二" type="text" id="inId" name="inId" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="good_name" class="layui-form-label">
                <span class="x-red">*</span>物品名称
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="good_name" name="good_name" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="numbers" class="layui-form-label">
                <span class="x-red">*</span>数量
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="numbers" name="numbers" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="update" lay-submit="">
                执行
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
            outId=document.getElementById("outId").value;
            inId=document.getElementById("inId").value;
            good_name=document.getElementById("good_name").value;
            numbers=document.getElementById("numbers").value;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/DiaoBoServlet",
                data:{
                    "action":"add",
                    "outId":outId,
                    "inId":inId,
                    "good_name":good_name,
                    "numbers":numbers
                },
                success:function (msg) {
                    if(msg=="1"){
                        //发异步，把数据提交给java
                        layer.alert("调拨成功", {icon: 6},function () {
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
                    layer.msg("必填项不能为空！");
                }
            })
            return false;
        });
    });
</script>
</body>

</html>


