<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commons/info.jsp"%>
<html>
<head>
    <title>区域管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#"><cite>首页</cite></a>
        <a><cite>区域管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="tab" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-danger"  lay-event="deleteAll"><i class="layui-icon"></i>批量删除</button>
            <button class="layui-btn"  lay-event="toadd"><i class="layui-icon"></i>添加</button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
</div>
<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#tab'
            // Servlet 返回一个json字符串
            ,url:'<%=request.getContextPath()%>/AreaServlet?action=query'
            ,toolbar: '#toolbarDemo'
            ,title: '区域表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'areaId', title:'ID', width:'20%', fixed: 'left', unresize: true, sort: true}
                ,{field:'areaName', title:'区域', width:'60%'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]]
            ,page: true
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'deleteAll':
                    var data = checkStatus.data;
                    if(data==""){
                        layer.msg('请至少选择1条数据');
                        return;
                    }
                    var ids="";
                    for(var i=0;i<data.length;i++){
                        ids+=data[i].areaId
                        ids+=","
                    }
                    layer.confirm('确认要删除这些信息吗？',function(index) {
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/AreaServlet",
                            data: "action=deleteAll&ids=" + ids,
                            success: function (msg) {
                                if (msg > 0) {
                                    //捉到所有被选中的，发异步进行删除
                                    layer.msg('成功删除' + msg + '条数据', {icon: 1})// 没有显示提示信息
                                } else {
                                    layer.msg('已删除或不存在!', {icon: 2, time: 1000});
                                }
                                location.reload();
                            }
                        });

                    });
                    break;
                case 'toadd':
                    //iframe窗
                    layer.open({
                        type: 2,
                        title: "添加信息",
                        closeBtn: 1, //不显示关闭按钮
                        shade: [0],
                        area: ['620px', '540px'],
                        offset: 'auto', //右下角弹出
                        anim: 2,
                        content: ['areaAdd.jsp', 'no'] //iframe的url，no代表不显示滚动条
                    });
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
                        url:"<%=request.getContextPath()%>/AreaServlet",
                        data:"action=delete&areaId="+data.areaId,
                        success:function(msg){
                            /*
                               删除分类时，可以直接删除吗？不可以，因为分类下可能有信息
                            */
                            var rc = eval("("+msg+")");
                            if(rc.code=="2003"){
                                layer.msg(rc.message,{icon:2,time:2000});
                            }else{
                                //发异步删除数据
                                obj.del();
                                layer.msg(rc.message,{icon:1,time:1000});
                            }
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2,
                    title: "修改信息",
                    closeBtn: 1, //不显示关闭按钮
                    shade: [0],
                    area: ['620px', '540px'],
                    offset: 'auto', //右下角弹出
                    anim: 2,
                    content: ['<%=request.getContextPath()%>/AreaServlet?action=queryOne&id='+data.areaId, 'no'], //iframe的url，no代表不显示滚动条
                    end: function(){ //此处用于演示 关闭之后执行
                    }
                });
            }
        });
    });
</script>
</body>
</html>
