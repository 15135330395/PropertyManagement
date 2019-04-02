<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
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
        <a><cite>二次装修申请</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<div class="x-body">
        <%--搜索框--%>
        <div class="layui-row" style="float: right">
            <div class="layui-col-md12 x-so">
                <input type="text" name="staffId" placeholder="请输入客户姓名" autocomplete="off" class="layui-input">
                <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>
            </div>
        </div>
        <%--搜索框--%>
    <table class="layui-table">
        <thead>
        <tr>
            <th>申请编号</th>
            <th>客户姓名</th>
            <th>居住地址</th>
            <th>联系方式</th>
            <th>申请时间</th>
            <th>状态</th>
            <th>二次装修内容</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${decorateApplies}" var="dalist">
            <tr>
                <td>${dalist.id}</td>
                <td>${dalist.name}</td>
                <td>${dalist.addr}</td>
                <td>${dalist.phone}</td>
                <td>${dalist.applyTime}</td>
                <td>${dalist.state}</td>
                <td>${dalist.secondaryDecorate}</td>
                <td class="td-manage">
                    <c:if test="${dalist.state != '已处理'}">
                    <a title="下维修工单"
                       onclick="x_admin_show('下维修工单','<%=request.getContextPath()%>/DecorateApplyServelt?action=queryDecorate&id=${dalist.id}')"
                       href="javascript:;">
                        </c:if>
                        <i class="layui-icon">&#xe63c;</i>
                    </a>

                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="<%=request.getContextPath()%>/DecorateApplyServelt?action=query&pageIndex=${pageBean.pages}">&lt;&lt;</a>
            <c:forEach var="i" begin="1" end="${pageBean.pages}" step="1">
                <c:if test="${i==pageBean.pageIndex}">
                    <span class="current">${i}</span>
                </c:if>
                <c:if test="${i!=pageBean.pageIndex}">
                    <a class="num" href="<%=request.getContextPath()%>/DecorateApplyServelt?action=query&pageIndex=${i}">${i}</a>
                </c:if>
            </c:forEach>
            <a class="next" href="<%=request.getContextPath()%>/DecorateApplyServelt?action=query&pageIndex=${pageBean.pages}">&gt;&gt;</a>
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
                content: '<%=request.getContextPath()%>/DecorateApplyServelt?action=findByName&name='+val
            });
        });
        //搜索监听器
    });

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: "post",
                url: "<%=request.getContextPath()%>/CustomerServlet",
                data: "action=delete&id=" + id,
                success: function (msg) {
                    //发异步删除数据
                    $(obj).parents("tr").remove();
                    if (msg == 1) {
                        layer.msg('删除成功!', {icon: 1, time: 1000});
                    } else {
                        layer.msg('已删除或不存在!', {icon: 1, time: 1000});
                    }
                }
            })
        });
    }

    function delAll(argument) {

        var data = tableCheck.getData();
        if (data == "") {
            layer.msg('请至少选择1条数据');
            return;
        }
        layer.confirm('确认要删除这些信息吗？', function (index) {
            $.ajax({
                type: "post",
                url: "<%=request.getContextPath()%>/CustomerServlet",
                data: "action=deleteAll&ids=" + data,
                success: function (msg) {
                    if (msg > 0) {
                        //捉到所有被选中的，发异步进行删除
                        layer.msg('成功删除' + msg + '条数据', {icon: 1})
                    } else {
                        layer.msg('已删除或不存在!', {icon: 1, time: 1000});
                    }
                    $(".layui-form-checked").not('.header').parents('tr').remove();
                }
            })
            ;

        });}

</script>
</body>

</html>
