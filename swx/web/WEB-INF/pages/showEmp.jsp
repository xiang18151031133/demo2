<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/9
  Time: 15:40
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
    <div>
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>员工姓名</th>
                <th>部门</th>
                <th>职位</th>
            </tr>
            <c:forEach items="${sessionScope.employeeList}" var="emp">
                <tr>
                    <td>${emp.e_name}</td>
                    <td>${emp.e_jdesc}</td>
                    <td>${emp.e_jname}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
