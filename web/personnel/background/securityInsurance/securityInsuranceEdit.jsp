<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/31
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <div class="layui-form-item ">
            <label class="layui-form-label">编号：</label>
            <div class="layui-input-inline">
                <input readonly type="text" name="securityInsuranceId" value="${securityInsurance.securityInsuranceId}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名：</label>
            <div class="layui-input-inline">
                <input  type="hidden" name="staffId" value="${securityInsurance.staffId}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                <c:forEach items="${staffList}" var="list">
                    <c:if test="${list.staffId == securityInsurance.staffId}">
                        <input readonly type="text"  value="${list.staffName}"  lay-verify="required"  autocomplete="off" class="layui-input" >
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">社保标签：</label>
            <div class="layui-input-block">
                <input type="checkbox" name="endowmentInsurance" title="养老保险" <c:if test="${securityInsurance.endowmentInsurance==1}">checked</c:if>>
                <input type="checkbox" name="medicalInsurance" title="医疗保险" <c:if test="${securityInsurance.medicalInsurance==1}">checked</c:if>>
                <input type="checkbox" name="unemploymentInsurance" title="失业保险" <c:if test="${securityInsurance.unemploymentInsurance==1}">checked</c:if>>
                <input type="checkbox" name="employmentInjuryInsurance" title="工伤保险" <c:if test="${securityInsurance.employmentInjuryInsurance==1}">checked</c:if>>
                <input type="checkbox" name="maternityInsurance" title="生育保险" <c:if test="${securityInsurance.maternityInsurance==1}">checked</c:if>>

                <c:if test="${securityInsurance.publicHousingFunds==1}">
                    <input type="checkbox" name="publicHousingFunds" title="住房公积金" checked >
                </c:if>
                <c:if test="${securityInsurance.publicHousingFunds!=1}">
                    <input type="checkbox" name="publicHousingFunds" title="住房公积金" >
                </c:if>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="submitSave">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    //Demo
    layui.use(['laydate','form'], function(){
        var form = layui.form;
        var laydate = layui.laydate;

        //监听提交
        form.on('submit(submitSave)', function(data){

            var securityInsuranceId = data.field.securityInsuranceId;
            var staffId = data.field.staffId;
            var endowmentInsurance = data.field.endowmentInsurance;
            var medicalInsurance = data.field.medicalInsurance;
            var unemploymentInsurance = data.field.unemploymentInsurance;
            var employmentInjuryInsurance = data.field.employmentInjuryInsurance;
            var maternityInsurance = data.field.maternityInsurance;
            var publicHousingFunds = data.field.publicHousingFunds;


                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/SecurityInsuranceServlet",
                    data:{
                        "action":"update",
                        "securityInsuranceId":securityInsuranceId,
                        "staffId":staffId,
                        "endowmentInsurance":endowmentInsurance,
                        "medicalInsurance":medicalInsurance,
                        "unemploymentInsurance":unemploymentInsurance,
                        "employmentInjuryInsurance":employmentInjuryInsurance,
                        "maternityInsurance":maternityInsurance,
                        "publicHousingFunds":publicHousingFunds
                    },
                    success:function(msgData){
                        layer.msg("修改成功",{icon:1,time:1000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        setTimeout("parent.layer.close(index)",1000)
                        setTimeout("window.parent.location.reload()",1000)
                    }
                })
            return false;
        });
    });
</script>
</body>
</html>
