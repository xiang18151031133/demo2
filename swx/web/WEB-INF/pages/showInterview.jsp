<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30
  Time: 21:26
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
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>简历信息</th>
            <th>招聘信息</th>
            <th>发布面试</th>
            <th>录用</th>
            <th>淘汰</th>
        </tr>
        <c:forEach items="${sessionScope.interviews}" var="interview">
            <c:if test="${interview.i_result==0}">
                <tr>
                    <td>
                        <form action="showResume2" method="post">
                            <input type="hidden" name="u_id" value="${interview.i_uid}"/>
                            <input type="submit" value="个人简历"/>
                        </form>
                    </td>
                    <td>
                        <form action="showRecruitment2" method="post">
                            <input type="hidden" name="rm_id" value="${interview.i_rmid}"/>
                            <input type="submit" value="招聘信息"/>
                        </form>
                    </td>
                    <td>
                        <form action="toUpdateInterview" method="post">
                            <input type="hidden" name="i_id" value="${interview.i_id}"/>
                            <input type="hidden" name="u_id" value="${interview.i_uid}"/>
                            <input type="submit" value="发布面试"/>
                        </form>
                    </td>
                    <td>
                        <form action="hire" method="post">
                            <input type="hidden" name="i_id" value="${interview.i_id}"/>
                            <input type="hidden" name="u_id" value="${interview.i_uid}"/>
                            <input type="submit" value="录用"/>
                        </form>
                    </td>
                    <td>
                        <form action="abandon" method="post">
                            <input type="hidden" name="i_id" value="${interview.i_id}"/>
                            <input type="hidden" name="u_id" value="${interview.i_uid}"/>
                            <input type="submit" value="弃用"/>
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
