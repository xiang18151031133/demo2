<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29
  Time: 13:36
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
    <script>
        function sure() {
            if(confirm("确认删除？")){
                return true;
            }else {
                return false;
            }
        }
    </script>
</head>
<body>
    <table border="1" cellspacing="0" cellpadding="10">
        <tr>
            <th>简历名称</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${sessionScope.user.resumes}" var="resumes">
            <tr>
                <td>
                    <a href="showResume?r_id=${resumes.r_id}" style="text-decoration: none">${resumes.r_intension}</a>
                </td>
                <td>
                    <form action="toUpdateResume" method="post">
                        <input type="hidden" name="r_id" value="${resumes.r_id}"/>
                        <input type="submit" value="修改"/>
                    </form>
                </td>
                <td>
                    <form action="deleteResume" method="post" onsubmit="return sure()">
                        <input type="hidden" name="r_id" value="${resumes.r_id}"/>
                        <input type="submit" value="删除" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
