<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29
  Time: 21:46
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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#sub").click(function () {
                if(${sessionScope.user.u_status==2}){
                    $("#sub").attr("type","button")
                }
            })
        })
    </script>
</head>
<body>
    招聘描述：${sessionScope.recruitment.rm_jdesc}<br>
    招聘职位：${sessionScope.recruitment.rm_jname}<br>
    招聘人数：${sessionScope.recruitment.rm_peopleneeded}人<br>
    招聘需求：${sessionScope.recruitment.rm_requirement}<br>
    工资：${sessionScope.recruitment.rm_money}/月<br>
    工作地点：${sessionScope.recruitment.rm_workplace}<br>
    <form action="addInterview" method="post">
        <input type="hidden" name="i_uid" value="${sessionScope.user.u_id}"/>
        <input type="hidden" name="i_rmid" value="${sessionScope.recruitment.rm_id}"/>
        <input type="submit" value="投递简历" id="sub"/>
    </form>
</body>
</html>
