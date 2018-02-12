<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/9
  Time: 17:09
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
            $("#st1").change(function () {
                $.ajax({
                    async:false,
                    type:"post",
                    dataType: "json",
                    url:"searchJobs2",
                    data:{d_id:$("#st1").val()},
                    success:function (data) {
                        if($("#st1").val()==-1){
                            $("#st2").empty();
                            $("#st2").append("<option value=''>----选择职位----</option>");
                        }else {
                            $("#st2").empty();
                            /*$("#st2").append("<option value=''>----选择职位----</option>");*/
                            for(var i=0;i<data.length;i++){
                                $("#st2").append( "<option value='"+data[i].j_id+"'>"+data[i].j_name+"</option>");
                            }
                        }
                    }
                })
            })
            $("#in1").click(function () {
                if($("#st1").val()!=-1&&$("#st2").val()!=-1){
                    $("#in1").attr("type","submit")
                }else {
                    $("#in1").attr("type","button")
                    alert("请正确选择部门和职位")
                }
            })
            $("#b1").click(function () {
                $("#d1").css("display","block");
                $("#d2").css("display","none");
                $("#d3").css("display","none");
            })
            $("#b2").click(function () {
                $("#d1").css("display","none");
                $("#d2").css("display","block");
                $("#d3").css("display","none");
            })
            $("#b3").click(function () {
                $("#d1").css("display","none");
                $("#d2").css("display","none");
                $("#d3").css("display","block");
            })
        })
    </script>
</head>
<body>
    <button id="b1">修改员工部门职位</button>
    <button id="b2">员工上下班时间</button>
    <button id="b3">修改上班状态</button>
    <div>
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <td>姓名：${sessionScope.employee.e_name}</td>
                <td>年龄：${sessionScope.employee.e_age}</td>
                <td>种族：${sessionScope.employee.e_ethnicity}</td>
                <td>电话：${sessionScope.employee.e_phone}</td>
            </tr>
            <tr>
                <td>地址：${sessionScope.employee.e_address}</td>
                <td>入职时间：${sessionScope.employee.e_hiretime}</td>
                <td>部门：${sessionScope.employee.e_jdesc}</td>
                <td>职位：${sessionScope.employee.e_jname}</td>
            </tr>
            <tr>
                <td>基本工资：${sessionScope.employee.e_basicwage}</td>
                <td>上班时间：${sessionScope.employee.e_workstarttime}</td>
                <td>下班时间：${sessionScope.employee.e_workendtime}</td>
                <td>工作状态：
                    <c:if test="${sessionScope.employee.e_workstatus==0}">离职</c:if>
                    <c:if test="${sessionScope.employee.e_workstatus==1}">试用</c:if>
                    <c:if test="${sessionScope.employee.e_workstatus==2}">在职</c:if>
                </td>
            </tr>
        </table>
    </div>

    <div id="d1" style="display: none">
        <form action="changeJobAndDept" method="post">
            <select id="st1" name="d_id">
                <option value="-1">---请选择部门---</option>
                <c:forEach items="${sessionScope.departments}" var="department">
                    <option value="${department.d_id}">${department.d_name}</option>
                </c:forEach>
            </select>
            <select id="st2" name="j_id">
                <option value="-1">---请选择职位---</option>
            </select>
            <input type="button" value="提交" id="in1"/>
        </form>
    </div>

    <div id="d2" style="display: none">
        <form action="modifyTime" method="post">
            请输入上班时间：<input type="time" name="e_workstarttime" placeholder="列如:09:10"/><br>
            请输入下班时间：<input type="time" name="e_workendtime" placeholder="列如:09:10"/><br>
            <input type="submit" value="确认"/>
        </form>
    </div>

    <div id="d3" style="display: none">
        <form action="modifyEmpStatus" method="post">
            <select id="st3" name="e_workstatus">
                <option value="2">转正</option>
                <option value="0">离职</option>
            </select>
            <input type="submit" value="提交"/>
        </form>
    </div>
</body>
</html>
