<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>收费标准添加</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="normId" required  value="${payNormById.normId}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收费项目：</label>
            <div class="layui-input-block">
                <input type="text" name="payName" required  lay-verify="required" value="${payNormById.payName}" placeholder="" autocomplete="off" class="layui-input">
                <%--<select name="payName" lay-verify="required">--%>
                    <%--<option value="">请选择</option>--%>
                    <%--<c:forEach items="${payNormById}" var="Items">--%>
                        <%--<option value="${Items.payId}">${Items.payName}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">标准名称：</label>
            <div class="layui-input-block">
                <input type="text" name="normName" required  lay-verify="required" value="${payNormById.normName}" placeholder="请输入标准名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">金额计算方式：</label>
            <div class="layui-input-block">
                <input type="text" name="computeMode" required  lay-verify="required" value="${payNormById.computeMode}" placeholder="请输入金额计算方式" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label">单价：</label>
        <div class="layui-input-block">
            <input type="text" name="price"  value="${payNormById.price}"  autocomplete="off" class="layui-input">
        </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">计量方式：</label>
            <div class="layui-input-block">
                <input type="text" name="fillingType"  value="${payNormById.fillingType}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">固定金额：</label>
            <div class="layui-input-block">
                <input type="text" name="closeEnd" value="${payNormById.closeEnd}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">自定义公式：</label>
            <div class="layui-input-block">
                <input type="text" name="customFormula" value="${payNormById.customFormula}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收费周期：</label>
            <div class="layui-input-block">
                <input type="text" name="chargeCycle" required lay-verify="number" value="${payNormById.chargeCycle}" placeholder="收费周期" autocomplete="off" class="layui-input">
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
            var normId=data.field.normId;
            var payName=data.field.payName;
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
                        "payName":payName,
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
                        "payName":payName,
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
