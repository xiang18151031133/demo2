<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29
  Time: 14:39
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
    <form action="updateResume" method="post">
        姓名：<input name="r_name" value="${sessionScope.resume.r_name}"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        年龄：<input type="number" min="18" name="r_age" value="${sessionScope.resume.r_age}"/><br>
        民族：<input name="r_ethnicity" value="${sessionScope.resume.r_ethnicity }"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        电话：<input name="r_phone" value="${sessionScope.resume.r_phone }"/><br>
        身高：<input type="number" min="1" name="r_height" value="${sessionScope.resume.r_height }"/>cm
        &nbsp;&nbsp;&nbsp;&nbsp;
        体重：<input type="number" min="1" name="r_weight" value="${sessionScope.resume.r_weight }"/>kg<br>
        求职意向：<input name="r_intension" value="${sessionScope.resume.r_intension }"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        毕业学校：<input name="r_schoolofgraduation" value="${sessionScope.resume.r_schoolofgraduation }"/><br>
        居住地址：<textarea name="r_address">${sessionScope.resume.r_address }</textarea>
        &nbsp;&nbsp;&nbsp;&nbsp;
        自我评价：<textarea name="r_selfassessment">${sessionScope.resume.r_selfassessment }</textarea><br>
        实习经历：<textarea name="r_intership">${sessionScope.resume.r_intership }</textarea>
        &nbsp;&nbsp;&nbsp;&nbsp;
        曾获奖励：<textarea name="r_award">${sessionScope.resume.r_award }</textarea><br>
        <input type="hidden" name="r_id" value="${sessionScope.resume.r_id }"/>
        <input type="submit" value="修改"/>
    </form>
</body>
</html>
