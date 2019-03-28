<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commons/info.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="areaId" required  value="${area.areaId}"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">区域：</label>
            <div class="layui-input-block">
                <input type="text" name="areaName" required  lay-verify="required" value="${area.areaName}" placeholder="请输入区域" autocomplete="off" class="layui-input">
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
            //layer.msg(JSON.stringify(data.field)+"==="+CKEDITOR.instances.content.getData());

            var areaId = data.field.areaId;
            var areaName = data.field.areaName;
            if(areaId!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/AreaServlet",
                    data:{
                        "action":"update",
                        "areaId":areaId,
                        "areaName":areaName
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
                    }
                })
            }else {
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/AreaServlet",
                    data:{
                        "action":"add",
                        "areaName":areaName
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:2000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                    }
                })
            }
            return false;
        });
    });
</script>
</body>
</html>
