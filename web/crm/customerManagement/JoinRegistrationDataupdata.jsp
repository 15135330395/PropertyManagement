<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-28
  Time: 18:27
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
        <%--<div class="layui-form-item">--%>
        <%--<label for="id" class="layui-form-label">--%>
        <%--<span class="x-red">*</span>客户信息编号--%>
        <%--</label>--%>
        <%--<div class="layui-input-inline">--%>
        <%--<input value="${customer.id}" type="text" id="id" name="id" required="" lay-verify="required"--%>
        <%--autocomplete="off" class="layui-input">--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>客户姓名
            </label>
            <div class="layui-input-inline">
                <input value="${customerRegister.name}" type="text" id="name" name="name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--下拉框--%>
            <div class="layui-form-item">
                <label for="startTime" class="layui-form-label">
                    <span class="x-red">*</span>入伙时间
                </label>
                <div class="layui-input-inline">
                    <input value="${customerRegister.startTime}" type="text" id="startTime" name="startTime" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>联系方式
            </label>
            <div class="layui-input-inline">
                <input value="${customerRegister.phone}" type="tel" id="phone" name="phone" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="addr" class="layui-form-label">
                <span class="x-red">*</span>居住地址
            </label>
            <div class="layui-input-inline">
                <input readonly value="${customerRegister.addr}" type="text" id="addr" name="addr" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>

        </div>
            <div class="layui-form-item">
                <label class="layui-form-label">验收情况</label>
                <div class="layui-input-block">
                    <select name="checkAccept" lay-verify="required">
                        <option >${customerRegister.checkAccept}</option>
                        <option value="已验收">已验收</option>
                        <option value="未验收">未验收</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">钥匙发放情况</label>
                <div class="layui-input-block">
                    <select name="keyState" lay-verify="required">
                        <option>${customerRegister.keyState}</option>
                        <option value="已发放">已发放</option>
                        <option value="未发放">未发放</option>
                    </select>
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
            var phone = data.field.phone;
            var addr = data.field.addr;
            var checkAccept = data.field.checkAccept;
            var keyState = data.field.keyState;

            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/CustomerRegisterServelt",
                data:{
                    "action":"update",
                    "name":name,
                    "checkAccept":checkAccept,
                    "phone":phone,
                    "addr":addr,
                    "keyState":keyState
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
                        layer.msg("修改的房子已存在，修改失败")
                    }

                },
                error:function () {
                    layer.msg("修改")
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