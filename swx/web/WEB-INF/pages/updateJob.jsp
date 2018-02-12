<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/9
  Time: 15:19
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
    <form action="updateJob" method="post">
        请输入职位名称：<input value="${sessionScope.job1.j_name}" name="j_name"/><br>
        <input type="submit" value="确认"/>
    </form>
    </body>
</html>
