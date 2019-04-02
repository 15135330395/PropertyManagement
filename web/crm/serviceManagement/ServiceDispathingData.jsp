
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
<%--搜索框--%>
<div class="layui-row">
    <div class="layui-col-md12 x-so">
        <input type="text" name="staffId" placeholder="请输入客户姓名" autocomplete="off" class="layui-input">
        <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>
        <span class="x-right" style="line-height:40px">共有数据：${pageBean.count} 条</span>
    </div>
</div>
<%--搜索框--%>
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
        <c:forEach items="${serviceDispathings}" var="sdlist">
            <tr>
                <td>${sdlist.sdId}</td>
                <td>${sdlist.cname}</td>
                <td>${sdlist.addr}</td>
                <td>${sdlist.phone}</td>
                <td>${sdlist.things}</td>
                <td>${sdlist.workerName}</td>
                <td>${sdlist.workerId}</td>
                <td>${sdlist.startTime}</td>
                <td>${sdlist.endTime}</td>
                <td>${sdlist.wphone}</td>
                <td>${sdlist.customerCheck}</td>
                <td>${sdlist.material}</td>
                <td>${sdlist.serviceCost}</td>
                <td>${sdlist.materialCost}</td>
                <td>${sdlist.otherService}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="<%=request.getContextPath()%>/ServiceDispathingServelt?action=query&pageIndex=${pageBean.pages}">&lt;&lt;</a>
            <c:forEach var="i" begin="1" end="${pageBean.pages}" step="1">
                <c:if test="${i==pageBean.pageIndex}">
                    <span class="current">${i}</span>
                </c:if>
                <c:if test="${i!=pageBean.pageIndex}">
                    <a class="num" href="<%=request.getContextPath()%>/ServiceDispathingServelt?action=query&pageIndex=${i}">${i}</a>
                </c:if>
            </c:forEach>
            <a class="next" href="<%=request.getContextPath()%>/ServiceDispathingServelt?action=query&pageIndex=${pageBean.pages}">&gt;&gt;</a>
        </div>
    </div>
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