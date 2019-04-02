<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/3/27
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>采购申请</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%@include file="../../background/commons/info.jsp"%>
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">仓储管理</a>
        <a>
          <cite>采购申请</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <%--<a class="layui-btn layui-btn-xs" onclick="add()" style="display:block; height: 30px;width: 150px;margin-left:42%;border-radius: 10px;">填写采购申请</a>--%>
    <%--<div class="layui-row">--%>
        <%--<form class="layui-form layui-col-md12 x-so layui-form-pane">--%>
            <%--<input class="layui-input" placeholder="开始日" name="start" id="start">--%>
            <%--<input class="layui-input" placeholder="截止日" name="end" id="end">--%>
            <%--<button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>查询</button>--%>
        <%--</form>--%>
    <%--</div>--%>
        <table class="layui-hide" id="tab" lay-filter="test"></table>

        <%--<script type="text/html" id="toolbarDemo">--%>
        <%--<div class="layui-btn-container">--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>--%>
        <%--</div>--%>
        <%--</script>--%>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
        </script>
    </div>
    <script>

        // //填写采购申请
        // function add(){
        //     layer.open({
        //         title: this.text,
        //         type: 2,
        //         skin: 'layui-layer-rim', //加上边框
        //         area: [window.screen.width/1.25 + 'px', window.screen.height /1.6 + 'px'], //宽高
        //         maxmin: true, //开启最大化最小化按钮
        //         content: "PurchaseDeliverAdd.jsp",
        //         success: function (layero, index) {
        //             // 获取子页面的iframe
        //             var iframe = window['layui-layer-iframe' + index];
        //             // 向子页面的全局函数child传参
        //             iframe.child(arry);
        //         }
        //     })
        // }

        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#end' //指定元素
            });
        });

        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#tab'
                //返回一个json字符串
                ,url:'<%=request.getContextPath()%>/PurchaseServlet?action=PurchaseDeliverFindAll'
                ,toolbar: '#toolbarDemao'
                ,title: '采购申请'
                ,cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    ,{field:'id', title:'仓库ID', width:'20%', fixed: 'left', sort: true}
                    ,{field:'goodName', title:'物品名称', width:'20%',}
                    ,{field:'supplier1Name', title:'供应商一', width:'20%',}
                    ,{field:'supplier1Price', title:'单价（元）', width:'10%',}
                    ,{field:'supplier1Numbers', title:'数量', width:'10%',}
                    ,{field:'supplier2Name', title:'供应商二', width:'20%',}
                    ,{field:'supplier2Price', title:'单价（元）', width:'10%',}
                    ,{field:'supplier2Numbers', title:'数量', width:'10%',}
                    ,{field:'total', title:'总计（元）', width:'14%',}
                    ,{field:'right', title:'操作',toolbar:'#barDemo',width:150}
                ]]
                ,page: true
            });

            //头工具栏事件
            table.on('toolbar(test)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                switch(obj.event){
                    case 'getCheckData':
                        var data = checkStatus.data;
                        layer.alert(JSON.stringify(data));
                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：'+ data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选': '未全选');
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
                            url:"<%=request.getContextPath()%>/NewsTypeServlet",
                            data:"action=delete&typeId="+data.typeId,
                            success:function (msg) {
                                var rc = eval("("+msg+")");
                                if(rc.code=="2003"){
                                    layer.msg(rc.message,{icon:2,time:1000});
                                }else{
                                    obj.del();
                                    layer.msg(rc.message,{icon:1,time:1000});
                                }
                            }
                        });
                    });
                } else if(obj.event === 'edit'){
                    $.ajax({
                        type:"post",
                        url:"<%=request.getContextPath()%>/PurchaseServlet",
                        data:"action=PurchaseDeliverFindOne&id="+data.id+"&goodName="+data.goodName,
                        success:function (msg) {
                            var purchaseDeliver = eval("(" + msg + ")");
                            if (purchaseDeliver != null) {
                                layer.open({
                                    title: this.text,
                                    type: 2,
                                    skin: 'layui-layer-rim', //加上边框
                                    area: [window.screen.width / 1.25 + 'px', window.screen.height / 1.6 + 'px'], //宽高
                                    maxmin: true, //开启最大化最小化按钮
                                    content: "PurchaseDeliverEdit.jsp",
                                    success: function (layero, index) {
                                        // 获取子页面的iframe
                                        var iframe = window['layui-layer-iframe' + index];
                                        // 向子页面的全局函数child传参
                                        iframe.child(purchaseDeliver);
                                    }
                                })
                            }
                        }
                    });
                }else{
                    layer.msg("请至少选择一行",{icon:1,time:1000});
                }
            });
        });
    </script>
</body>
</html>
