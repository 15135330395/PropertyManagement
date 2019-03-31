<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../commons/info.jsp"%>
<html>
<head>
    <title>收款表添加</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="rid" required  value="${receiptById.pid}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门：</label>
            <div class="layui-input-block">
                <input type="text" name="department"  value="${receiptById.department}" placeholder="请输入payId" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职员ID：</label>
            <div class="layui-input-block">
                <input type="text" name="staffId"  value="${receiptById.staffId}" placeholder="请输入标准名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职员姓名：</label>
            <div class="layui-input-block">
                <input type="text" name="staffName"  value="${receiptById.staffName}" placeholder="请输入金额计算方式" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收款金额：</label>
            <div class="layui-input-block">
                <input type="text" name="monery"  value="${receiptById.monery}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收款项目：</label>
            <div class="layui-input-block">
                <input type="text" name="payName"  value="${receiptById.payName}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收款员：</label>
            <div class="layui-input-block">
                <input type="text" name="transactor" value="${receiptById.transactor}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">时间：</label>
            <div class="layui-input-block">
                <input type="text" name="shijian" value="${receiptById.shijian}"  autocomplete="off" class="layui-input">
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
            var rid=data.field.rid;
            var department=data.field.department;
            var staffId=data.field.staffId;
            var staffName=data.field.staffName;
            var monery=data.field.monery;
            var payName=data.field.payName;
            var transactor=data.field.transactor;
            var shijian=data.field.shijian;
            if(pid!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/ReceiptServlet",
                    data:{
                        "action":"update",
                        "rid":rid,
                        "department":department,
                        "staffId":staffId,
                        "staffName":staffName,
                        "monery":monery,
                        "payName":payName,
                        "transactor":transactor,
                        "shijian":shijian
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
                    url:"<%=request.getContextPath()%>/ReceiptServlet",
                    data:{
                        "action":"add",
                        "rid":rid,
                        "department":department,
                        "staffId":staffId,
                        "staffName":staffName,
                        "monery":monery,
                        "payName":payName,
                        "transactor":transactor,
                        "shijian":shijian
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:2000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                        request.getRequestDispatcher("/shouFei/receipt/receiptAdd.jsp").forward(request,response);
                    }
                })
            }
            return false;
        });
    });
</script>
</body>
</html>
