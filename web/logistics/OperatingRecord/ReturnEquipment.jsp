<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29 0029
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>器材归还表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>

</head>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#">首页</a>
        <a>
          <cite>器材归还管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <div class="layui-col-md12 x-so">
            <input type="text" name="recordId" placeholder="请输入记录编号" autocomplete="off" class="layui-input">
            <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>
        </div>
    </div>

    <table class="layui-hide" id="test" lay-filter="test"></table>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="return">归还</a>
    </script>
    <script type="text/html" id="borrowingTime">
        {{ dateFormat(d.borrowingTime) }}
    </script>
    <script type="text/html" id="returnTime">
        {{ d.returnTime==null? '尚未归还':dateFormat(d.returnTime) }}
    </script>
    <script>
        layui.use('table', function () {
            var table = layui.table;

            table.render({
                elem: '#test'
                , url: '<%=request.getContextPath()%>/OperatingRecordServlet?action=getAllRecordByPage'
                , toolbar: '#toolbarDemo'
                , width: 1200
                , title: '操作记录表'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'recordId', title: '编号', fixed: 'left', sort: true}
                    , {field: 'staffName', title: '借用人员'}
                    , {field: 'equipmentName', title: '器材名称'}
                    , {field: 'borrowingTime', title: '借出时间', templet: '#borrowingTime'}
                    , {field: 'returnTime', title: '归还时间', templet: '#returnTime'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]]
                , page: true
            });

            layui.$('#search').on('click', function () {
                var val = layui.$("*[name='recordId']").val();
                if (val == "") {
                    layer.msg('请输入ID');
                    return;
                }
                layer.open({
                    title: '查询',
                    type: 2,
                    skin: 'layui-layer-rim', // 加上边框
                    area: ['451px', '405px'], // 宽高
                    content: '<%=request.getContextPath()%>/OperatingRecordServlet?action=findRecordById&recordId=' + val
                });
            });

            //监听行工具事件
            table.on('tool(test)', function (obj) {
                var data = obj.data;
                if (obj.event === 'return') {
                    layer.confirm('确定要归还吗？', function (index) {
                        layer.close(index);
                        //发异步 删除数据
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/OperatingRecordServlet",
                            data: {
                                action: "returnEquipment",
                                recordId: data.recordId
                            },
                            success: function (msg) {
                                if (msg == 1) {
                                    layer.alert("归还成功", {icon: 6});
                                } else if (msg == 2) {
                                    layer.msg("无效 重复归还", {icon: 2, time: 1500});
                                } else if (msg == 0) {
                                    layer.msg("归还失败 已被删除或不存在", {icon: 2, time: 1500});
                                }
                                // 刷新本页面
                                setTimeout("location.reload()", 1500)
                            },
                            error: function () {
                                layer.msg("归还异常")
                            }
                        });
                    });
                }
            });
        });
    </script>
</div>
<body>

</body>
</html>

