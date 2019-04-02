<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-28
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../info.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>物业管理系统</title>
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
        <a><cite>入伙登记</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <xblock>
        <button name="name" id="name" class="layui-btn" onclick="x_admin_show('添加入伙信息','<%=request.getContextPath()%>/AddrServlet?action=RqueryArea')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${pageBean.count} 条</span>
    </xblock>
    <%--搜索框--%>
    <div class="layui-row" style="float: right">
        <div class="layui-col-md12 x-so">
            <input type="text" name="staffId" placeholder="请输入住址" autocomplete="off" class="layui-input">
            <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>

        </div>
    </div>
    <%--搜索框--%>
    <table class="layui-table">
        <thead>
        <tr>
            <th>入伙登记编号</th>
            <th>客户姓名</th>
            <th>开始时间</th>
            <th>联系方式</th>
            <th>居住地址</th>
            <th>验收情况</th>
            <th>钥匙发放情况</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerRegisterList}" var="crList">
            <tr>
                <td>${crList.id}</td>
                <td>${crList.name}</td>
                <td>${crList.startTime}</td>
                <td>${crList.phone}</td>
                <td>${crList.addr}</td>
                <td>${crList.checkAccept}</td>
                <td>${crList.keyState}</td>
                <td class="td-manage">
                    <a title="查看"  onclick="x_admin_show('编辑','<%=request.getContextPath()%>/CustomerRegisterServelt?action=queryOne&addr=${crList.addr}')" href="javascript:;">
                        <i class="layui-icon">&#xe63c;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="<%=request.getContextPath()%>/CustomerRegisterServelt?action=query&pageIndex=1">&lt;&lt;</a>
            <c:forEach var="i" begin="1" end="${pageBean.pages}" step="1">
                <c:if test="${i==pageBean.pageIndex}">
                    <span class="current">${i}</span>
                </c:if>
                <c:if test="${i!=pageBean.pageIndex}">
                    <a class="num" href="<%=request.getContextPath()%>/CustomerRegisterServelt?action=query&pageIndex=${i}">${i}</a>
                </c:if>
            </c:forEach>
            <a class="next" href="<%=request.getContextPath()%>/CustomerRegisterServelt?action=query&pageIndex=${pageBean.pages}">&gt;&gt;</a>
        </div>
    </div>

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

        //搜索监听器
        layui.$('#search').on('click', function () {
            var val = layui.$("*[name='staffId']").val();
            if (val == "") {
                layer.msg('请输入住址');
                return;
            }
            layer.open({
                title: '查询',
                type: 2,
                skin: 'layui-layer-rim', // 加上边框
                area: ['1000px', '700px'], // 宽高
                content: '<%=request.getContextPath()%>/CustomerRegisterServelt?action=findByaddr&addr='+val
            });
        });
        //搜索监听器
    });
</script>
</body>

</html>