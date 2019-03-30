<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/29
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/info.jsp"%>
<head>
    <title>面试信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#"><cite>首页</cite></a>
        <a href="#"><cite>面试信息维护</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<div class="x-body">
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon"></i>添加</button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="offer" title="录用"><i class="layui-icon">✔</i></a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/html" id="isoffer">
        {{ d.offer== false ? '未录用' : '已录用' }}
    </script>
</div>
<script>
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test'
            ,url:'<%=request.getContextPath()%>/InterviewServlet?action=queryPage'
            ,toolbar: '#toolbarDemo'
            ,title: '面试信息表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'interviewId', title:'编号', width:'10%', fixed: 'left', unresize: true, sort: true}
                ,{field:'applyName', title:'面试人', width:'15%'  }
                ,{field:'applyPosition', title:'申请职位', width:'15%',  sort: true}
                ,{field:'departmentName', title:'部门', width:'15%',  sort: true}
                ,{field:'interviewer', title:'面试官', width:'15%'}
                ,{field:'offer', title:'是否录用', width:'15%',sort: true, templet:'#isoffer'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]]
            ,page: true
        });
        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            var data = checkStatus.data;
            switch(obj.event){
                case 'add':
                    layer.open({
                        title: '添加信息',
                        type: 2,
                        closeBtn: 1, //不显示关闭按钮
                        area: ['1000px', '700px'],
                        offset: 'auto', //右下角弹出
                        anim: 2,
                        content: '<%=request.getContextPath()%>/personnel/background/interview/interviewAdd.jsp'
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
                        url:"<%=request.getContextPath()%>/InterviewServlet",
                        data:"action=delete&interviewId="+data.interviewId,
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
            } else if (obj.event === 'offer') {
                layer.confirm('确认录用吗？', function (index) {
                    //发异步修改状态
                    $.ajax({
                        type: "post",
                        url: "<%=request.getContextPath()%>/InterviewServlet",
                        data: {
                            action: "addOffer",
                            interviewId: data.interviewId
                        },
                        success: function (msg) {
                            if (msg == 1) {
                                layer.alert("修改成功", {icon: 6});
                            } else {
                                layer.msg("修改失败 已被删除或不存在", {icon: 2, time: 1000});
                            }
                            setTimeout("location.reload()", 1000)
                        }
                    });
                });
            }
        });
    });
</script>
</body>