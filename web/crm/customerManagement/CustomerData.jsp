<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../info.jsp"%>
<html>
<head>
    <title>物业管理系统</title>
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#"><cite>首页</cite></a>
        <a><cite>客户资料</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="tab" lay-filter="test"></table>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-danger"  lay-event="deleteAll"><i class="layui-icon"></i>批量删除</button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
</div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#tab'
            // Servlet 返回一个json字符串
            ,url:'<%=request.getContextPath()%>/CustomerServlet?action=query'
            ,toolbar: '#toolbarDemo'
            ,title: '客户信息表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'客户资料编号', width:'10%', fixed: 'left', unresize: true, sort: true}
                ,{field:'name', title:'客户名字', width:'10%'}
                ,{field:'customerNature', title:'客户性质', width:'10%'}
                ,{field:'phone', title:'联系方式', width:'10%'}
                ,{field:'idCard', title:'身份证', width:'10%'}
                ,{field:'car', title:'私家车信息', width:'10%'}
                ,{field:'pet', title:'宠物信息', width:'10%'}
                ,{field:'extraDemand', title:'其他需求', width:'10%'}
                ,{field:'addr', title:'居住地址', width:'10%'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]]
            ,page: true
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            if(obj.event=='deleteAll'){
                var data = checkStatus.data;
                if(data==""){
                    layer.msg('请至少选择1条数据');
                    return;
                }
                var ids="";
                for(var i=0;i<data.length;i++){
                    ids+=data[i].newsId
                    ids+=","
                }
                layer.confirm('确认要删除这些信息吗？',function(index) {
                    $.ajax({
                        type: "post",
                        url: "<%=request.getContextPath()%>/NewsServlet",
                        data: "action=deleteAll&ids=" + ids,
                        success: function (msg) {
                            if (msg > 0) {
                                //捉到所有被选中的，发异步进行删除
                                layer.msg('成功删除' + msg + '条数据', {icon: 1})
                            } else {
                                layer.msg('已删除或不存在!', {icon: 2, time: 1000});
                            }
                            location.reload();
                        }
                    });

                });
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
                        url:"<%=request.getContextPath()%>/NewsServlet",
                        data:"action=delete&newsId="+data.newsId,
                        success:function(msg){
                            obj.del();
                            if(msg==0){
                                layer.msg("文章已被删除或不存在",{icon:2,time:2000});
                            }else{
                                layer.msg("文章删除成功",{icon:1,time:1000});
                            }
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2,
                    title: "修改信息",
                    closeBtn: 1, //不显示关闭按钮
                    area: ['1000px', '700px'],
                    offset: 'auto', //右下角弹出
                    anim: 2,
                    content: ['<%=request.getContextPath()%>/NewsServlet?action=queryOneBack&id='+data.newsId] //iframe的url，no代表不显示滚动条

                });
            }
        });
    });
</script>

</html>