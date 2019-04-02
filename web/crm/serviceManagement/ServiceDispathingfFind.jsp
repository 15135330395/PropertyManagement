<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../info.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>物业管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#"><cite>首页</cite></a>
        <a><cite>派工单</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<table class="layui-table" id="tab">
    <thead>
    <tr>
        <th>派工单编号</th>
        <th>客户名字</th>
        <th>派工地址</th>
        <th>客户联系方式</th>
        <th>派工内容</th>
        <th>工人编号</th>
        <th>工人姓名</th>
        <th>服务开始时间</th>
        <th>服务结束时间</th>
        <th>工人联系电话</th>
        <th>客户验收情况</th>
        <th>材料使用情况</th>
        <th>服务费用</th>
        <th>材料费用</th>
        <th>其他服务</th>
    </tr>
    </thead>
    <tbody id="tb">
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.sdId}</td>
            <td>${list.cname}</td>
            <td>${list.addr}</td>
            <td>${list.phone}</td>
            <td>${list.things}</td>
            <td>${list.workerName}</td>
            <td>${list.workerId}</td>
            <td>${list.startTime}</td>
            <td>${list.endTime}</td>
            <td>${list.wphone}</td>
            <td>${list.customerCheck}</td>
            <td>${list.material}</td>
            <td>${list.serviceCost}</td>
            <td>${list.materialCost}</td>
            <td>${list.otherService}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });

        //搜索监听器
        layui.$('#search').on('click', function () {
            var val = layui.$("*[name='staffId']").val();
            if (val == "") {
                layer.msg('请输入客户姓名');
                return;
            }
            layer.open({
                title: '查询',
                type: 2,
                skin: 'layui-layer-rim', // 加上边框
                area: ['1000px', '700px'], // 宽高
                content: '<%=request.getContextPath()%>/ServiceDispathingServelt?action=queryByname&name=' + val
            });
        });
        //搜索监听器
    });
</script>
</body>
</html>