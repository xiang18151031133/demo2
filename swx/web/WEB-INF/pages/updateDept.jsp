<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/8
  Time: 15:20
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
    <form action="updateDept" method="post">
        请输入部门名称：<input value="${sessionScope.department1.d_name}" name="d_name"/><br>
        <input type="submit" value="确认"/>
    </form>
</body>
</html>
