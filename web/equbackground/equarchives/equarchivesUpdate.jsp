<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/equbackground/ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="id" value="${equarchives.id}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">档案编号：</label>
            <div class="layui-input-block">
                <input type="text" name="ano" value="${equarchives.ano}" required  lay-verify="required" placeholder="请输入合同编号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设备名称：</label>
            <div class="layui-input-block">
                <input type="text" name="ename" value="${equarchives.ename}" required  lay-verify="required" placeholder="请输入合同名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">设备编号：</label>
            <div class="layui-input-inline">
                <input type="text" name="eno" value="${equarchives.eno}" required lay-verify="required" placeholder="请输入甲方名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">使用部门：</label>
            <div class="layui-input-inline">
                <input type="text" name="department" value="${equarchives.department}" required lay-verify="required" placeholder="请输入乙方名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登记日期：</label>
            <div class="layui-input-inline">
                <input  name="recordDate"
                       value="<fmt:formatDate value="${equarchives.recordDate}" pattern="yyyy-MM-dd HH:mm:ss " />"
                       lay-verify="required" class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">生产厂家：</label>
            <div class="layui-input-inline">
                <input type="text" name="manufacturer" value="${equarchives.manufacturer}" lay-verify="required" class="layui-input"  >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设备价格：</label>
            <div class="layui-input-inline">
                <input type="text" name="price" value="${equarchives.price}" lay-verify="required" placeholder="请输入金额" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">区域：</label>
            <div class="layui-input-inline">
                <input type="text" name="place" value="${equarchives.place}" lay-verify="required" class="layui-input"  >
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
            layer.msg(JSON.stringify(data.field));
            var id = data.field.id;
            var ano = data.field.ano;
            var ename = data.field.ename;
            var eno = data.field.eno;
            var department = data.field.department;
            var recordDate = data.field.recordDate;
            var manufacturer = data.field.manufacturer;
            var price = data.field.price;
            var place = data.field.place;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/EquarchivesServlet",
                data:{
                    "action": "update",
                    "id": id,
                    "ano": ano,
                    "ename": ename,
                    "eno": eno,
                    "department": department,
                    "recordDate": recordDate,
                    "manufacturer": manufacturer,
                    "price": price,
                    "place": place
                },
                success:function(msgdata){
                    layer.msg("修改成功",{icon:1,time:2000});
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
            type:'date'
        });
    });
</script>
</body>
</html>


