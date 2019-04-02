<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-28
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../info.jsp" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>物业管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>客户姓名
            </label>
            <div class="layui-input-inline">
                <input value="${customer.name}" type="text" id="name" name="name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
<%--下拉框--%>
            <div class="layui-form-item">
                <label class="layui-form-label">客户性质</label>
                <div class="layui-input-block">
                    <select name="customerNature" lay-verify="required">
                        <option value="${customer.customerNature}">${customer.customerNature}</option>
                        <option value="现住户">现住户</option>
                        <option value="往住户">往住户</option>
                    </select>
                </div>
            </div>

        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>联系方式
            </label>
            <div class="layui-input-inline">
                <input value="${customer.phone}" type="tel" id="phone" name="phone" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="idCard" class="layui-form-label">
                <span class="x-red">*</span>身份证号
            </label>
            <div class="layui-input-inline">
                <input readonly value="${customer.idCard}" type="number" id="idCard" name="idCard" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label for="car" class="layui-form-label">
                <span class="x-red">*</span>私家车信息
            </label>
            <div class="layui-input-inline">
                <input value="${customer.car}" type="text" id="car" name="car" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label for="pet" class="layui-form-label">
                <span class="x-red">*</span>宠物信息
            </label>
            <div class="layui-input-inline">
                <input value="${customer.pet}" type="text" id="pet" name="pet" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
<%--联动--%>
        <div class="layui-form-item">
            <label for="addr" class="layui-form-label">
                <span class="x-red">*</span>居住地址
            </label>
            <div class="layui-input-inline">
                <input readonly value="${customer.addr}" type="text" id="addr" name="addr" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="update" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(update)', function(data){
            var name = data.field.name;
            var customerNature = data.field.customerNature;
            var phone = data.field.phone;
            var idCard = data.field.idCard;
            var car = data.field.car;
            var pet = data.field.pet;
            var addr = data.field.addr;

            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/CustomerServlet",
                data:{
                    "action":"update",
                    "name":name,
                    "customerNature":customerNature,
                    "phone":phone,
                    "idCard":idCard,
                    "car":car,
                    "pet":pet,
                    "addr":addr,
                },
                success:function(msg){
                    if(msg=="1"){
                        //发异步，把数据提交给php
                        layer.alert("修改成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg("房子已处理，修改失败")
                    }

                },
                error:function () {
                    layer.msg("服务器忙")
                }
            })
            return false;
        });
    });

</script>
<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>