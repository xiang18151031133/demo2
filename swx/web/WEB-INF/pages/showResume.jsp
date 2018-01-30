<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29
  Time: 14:24
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
    <table border="1" cellpadding="10">
        <tr>
            <td>姓名：${sessionScope.resume.r_name}</td>
            <td>年龄：${sessionScope.resume.r_age}</td>
            <td>名族：${sessionScope.resume.r_ethnicity }</td>
            <td>电话：${sessionScope.resume.r_phone }</td>
        </tr>
        <tr>
            <td>身高：${sessionScope.resume.r_height }</td>
            <td>体重：${sessionScope.resume.r_weight }</td>
            <td>求职意向：${sessionScope.resume.r_intension }</td>
            <td>毕业学校：${sessionScope.resume.r_schoolofgraduation }</td>
        </tr>
        <tr>
            <td colspan="4">居住地址：${sessionScope.resume.r_address }</td>
        </tr>
        <tr>
            <td colspan="4">自我评价：${sessionScope.resume.r_selfassessment }</td>
        </tr>
        <tr>
            <td colspan="4">实习经历：${sessionScope.resume.r_intership }</td>
        </tr>
        <tr>
            <td colspan="4">曾获奖励：${sessionScope.resume.r_award }</td>
        </tr>
    </table>
</body>
</html>
