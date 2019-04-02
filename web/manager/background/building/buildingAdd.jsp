<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>房产管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%@include file="../commons/info.jsp"%>
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="buildingName" class="layui-form-label">
                <span class="x-red">*</span>楼宇名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="buildingName" name="buildingName" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="staffId" class="layui-form-label">
                <span class="x-red">*</span>职员编号
            </label>
            <div class="layui-input-inline">
                <input type="number" id="staffId" name="staffId" required="" lay-verify="number"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="areaId" class="layui-form-label">
                <span class="x-red">*</span>区域编号
            </label>
            <div class="layui-input-inline">
                <input type="number" id="areaId" name="areaId" required="" lay-verify="number"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                增加
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
        form.on('submit(add)', function(data){
            var buildingName=data.field.buildingName;
            var staffId=data.field.staffId;
            var areaId=data.field.areaId;

            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/BuildingServlet",
                data:{
                    "action":"add",
                    "buildingName":buildingName,
                    "staffId":staffId,
                    "areaId":areaId
                },
                success:function(msg){
                    if(msg=="1"){
                        //发异步，把数据提交给java
                        layer.alert("增加成功", {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            window.parent.location.reload();
                        });
                    }else{
                        layer.msg("添加失败")
                    }
                },
                error:function () {
                    layer.msg("添加异常")
                }
            })
            return false;
        });
    });
</script>
</body>

</html>
