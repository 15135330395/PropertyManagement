<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commons/info.jsp" %>

<html>
<head>
    <title>新闻分类</title>

    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />


</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>新闻分类维护</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="tab" lay-filter="test"></table> //头工具栏操纵"test"

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
            <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>


    <%--<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
--%>
    <script>
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#tab'
                //Servlet 返回一个json字符串
                ,url:'<%=request.getContextPath()%>/ContractServlet?action=query'  //layui中URL：绝对路径和servlet之间没有加/,
                ,toolbar: '#toolbarDemo'
                ,title: '合同列表'
                ,cols: [[
                    {type: 'checkbox', fixed: 'left'}  //左边的选择框
                    ,{field:'typeId', title:'ID', width:'20%', fixed: 'left', unresize: true, sort: true} //sort 排序
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{field:'typeName', title:'分类', width:'60%', edit: 'text'}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo' }/*删除了width，因为共三列，前两列width:00% 宽度设置的百分比，那么最后一列自动补齐。*/
                ]]
                ,page: true  //传入json字符串后，自动分页
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

                        $.ajax({
                            type:"POST",
                            url:"<%=request.getContextPath()%>/NewsTypeServlet" ,
                            data: "action=delete&typeId="+data.typeId ,
                            success : function(msg){
                                /*  新闻分类下有内容无法删除

                                 * */

                                var rc=eval("("+msg+")");/* 转js对象*/
                                if(rc.code=="2001"){
                                    layer.msg(rc.message,{icon:1,time:2000} );
                                }else{
                                    if(rc.code="2002"){
                                        obj.del();
                                        layer.msg(rc.message,{icon:1,time:1000});
                                    }else if(rc.code="2003"){
                                        layer.msg(rc.message ,{icon:1,time:1000});
                                    }
                                }
                            }
                        });
                        layer.close(index);
                    });
                } else if(obj.event === 'edit'){
                    layer.open({
                        type:2,
                        skin:'layui-layer-rim',// 加上边框
                        area: [ '600px','500px'],
                        content:'http://www.baidu.com'
                    })
                }
            });
        });
    </script>

</div>


<%--<script>
   /*弹出hello world 信息表示成功进入该页面。
    地址发生改变，有没有获取到数据时，测试
    可以在转发，进入新的页面，jsp时都弹出信息，打印信息，来测试是否传递成功
   */
    layui.use(['layer','form'],function(){
        var layer=layui.layer
            ,form=layui.form;
        layer.msg('Hello World')

    });

</script>--%>

</body>
</html>