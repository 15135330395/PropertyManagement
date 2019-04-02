<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../info.jsp"%>
<html>
<head>
    <title>物业管理系统</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">客户姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">入伙时间</label>
            <div class="layui-input-inline">
                <input type="text" name="startTime" lay-verify="required" class="layui-input" id="startTime">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系方式</label>
            <div class="layui-input-inline">
                <input type="text" name="phone" required lay-verify="required" placeholder="请输入电话号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--房屋信息联动--%>
        <div class="layui-form-item">
            <label class="layui-form-label">居住区域</label>
            <div class="layui-input-block">
                <select  lay-verify="required" lay-filter="provSel" id="are" name="are">
                    <option value=""></option>
                    <c:forEach items="${lsit}" var="aList">
                        <option id="area" value="${aList.area_id}">${aList.area_name}</option>
                    </c:forEach>
                </select>
            </div>
            <label class="layui-form-label">居住楼宇</label>
            <div class="layui-input-block">
                <select id="build" class="asd" name="build" lay-verify="required" lay-filter="build">
                    <option value=""></option>
                </select>
            </div>
            <label class="layui-form-label">居住房号</label>
            <div class="layui-input-block">
                <select id="house" class="house" name="house" lay-verify="required">
                    <option value=""></option>
                </select>
            </div>
        </div>
        <%--房屋信息联动--%>
        <div class="layui-form-item">
            <label class="layui-form-label">验收情况</label>
            <div class="layui-input-block">
                <select name="checkAccept" lay-verify="required">
                    <option value=""></option>
                    <option value="已验收">已验收</option>
                    <option value="未验收">未验收</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">钥匙发放情况</label>
            <div class="layui-input-block">
                <select name="keyState" lay-verify="required">
                    <option value=""></option>
                    <option value="已发放">已发放</option>
                    <option value="未发放">未发放</option>
                </select>
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

            var name = data.field.name;
            var startTime = data.field.startTime;
            var phone = data.field.phone;
            var idCard = data.field.idCard;
            var checkAccept = data.field.checkAccept;
            var keyState = data.field.keyState;
            var are = data.field.are;
            var build = data.field.build;
            var house = data.field.house;
            $.ajax({
                type:"post",
                url:"/CustomerRegisterServelt",
                data:{
                    "action":"add",
                    "name":name,
                    "startTime":startTime,
                    "idCard":idCard,
                    "phone":phone,
                    "checkAccept":checkAccept,
                    "keyState":keyState,
                    "are":are,
                    "build":build,
                    "house":house
                },
                success:function(msg){
                    if(msg=="1"){
                        //发异步，把数据提交给php
                        layer.alert("增加成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg("房子已交接")
                    }

                }
            })
            return false;
        });
        laydate.render({
            elem:'#startTime'
            ,type:'datetime'
        });

        form.on('select(provSel)', function (data) {
            $.ajax({
                url: "<%=request.getContextPath()%>/AddrServlet",
                dataType: 'json',
                data: {
                    action:"queryBuild",
                    bid: data.value
                },
                success: function (result) {
                    var arr = eval(result);

                    $.each(arr, function(key, val) {

                        $(".asd").append("<option value='"+val.building_id+"' id='" + val.building_id + "'>" + val.building_name + "</option>")

                    });

                    form.render('select');

                },

            });
            $(".asd option").remove();
        });
        form.on('select(build)', function (data) {

            $.ajax({
                url: "<%=request.getContextPath()%>/AddrServlet",
                dataType: 'json',
                data: {
                    action:"queryHouse",
                    hid: data.value
                },
                success: function (result) {

                    var arr = eval(result);

                    $.each(arr, function(key, val) {

                        $("#house").append("<option id='" + val.house_id + "'>" + val.house_id + "</option>")

                    });

                    form.render('select');

                },

            });
            $("#house option").remove();
        });
    });
</script>
</body>
</html>
