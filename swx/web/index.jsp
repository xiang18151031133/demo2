<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 10:29
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
    <a href="toLogin">登录</a>
    <a href="toRegister">注册</a>
    <a href="toAdminLogin">管理员</a><br>
    <a href="ToEmpLogin">员工登录</a>

</body>
</html>
