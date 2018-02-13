<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/12
  Time: 15:33
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
            })

            $("#b2").click(function () {
                $("#d1").css("display","none");
                $("#d2").css("display","block");
            })

            $("#in2").click(function () {
                var value="";
                $("[class='choice']:checked").each(function () {
                    value+=$(this).val()+",";
                });
                $("#str").val(value);
            })
        })
    </script>
</head>
<body>
    <button id="b1">根据职位</button>
    <button id="b2">根据员工</button>
    <div id="d1" style="display: none">
        <form action="addTrainToAll" method="post">
            培训时间：<input type="date" name="t_time"/><br>
            培训地址：<input type="text" name="t_address"/><br>
            培训内容： <input type="text" name="t_train"/><br>
            <select id="st1" name="d_name">
                <option value="-1">---请选择部门---</option>
                <c:forEach items="${sessionScope.departments}" var="department">
                    <option value="${department.d_name}">${department.d_name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="提交" id="in1"/>
        </form>
    </div>
    <div id="d2" style="display: none">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th></th>
                <th>员工姓名</th>
                <th>部门</th>
                <th>职位</th>
            </tr>
            <c:forEach items="${sessionScope.employeeList}" var="emp">
                <tr>
                    <td><input type="checkbox" class="choice" value="${emp.e_id}"/></td>
                    <td>${emp.e_name}</td>
                    <td>${emp.e_jdesc}</td>
                    <td>${emp.e_jname}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="addTrainByEmp" method="post">
            培训时间：<input type="date" name="t_time"/><br>
            培训地址：<input type="text" name="t_address"/><br>
            培训内容： <input type="text" name="t_train"/><br>
            <input type="hidden" id="str" name="str"/>
            <input type="submit" value="提交" id="in2"/>
        </form>
    </div>
</body>
</html>
