<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26 0026
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    // 主管 - 绿化清洁任务评分管理
    // response.sendRedirect(request.getContextPath() + "/logistics/Manager/CleaningTaskList.jsp");

    // 绿化清洁任务管理
    response.sendRedirect(request.getContextPath() + "/logistics/CleaningTask/CleaningTaskList.jsp");
    // 绿化清洁任务状况
    // response.sendRedirect(request.getContextPath() + "/logistics/CleaningTask/CleaningTaskCompletion.jsp");

    // 消防事故管理
    // response.sendRedirect(request.getContextPath() + "/logistics/FireIncident/FireIncidentList.jsp");

    // 器材使用记录管理
    // response.sendRedirect(request.getContextPath() + "/logistics/OperatingRecord/OperatingRecordList.jsp");
    // 器材归还管理
    // response.sendRedirect(request.getContextPath() + "/logistics/OperatingRecord/ReturnEquipment.jsp");

    // 保安排班管理
    // response.sendRedirect(request.getContextPath() + "/logistics/GuardRota/GuardRotaList.jsp");
    // 保安打卡管理
    // response.sendRedirect(request.getContextPath() + "/logistics/GuardRota/ClockInAndOut.jsp");
%>
</body>
</html>
