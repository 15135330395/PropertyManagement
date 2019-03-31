<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commons/info.jsp"%>
<html>
<head>
    <title>付款表</title>
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
        <a><cite>付款表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="tab" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <form action="/shouFei/pay/payAdd.jsp" method="get">
                <button class="layui-btn"><i class="layui-icon"> </i>添加付款表数据</button>
            </form>
        </div>
    </script>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
</div>
<script>
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#tab'
            // Servlet 返回一个json字符串
            ,url:'<%=request.getContextPath()%>/PayServlet?action=query'
            ,toolbar: '#toolbarDemo'
            ,title: '付款表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'pid', title:'pid',fixed: 'left',unresize: true, sort: true}
                ,{field:'department', title:'部门'}
                ,{field:'staffId', title:'职员ID'}
                ,{field:'staffName', title:'职员姓名'}
                ,{field:'monery', title:'付款金额'}
                ,{field:'reason', title:'付款事由'}
                ,{field:'transactor', title:'办理员'}
                ,{field:'shijian', title:'付款时间'}
                ,{fixed: 'right', title:'操作',toolbar: '#barDemo'}
            ]]
            ,page: true
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
                        url:"<%=request.getContextPath()%>/PayServlet",
                        data:"action=delete&id="+data.pid,
                        success:function(msg){
                            obj.del();
                            if(msg==0){
                                layer.msg("已被删除或不存在",{icon:2,time:2000});
                            }else{
                                layer.msg("删除成功",{icon:1,time:1000});
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
                    area: ['1200px', '700px'],
                    offset: 'auto', //右下角弹出
                    anim: 2,
                    content: ['<%=request.getContextPath()%>/PayNormServlet?action=queryOne&id='+data.pid, 'no'], //iframe的url，no代表不显示滚动条
                });
            }
        });
    });
</script>

</body>
</html>
