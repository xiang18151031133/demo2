<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#b1").click(function () {
                $("#d1").css("display","block");
                $("#d2").css("display","none");
                $("#d3").css("display","none");
                $("#d4").css("display","none");
                $("#d5").css("display","none");
            })
            $("#b2").click(function () {
                $("#d1").css("display","none");
                $("#d2").css("display","block");
                $("#d3").css("display","none");
                $("#d4").css("display","none");
                $("#d5").css("display","none");
            })
            $("#b3").click(function () {
                $("#d1").css("display","none");
                $("#d2").css("display","none");
                $("#d3").css("display","block");
                $("#d4").css("display","none");
                $("#d5").css("display","none");
            })
            $("#b4").click(function () {
                $("#d1").css("display","none");
                $("#d2").css("display","none");
                $("#d3").css("display","none");
                $("#d4").css("display","block");
                $("#d5").css("display","none");
            })
            $("#b5").click(function () {
                $("#d1").css("display","none");
                $("#d2").css("display","none");
                $("#d3").css("display","none");
                $("#d4").css("display","none");
                $("#d5").css("display","block");
            })

        })
    </script>
</head>
<body>
    <a href="toAddRecruitment">创建招聘信息</a>
    <a href="showInterview">查看面试信息</a>
    <button id="b1">增加部门</button>
    <button id="b2">增加职位</button>
    <button id="b3">查看部门信息</button>
    <button id="b4">查看职位信息</button>
    <button id="b5">查看员工信息</button>
    <a href="payOff">发工资</a>
    <a href="">发布培训信息</a>
    <div id="d1" style="display: none">
        <form action="addDept" method="post">
            请输入部门名称：<input name="d_name"/><br>
            <input type="submit" value="提交"/>
        </form>
    </div>

    <div id="d2" style="display: none">
        <form action="addJobs" method="post">
            请选择部门：
            <select name="j_did">
                <option>---请选择部门---</option>
                <c:forEach items="${sessionScope.departments}" var="department">
                    <option value="${department.d_id}">${department.d_name}</option>
                </c:forEach>
            </select>
            请输入职位：<input name="j_name"/><br>
            <input type="submit" value="提交"/>
        </form>
    </div>

    <div id="d3" style="display: none">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>部门</th>
                <th>修改</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${sessionScope.departments}" var="department">
                <tr>
                    <td><a href="showJobAndEmp?d_id=${department.d_id}">${department.d_name}</a></td>
                    <td>
                        <form action="toUpdateDept" method="post">
                            <input type="hidden" name="d_id" value="${department.d_id}"/>
                            <input type="submit" value="修改"/>
                        </form>
                    </td>
                    <td>
                        <form action="deleteDept" method="post">
                            <input type="hidden" name="d_id" value="${department.d_id}"/>
                            <input type="submit" value="删除"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="d4" style="display: none">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>职位</th>
                <th>修改</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${sessionScope.jobs}" var="job">
                <tr>
                    <td><a href="showEmp?j_name=${job.j_name}">${job.j_name}</a></td>
                    <td>
                        <form action="toUpdateJob" method="post">
                            <input type="hidden" name="j_id" value="${job.j_id}"/>
                            <input type="submit" value="修改"/>
                        </form>
                    </td>
                    <td>
                        <form action="deleteJob" method="post">
                            <input type="hidden" name="j_id" value="${job.j_id}"/>
                            <input type="submit" value="删除"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="d5" style="display: none">
        <c:forEach items="${sessionScope.employees}" var="emp">
            <p><a href="allEmp?e_id=${emp.e_id}">${emp.e_realname}</a></p>
        </c:forEach>
    </div>
</body>
</html>
