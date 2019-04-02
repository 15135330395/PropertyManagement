<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../commons/info.jsp"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/equbackground/ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <%--<div class="layui-form-item">
            <label class="layui-form-label">ID：</label>
            <div class="layui-input-block">
                <input type="hidden" name="eid" required  lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>--%>
        <div class="layui-form-item">
            <label class="layui-form-label">设备名称</label>
            <div class="layui-input-block">
                <input type="text" name="ename" autocomplete="off" placeholder="请输入设备名称" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设备编号：</label>
            <div class="layui-input-block">
                <input type="text" name="eno" required  lay-verify="required" placeholder="请输入设备编号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责人：</label>
            <div class="layui-input-inline">
                <input type="text" name="charge" required lay-verify="required" placeholder="请输入负责人姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">保养日期：</label>
            <div class="layui-input-inline">
                <input name="edate" lay-verify="required" class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">领取物料名称：</label>
            <div class="layui-input-inline">
                <input type="text" name="material" lay-verify="required" class="layui-input"  >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">领取物料数量：</label>
            <div class="layui-input-inline">
                <input type="text" name="number" required lay-verify="required" placeholder="请输入数量" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">保养过程：</label>
            <div class="layui-input-block">
                <textarea id="content" name="content"  cols="20" rows="2" class="ckeditor" > </textarea>
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
            layer.msg(JSON.stringify(data.field)+"==="+CKEDITOR.instances.content.getData());
            var eid = data.field.eid;
            var ename = data.field.ename;
            var eno = data.field.eno;
            var charge = data.field.charge;
            var edate = data.field.edate;
            var material = data.field.material;
            var number = data.field.number;
            var content =  CKEDITOR.instances.content.getData();
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/EqumaintenanceServlet",
                data:{
                    "action": "add",
                    "eid": eid,
                    "ename": ename,
                    "eno": eno,
                    "charge": charge,
                    "edate": edate,
                    "material": material,
                    "number": number,
                    "content": content
                },
                success:function(msgdata){
                    layer.msg("添加成功",{icon:1,time:2000});
                    /*setTimeout("location.reload()",3000)*/
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
            type:'datetime'
        });
    });
</script>
</body>
</html>



