<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/3/26
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commons/info.jsp"%>
<html>
<head>
    <title>收费项目添加</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="payItemsById" required  value="${payItemsById.payId}"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">收费项目名称：</label>
            <div class="layui-input-block">
                <input type="text" name="payName" required  lay-verify="required" value="${payItemsById.payName}" placeholder="请输入收费项目名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收费项目类别：</label>
            <div class="layui-input-block">
                <input type="text" name="payType" required
                       lay-verify="required" value="${payItemsById.payType}"
                       placeholder="请输入收费项目类别" autocomplete="off" class="layui-input">
                <%--<select name="payType" lay-verify="required">--%>
                    <%--<option>请输入收费项目类别</option>--%>
                    <%--<option>周期性</option>--%>
                    <%--<option>临时性</option>--%>
                    <%--<option>押金性</option>--%>
                    <%--<c:forEach items="${itemsList}" var="items">--%>
                        <%--<option value="${items.id}">${items.payType}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">计费精度：</label>
            <div class="layui-input-block">
                <input type="text" name="billingAccuracy"
                       required  lay-verify="required" value="${payItemsById.billingAccuracy}"
                       placeholder="请输入计费精度" autocomplete="off" class="layui-input">
                <%--<select name="billingAccuracy" lay-verify="required">--%>
                    <%--<option>请输入计费精度</option>--%>
                    <%--<option>元</option>--%>
                    <%--<option>角</option>--%>
                    <%--<option>分</option>--%>
                    <%--<c:forEach items="${itemsList}" var="items">--%>
                        <%--<option value="${items.id}">${items.billingAccuracy}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注：</label>
            <div class="layui-input-block">
                <input type="text" name="note"  value="${payItemsById.note}" placeholder="备注" autocomplete="off" class="layui-input">
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
           // layer.msg(JSON.stringify(data.field)+"==="+CKEDITOR.instances.content.getData());
            alert(data.field.payId)
            var payId = data.field.payId;
            var payName = data.field.payName;
            var payType = data.field.payType;
            var billingAccuracy = data.field.billingAccuracy;
            var note = data.field.note;

            if(payId!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/PayItemsServlet",
                    data:{
                        "action":"update",
                        "payId":payId,
                        "payName":payName,
                        "payType":payType,
                        "billingAccuracy":billingAccuracy,
                        "note":note
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
                    url:"<%=request.getContextPath()%>/PayItemsServlet",
                    data:{
                        "action":"add",
                        "payId":payId,
                        "payName":payName,
                        "payType":payType,
                        "billingAccuracy":billingAccuracy,
                        "note":note
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
