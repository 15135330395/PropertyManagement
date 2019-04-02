<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../background/commons/info.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>时间段查询</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">仓储管理</a>
        <a>
          <cite>时间段查询</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>出库仓库ID</th>
            <th>入库仓库ID</th>
            <th>物品名称</th>
            <th>数量</th>
            <th>日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="list">
            <tr>
                <td>
                    <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${link.linkId}'><i class="layui-icon">&#xe605;</i></div>
                </td>
                <td>${list.outStorage}</td>
                <td>${list.inStorage}</td>
                <td>${list.goodName}</td>
                <td>${list.numbers}</td>
                <td>${list.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script>
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

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){

            if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

            }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
            }
        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){

            $.ajax(
                type:"post",
                url:"<%=request.getContextPath()%>/LinkServlet",
                data:"action=delete&kid="+id,
                success:function (msg) {
                //发异步删除数据
                $(obj).parents("tr").remove();
                if(msg==1){
                    layer.msg('删除成功!',{icon:1,time:1000});
                }else{
                    layer.msg('已删除或链接不存在!',{icon:1,time:1000});
                }
            }
        })
    });
    }

    //批量删除
    function delAll (argument) {
        var data = tableCheck.getData();
        if(data==""){
            layer.msg("请至少选择一条数据");
            return;
        }
        layer.confirm("确认要删除这些信息吗？",function (index) {
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/LinkServlet",
                data:"action=deleteAll&ids="+data,
                success:function (msg) {
                    //发异步删除数据
                    $(obj).parents("tr").remove();
                    if(msg>0){
                        layer.msg('成功删除'+msg+'条数据!',{icon:1});
                    }else{
                        layer.msg('已删除或链接不存在!',{icon:1,time:1000});
                    }
                    //捉到所有被选中的，发异步进行删除
                    $(".layui-form-checked").not('.header').parents('tr').remove();
                }
            })
        })


    }
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>