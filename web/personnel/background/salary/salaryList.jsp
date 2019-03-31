<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/31
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>薪资信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />

</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#"><cite>首页</cite></a>
        <a href="#"><cite>薪资信息维护</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<div class="x-body">
    <div class="layui-row">
        <div class="layui-col-md12 x-so">
            <input type="text" name="staffId" placeholder="请输入工号" autocomplete="off" class="layui-input">
            <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>
        </div>
    </div>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delAll"><i class="layui-icon"></i>批量删除</button>
            <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon"></i>添加</button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/html" id="pay1">
        {{ d.pay==0?'2000':'3000' }}
    </script>
</div>
<script>
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test'
            ,url:'<%=request.getContextPath()%>/SalaryServlet?action=queryPage'
            ,toolbar: '#toolbarDemo'
            ,title: '薪资信息表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'salaryId', title:'编号', width:'7%', fixed: 'left', unresize: true, sort: true}
                ,{field:'staffId', title:'工号', width:'7%', fixed: 'left', unresize: true, sort: true}
                ,{field:'staffName', title:'员工姓名', width:'8%',  sort: true}
                ,{field:'basicSalary', title:'基本工资', width:'9%',  sort: true}
                ,{field:'bonuses', title:'绩效奖金', width:'9%',  sort: true}
                ,{field:'insurance', title:'五险一金', width:'9%', sort: true}
                ,{field:'ondutyPay', title:'加班费', width:'8%'}
                ,{field:'abnormalPay', title:'旷工费', width:'8%'}
                ,{field:'leavePay', title:'请假费', width:'8%'}
                ,{field:'actualAttendance', title:'考勤', width:'8%', sort: true}
                ,{field:'pay', title:'实发工资', width:'8%', sort: true,temple:'#pay1'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]]
            ,page: true
        });
        layui.$('#search').on('click', function () {
            var val = layui.$("*[name='staffId']").val();
            if (val == "") {
                layer.msg('请输入ID');
                return;
            }
            layer.open({
                title: '查询',
                type: 2,
                skin: 'layui-layer-rim', // 加上边框
                area: ['1000px', '700px'], // 宽高
                content: '<%=request.getContextPath()%>/SalaryServlet?action=queryDetail&staffId=' + val
            });
        });
        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            var data = checkStatus.data;
            switch(obj.event){
                case 'delAll':
                    data=checkStatus.data
                    if(data==""){
                        layer.msg('请至少选择1条数据',{icon:2});
                        return;
                    }
                    var ids="";
                    if(data.length>0){
                        for (var i=0;i<data.length;i++) {
                            ids+=data[i].salaryId+","
                        }
                    }
                    layer.confirm('确认要删除这些信息吗？',function(index){
                        $.ajax({
                            type:"post",
                            url:"<%=request.getContextPath()%>/SalaryServlet",
                            data:"action=deleteAll&ids="+ids,
                            success:function (msg) {
                                $(".layui-form-checked").not('.header').parents('tr').remove();
                                if(msg>0){
                                    //捉到所有被选中的，发异步进行删除
                                    layer.msg('成功删除'+msg+'条数据', {icon: 1,time:1000});
                                }else {
                                    layer.msg('已删除或不存在', {icon: 1});
                                }
                                setTimeout("location.reload()",1000)
                            }
                        })
                    });
                    break;
                case 'add':
                    layer.open({
                        title: '添加信息',
                        type: 2,
                        closeBtn: 1, //不显示关闭按钮
                        area: ['1000px', '700px'],
                        offset: 'auto', //右下角弹出
                        anim: 2,
                        content: '<%=request.getContextPath()%>/SalaryServlet?action=queryOne'
                    })
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    layer.close(index);
                    $.ajax({
                        type:"post",
                        url:"<%=request.getContextPath()%>/SalaryServlet",
                        data:"action=delete&salaryId="+data.salaryId,
                        success:function (msg) {
                            obj.del();
                            if(msg==1){
                                layer.msg('删除成功',{icon:1,time:2000});
                            }else {
                                layer.msg('已删除或不存在',{icon:2,time:2000});
                            }
                        }
                    })
                });
            }else if(obj.event === 'edit'){
                layer.open({
                    title: '信息修改',
                    type: 2,
                    closeBtn: 1, //不显示关闭按钮
                    area: ['1000px', '700px'],
                    offset: 'auto', //右下角弹出
                    anim: 2,
                    content: '<%=request.getContextPath()%>/SalaryServlet?action=toEdit&salaryId='+data.salaryId
                })
            }
        });
    });
</script>
</body>
