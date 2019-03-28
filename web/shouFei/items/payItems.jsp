<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/3/26
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commons/info.jsp"%>
<html>
<head>
    <title>收费设置</title>
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
        <a><cite>收费设置</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="tab" lay-filter="test"></table>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn"  lay-event="toadd"><i class="layui-icon"> </i>添加收费项目</button>
        </div>
    </script>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-xs" lay-event="querynorm">显示收费标准</a>
    </script>
</div>
<script>
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#tab'
            // Servlet 返回一个json字符串
            ,url:'<%=request.getContextPath()%>/PayItemsServlet?action=query'
            ,toolbar: '#toolbarDemo'
            ,title: '收费项目表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'payId', title:'payId',width:'10%',fixed: 'left',unresize: true, sort: true}
                ,{field:'payName', title:'收费项目名称', width:'10%'}
                ,{field:'payType', title:'收费类别', width:'15%'}
                ,{field:'billingAccuracy', title:'计费精度', width:'10%'}
                ,{field:'note', title:'备注', width:'35%'}
                ,{fixed: 'right', title:'操作', width:'20%',toolbar: '#barDemo'}
            ]]
            ,page: true
        });

//头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
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
                        content: ['<%=request.getContextPath()%>/shouFei/items/payItemsAdd.jsp', 'no'], //iframe的url，no代表不显示滚动条
                        // end: function(){ //此处用于演示 关闭之后执行
                        //     alert(123)
                        // }
                    });
                    break;
            };
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            // console.log(obj)
            //alert(data.payId)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    layer.close(index);
                    $.ajax({
                        type:"post",
                        url:"<%=request.getContextPath()%>/PayItemsServlet",
                        data:"action=delete&payId="+data.payId,
                        success:function(msg){
                           // console.log(msg);
                            //alert(msg)
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
                    area: ['700px', '650px'],
                    offset: 'auto', //右下角弹出
                    anim: 2,
                    content: ['<%=request.getContextPath()%>/PayItemsServlet?action=queryOne&id='+data.payId, 'no'], //iframe的url，no代表不显示滚动条
                });
            }
            //查看收费标准
            else if(obj.event === 'querynorm'){
                layer.open({
                    type: 2,
                    title: "收费标准",
                    closeBtn: 1, //不显示关闭按钮
                    shade: [0],
                    area: ['1500px', '900px'],
                    offset: 'auto', //右下角弹出
                    anim: 2,
                    content: ['<%=request.getContextPath()%>/PayItemsServlet?action=queryList&id='+data.payId, 'no'], //iframe的url，no代表不显示滚动条
                });

            }
        });
    });
</script>

</body>
</html>
