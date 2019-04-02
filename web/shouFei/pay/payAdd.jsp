<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../commons/info.jsp"%>
<html>
<head>
    <title>付款表添加</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="hidden" name="pid" required  value="${payById.pid}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门：</label>
            <div class="layui-input-block">
                <input type="text" name="department"  value="${payById.department}" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职员ID：</label>
            <div class="layui-input-block">
                <input type="text" name="staffId"  value="${payById.staffId}" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职员姓名：</label>
            <div class="layui-input-block">
                <input type="text" name="staffName"  value="${payById.staffName}" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">付款金额：</label>
            <div class="layui-input-block">
                <input type="text" name="monery"  value="${payById.monery}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">付款事由：</label>
            <div class="layui-input-block">
                <input type="text" name="reason"  value="${payById.reason}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">办理员：</label>
            <div class="layui-input-block">
                <input type="text" name="transactor" value="${payById.transactor}"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">时间：</label>
            <div class="layui-input-block">
                <input type="text" name="shijian" value="${payById.shijian}"  autocomplete="off" class="layui-input" id="test1">
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
            var pid=data.field.pid;
            var department=data.field.department;
            var staffId=data.field.staffId;
            var staffName=data.field.staffName;
            var monery=data.field.monery;
            var reason=data.field.reason;
            var transactor=data.field.transactor;
            var shijian=data.field.shijian;
            if(pid!=""){
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/PayServlet",
                    data:{
                        "action":"update",
                        "pid":pid,
                        "department":department,
                        "staffId":staffId,
                        "staffName":staffName,
                        "monery":monery,
                        "reason":reason,
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
                    url:"<%=request.getContextPath()%>/PayServlet",
                    data:{
                        "action":"add",
                        "pid":pid,
                        "department":department,
                        "staffId":staffId,
                        "staffName":staffName,
                        "monery":monery,
                        "reason":reason,
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
                        request.getRequestDispatcher("/shouFei/pay/payAdd.jsp").forward(request,response);
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
