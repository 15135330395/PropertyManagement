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
            <label class="layui-form-label">收费项目名称：</label>
            <div class="layui-input-block">
                <input type="text" name="payName"  value="${meterReadingById.payName}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收费标准名称：</label>
            <div class="layui-input-block">
                <input type="text" name="normName"  value="${meterReadingById.normName}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">日期：</label>
            <div class="layui-input-block">
                <input type="text" name="riqi"  value="${meterReadingById.riqi}"  autocomplete="off" class="layui-input">
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
                <input type="text" name="stop"  value="${meterReadingById.stop}" placeholder="收费周期" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公摊：</label>
            <div class="layui-input-block">
                <input type="text" name="pooled"  value="${meterReadingById.pooled}" placeholder="收费周期" autocomplete="off" class="layui-input">
            </div>
        </div>
        private int meterReadingId;//抄表id
        private String plotName;//小区名
        private String roomNumber;//房间号
        private String payName;//收费项目名称
        private String normName;//收费标准名称
        private Date riqi;//日期
        private double price;//单价
        private double start;//起度
        private double stop;//止度
        private double pooled;//公摊
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
            var normId=data.field.normId;
            var payId=data.field.payId;
            var normName=data.field.normName;
            var computeMode=data.field.computeMode;
            var price=data.field.price;
            var fillingType=data.field.fillingType;
            var closeEnd=data.field.closeEnd;
            var customFormula=data.field.customFormula;
            var chargeCycle=data.field.chargeCycle;
            if(normId!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/PayNormServlet",
                    data:{
                        "action":"update",
                        "normId":normId,
                        "payId":payId,
                        "normName":normName,
                        "computeMode":computeMode,
                        "price":price,
                        "fillingType":fillingType,
                        "closeEnd":closeEnd,
                        "customFormula":customFormula,
                        "chargeCycle":chargeCycle
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
                    url:"<%=request.getContextPath()%>/PayNormServlet",
                    data:{
                        "action":"add",
                        "normId":normId,
                        "payId":payId,
                        "normName":normName,
                        "computeMode":computeMode,
                        "price":price,
                        "fillingType":fillingType,
                        "closeEnd":closeEnd,
                        "customFormula":customFormula,
                        "chargeCycle":chargeCycle
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:2000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                        request.getRequestDispatcher("/shouFei/norm/payNorm.jsp").forward(request,response);
                    }
                })
            }
            return false;
        });
    });
</script>
</body>
</html>
