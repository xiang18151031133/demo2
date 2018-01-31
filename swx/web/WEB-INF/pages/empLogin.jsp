<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 10:48
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
    <link rel="stylesheet" type="text/css" href="css/01.css"/>
</head>
<body>
    <div style="margin-left: 30px;margin-right: 30px">
        <div id="d2" >
            <div id="d3">
                <p style="text-align: center;font-size: 30px;color: cadetblue;">登录系统</p>
                <form action="empLogin" method="post" id="form">
                    用户： <input type="text" name="e_name" placeholder="请输入用户帐号/手机"/><br/>
                    密码： <input type="password" name="e_password" placeholder="请输入密码"/><br/>
                    <input type="submit" id="signBtn" value="登录"/>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
