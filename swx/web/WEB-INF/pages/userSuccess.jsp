<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 22:34
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
    <a href="toLookResume">查看简历</a>
    <a href="offer">查看面试通知</a>
    <br>
    <c:forEach items="${sessionScope.recruitments}" var="rec">
        <p><a href="showRecruitment?rm_id=${rec.rm_id}">${rec.rm_jobdesc}</a></p>
    </c:forEach>

</body>
</html>
