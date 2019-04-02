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
    <title>出库页面</title>
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
                <span class="x-red">*</span>仓库ID
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="id" name="id" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="good_name" class="layui-form-label">
                <span class="x-red">*</span>物品名称
            </label>
            <div class="layui-input-inline">
                <input value="" disabled="disabled" type="text" id="good_name" name="good_name" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="numbers" class="layui-form-label">
                <span class="x-red">*</span>出库数量
            </label>
            <div class="layui-input-inline">
                <input placeholder="不可大于库存数量" value="" type="text" id="numbers" name="numbers" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="update" lay-submit="">
                出库
            </button>
        </div>
    </form>
</div>
<script>
    var id;
    var goodName;
    function child(d) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        id = d.id;
        goodName = d.goodName;
        $("#id").attr("value", id);
        $("#good_name").attr("value", goodName);
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
            numbers=document.getElementById("numbers").value;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/GoodsServlet",
                data:{
                    "action":"outStorage",
                    "id":id,
                    "goodName":goodName,
                    "numbers":numbers
                },
                success:function (msg) {
                    if(msg=="1"){
                        //发异步，把数据提交给java
                        layer.alert("出库成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else if(msg!=null){
                        layer.msg("出库失败！库存不足");
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


