<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30
  Time: 16:30
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
    <form action="updateInterview" method="post">
        请输入工作地址：<input name="i_interviewaddress"/><br>
        请输入面试时间：<input name="i_interviewtime"/><br>
        <input type="submit" value="确认"/>
    </form>
</body>
</html>
