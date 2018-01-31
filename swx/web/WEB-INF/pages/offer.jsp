<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30
  Time: 15:59
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
    <table border="1" cellspacing="0" cellpadding="10">
        <tr>
            <th>部门描述</th>
            <th>职位</th>
            <th>面试时间</th>
            <th>面试地点</th>
            <th>去面试</th>
            <th>取消</th>
        </tr>
        <c:forEach items="${sessionScope.interviews}" var="inter">
            <c:if test="${inter.i_result==0&&inter.i_interviewaddress!=null}">
                <tr>
                    <c:forEach items="${sessionScope.recruitments}" var="recru">
                        <c:if test="${inter.i_rmid==recru.rm_id}">
                            <td>${recru.rm_jdesc}</td>
                            <td>${recru.rm_jname}</td>
                        </c:if>
                    </c:forEach>
                    <td>${inter.i_interviewtime}</td>
                    <td>${inter.i_interviewaddress}</td>
                    <td>
                        <form action="toInterview" method="post">
                            <input type="hidden" name="i_id" value="${inter.i_id}"/>
                            <input type="submit" value="去面试"/>
                        </form>
                    </td>
                    <td>
                        <form action="cancleInterview" method="post">
                            <input type="hidden" name="i_id" value="${inter.i_id}"/>
                            <input type="submit" value="取消"/>
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body></html>
