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
    <title>常规费用的添加</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="ruleId" required  value="${ruleById.ruleId}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">小区名：</label>
            <div class="layui-input-block">
                <input type="text" name="plotName"  value="${ruleById.plotName}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">房间号：</label>
            <div class="layui-input-block">
                <input type="text" name="roomNumber"  value="${ruleById.roomNumber}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收费项目名称：</label>
            <div class="layui-input-block">
                <input type="text" name="payName"  value="${ruleById.payName}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收费标准名称：</label>
            <div class="layui-input-block">
                <input type="text" name="normName"  value="${ruleById.normName}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单价：</label>
            <div class="layui-input-block">
                <input type="text" name="price" value="${ruleById.price}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">面积：</label>
            <div class="layui-input-block">
                <input type="text" name="area" value="${ruleById.area}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">固定金额：</label>
            <div class="layui-input-block">
                <input type="text" name="closeEnd"  value="${ruleById.closeEnd}" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">日期：</label>
            <div class="layui-input-block">
                <input type="text" name="riqi"  value="${ruleById.riqi}"  autocomplete="off" class="layui-input" id="test1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">停车费：</label>
            <div class="layui-input-block">
                <input type="text" name="money2"  value="${ruleById.money2}" placeholder="" autocomplete="off" class="layui-input">
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
            var ruleId=data.field.ruleId;
            var plotName=data.field.plotName;
            var roomNumber=data.field.roomNumber;
            var payName=data.field.payName;
            var normName=data.field.normName;
            var price=data.field.price;
            var area=data.field.area;
            var closeEnd=data.field.closeEnd;
            var riqi=data.field.riqi;
            var money2=data.field.money2;
            if(ruleId!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/RuleServlet",
                    data:{
                        "action":"update",
                        "ruleId":ruleId,
                        "plotName":plotName,
                        "roomNumber":roomNumber,
                        "payName":payName,
                        "normName":normName,
                        "price":price,
                        "area":area,
                        "closeEnd":closeEnd,
                        "riqi":riqi,
                        "money2":money2
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
                    url:"<%=request.getContextPath()%>/RuleServlet",
                    data:{
                        "action":"add",
                        "ruleId":ruleId,
                        "plotName":plotName,
                        "roomNumber":roomNumber,
                        "payName":payName,
                        "normName":normName,
                        "price":price,
                        "area":area,
                        "closeEnd":closeEnd,
                        "riqi":riqi,
                        "money2":money2
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:2000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                        request.getRequestDispatcher("/shouFei/mReading/mReadingList.jsp").forward(request,response);
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
