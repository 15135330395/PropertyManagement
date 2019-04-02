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
    <title>库存查询</title>
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
          <cite>库存查询</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="x-body">
        <a class="layui-btn layui-btn-xs" onclick="earlyWarning()">库存预警</a>
        <input value="" placeholder="物品名称" id="goodsName" style="margin-left: 750px">
        <a class="layui-btn layui-btn-xs" onclick="findOne()" style="float: right">盘点</a>
        <table class="layui-hide" id="tab" lay-filter="test"></table>
        <%--<script type="text/html" id="toolbarDemo">--%>
        <%--<div class="layui-btn-container">--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>--%>
        <%--</div>--%>
        <%--</script>--%>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="edit">出库</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>
</div>
    <script>

        //查询库存不足的物品，预警
        function earlyWarning() {
            layer.open({
                title: this.text,
                type: 2,
                skin: 'layui-layer-rim', //加上边框
                area: [window.screen.width/1.5 + 'px', window.screen.height /1.6 + 'px'], //宽高
                maxmin: true, //开启最大化最小化按钮
                content: "EarlyWarning.jsp",
                success: function (layero, index) {
                    // 获取子页面的iframe
                    var iframe = window['layui-layer-iframe' + index];
                    // 向子页面的全局函数child传参
                    iframe.child(data);
                }
            })
        }

        //盘点某一种物品库存
        function findOne(){
            goodsName=document.getElementById("goodsName").value;
            layer.open({
                title: this.text,
                type: 2,
                skin: 'layui-layer-rim', //加上边框
                area: [window.screen.width/1.5 + 'px', window.screen.height /1.6 + 'px'], //宽高
                maxmin: true, //开启最大化最小化按钮
                content: "Check.jsp",
                success: function (layero, index) {
                    // 获取子页面的iframe
                    var iframe = window['layui-layer-iframe' + index];
                    // 向子页面的全局函数child传参
                    iframe.child(goodsName);
                }
            })
        }

        // //执行入库
        // function add(){
        //     layer.open({
        //         title: this.text,
        //         type: 2,
        //         skin: 'layui-layer-rim', //加上边框
        //         area: [window.screen.width/1.5 + 'px', window.screen.height /1.6 + 'px'], //宽高
        //         maxmin: true, //开启最大化最小化按钮
        //         content: "GoodsAdd.jsp",
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
                ,url:'<%=request.getContextPath()%>/GoodsServlet?action=findAll'
                ,toolbar: '#toolbarDemao'
                ,title: '库存查询'
                ,cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    ,{field:'id', title:'仓库ID', width:'20%', fixed: 'left', sort: true}
                    ,{field:'goodName', title:'物品名称', width:'30%',}
                    ,{field:'numbers', title:'库存', width:'32%', sort: true}
                    ,{field:'right', title:'操作',toolbar:'#barDemo',width:150}
                ]]
                ,page: true
                ,count:'${jsonObject.data.length}'
                ,limit:'10'
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
                    var id=data.id;
                    var goodName=data.goodName;
                    layer.confirm('真的删除么', function(index){
                        layer.close(index);
                        $.ajax({
                            type:"post",
                            url:"<%=request.getContextPath()%>/GoodsServlet",
                            data:{
                                "action":"delete",
                                "id":id,
                                "goodName":goodName
                            },
                            success:function (msg) {
                                if(msg=="1"){
                                    obj.del();
                                    layer.msg("删除成功！",{icon:1,time:1000});
                                }else{
                                    layer.msg("删除失败！物品不存在或已被删除！",{icon:2,time:1000});
                                }
                            }
                        });
                    });
                } else if(obj.event === 'edit'){
                    // layer.prompt({
                    //     formType: 2
                    //     ,value: data.email
                    // }, function(value, index){
                    //     obj.update({
                    //         email: value
                    //     });
                    //     layer.close(index);
                    // });
                   <%--$.ajax({--%>
                    <%--type:"get",--%>
                    <%--url:"<%=request.getContextPath()%>/NewsTypeServlet",--%>
                    <%--data:"action=queryOne&typeId="+data.typeId,--%>
                    <%--success:function (msg) {--%>
                    <%--var newsType = eval("("+msg+")");--%>
                    <%--var id=newsType.typeId;--%>
                    <%--var typeName = newsType.typeName;--%>
                    <%--alert(newsType.typeId)--%>
                    <%--if(newsType!=null){--%>
                    <%----%>
                    <%--}--%>
                    <%--});--%>
                    <%--&lt;%&ndash;}--%>
                    layer.open({
                        title: this.text,
                        type: 2,
                        skin: 'layui-layer-rim', //加上边框
                        area: [window.screen.width / 1.75 + 'px', window.screen.height / 1.75 + 'px'], //宽高
                        maxmin: true, //开启最大化最小化按钮
                        content: "GoodsOutStorage.jsp",
                        success: function (layero, index) {
                            // 获取子页面的iframe
                            var iframe = window['layui-layer-iframe' + index];
                            // 向子页面的全局函数child传参
                            iframe.child(data);
                        }
                    })
                }else{
                    layer.msg("请至少选择一行",{icon:1,time:1000});
                }
            });
        });
    </script>
</body>
</html>
