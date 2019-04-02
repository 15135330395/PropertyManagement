<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/3/28
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../commons/info.jsp"%>
<html>
<head>
    <title>抄表录入的添加</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="meterReadingId" required  value="${meterReadingById.meterReadingId}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">小区名：</label>
            <div class="layui-input-block">
                <input type="text" name="plotName"  value="${meterReadingById.plotName}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">房间号：</label>
            <div class="layui-input-block">
                <input type="text" name="roomNumber"  value="${meterReadingById.roomNumber}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">日期：</label>
            <div class="layui-input-block">
                <input type="text" name="riqi"  value="${meterReadingById.riqi}"  autocomplete="off" class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单价：</label>
            <div class="layui-input-block">
                <input type="text" name="price" value="${meterReadingById.price}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">起度：</label>
            <div class="layui-input-block">
                <input type="text" name="start" value="${meterReadingById.start}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">止度：</label>
            <div class="layui-input-block">
                <input type="text" name="stop"  value="${meterReadingById.stop}" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公摊：</label>
            <div class="layui-input-block">
                <input type="text" name="pooled"  value="${meterReadingById.pooled}" placeholder="" autocomplete="off" class="layui-input">
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
    layui.use(['laydate','form','layer'], function(){
        var form = layui.form;
        var laydate = layui.laydate;
        var layer = layui.layer;
        //监听提交
        form.on('submit(submitSave)', function(data){
            //layer.msg(JSON.stringify(data.field));
            //alert(data.field)
            var meterReadingId=data.field.meterReadingId;
            var plotName=data.field.plotName;
            var roomNumber=data.field.roomNumber;
            var riqi=data.field.riqi;
            var price=data.field.price;
            var start=data.field.start;
            var stop=data.field.stop;
            var pooled=data.field.pooled;
            if(meterReadingId!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/MeterReadingServlet",
                    data:{
                        "action":"update",
                        "meterReadingId":meterReadingId,
                        "plotName":plotName,
                        "roomNumber":roomNumber,
                        "riqi":riqi,
                        "price":price,
                        "start":start,
                        "stop":stop,
                        "pooled":pooled
                    },
                    success:function(msgData){
                        layer.msg("修改成功",{icon:1,time:2000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                    }
                })
            }else {
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/MeterReadingServlet",
                    data:{
                        "action":"add",
                        "meterReadingId":meterReadingId,
                        "plotName":plotName,
                        "roomNumber":roomNumber,
                        "riqi":riqi,
                        "price":price,
                        "start":start,
                        "stop":stop,
                        "pooled":pooled
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:2000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                       // request.getRequestDispatcher("<%=request.getContextPath()%>/MeterReadingServlet?action=query").forward(request,response);
                    }
                })
            }
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
