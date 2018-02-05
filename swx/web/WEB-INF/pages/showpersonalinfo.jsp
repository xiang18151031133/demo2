<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/31
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
用户名: ${sessionScope.employee.e_name}<br>
密码: ${sessionScope.employee.e_password}<br>
真实姓名: ${sessionScope.employee.e_realname}<br>
年龄: ${sessionScope.employee.e_age}<br>
名族: ${sessionScope.employee.e_ethnicity}<br>
电话: ${sessionScope.employee.e_phone}<br>
住址: ${sessionScope.employee.e_address}<br>
入职日期: ${sessionScope.employee.e_hiretime}<br>
部门名称: ${sessionScope.employee.e_jdesc}<br>
职位: ${sessionScope.employee.e_jname}<br>
基本工资: ${sessionScope.employee.e_basicwage}<br>
上班时间: ${sessionScope.employee.e_workstarttime}<br>
下班时间: ${sessionScope.employee.e_workendtime}<br>
</body>
</html>
