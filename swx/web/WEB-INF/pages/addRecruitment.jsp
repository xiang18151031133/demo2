<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 22:32
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
    <form action="addRecruitment" method="post">
        工作描述：<input name="rm_jobdesc"/><br>
        对应部门：<input name="rm_jdesc"/><br>
        对应的职位:
        <select name="rm_jname">
            <c:forEach items="${sessionScope.jobs}" var="jobs">
                <option>${jobs.j_name}</option>
            </c:forEach>
        </select><br>
        需求的人数:<input type="number" name="rm_peopleneeded"/><br>
        职位需求:<input name="rm_requirement"/><br>
        职位工资:<input type="number" name="rm_money"/><br>
        工作地点:<input name="rm_workplace"/><br>
        <input type="submit" value="发布"/>
    </form>
</body>
</html>
