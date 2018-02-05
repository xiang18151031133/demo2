<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/31
  Time: 14:05
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
            $("#btnpass").click(function () {
                $("#div1").css("display","block");
                $("#div2").css("display","none");
                $("#div3").css("display","none");
                $("#div4").css("display","none");
                $("#div5").css("display","none");
            })
            $("#sub").click(function () {
                if($("#oldpass").val()==${sessionScope.employee.e_password}&&$("#oldpass").val()!=""){
                    $("#div1").css("display","none");
                    $("#sub").attr("type","submit");
                }else {
                    $("#sub").attr("type","button");
                    alert("原密码有误")
                }
            })
            $("#bu1").click(function () {
                $("#div1").css("display","none");
                $("#div2").css("display","none");
                $("#div3").css("display","block");
                $("#div4").css("display","none");
                $("#div5").css("display","none");
            })

            $("#bu2").click(function () {
                $("#div1").css("display","none");
                $("#div2").css("display","none");
                $("#div3").css("display","none");
                $("#div4").css("display","block");
                $("#div5").css("display","none");
            })

            $("#bu3").click(function () {
                $("#div1").css("display","none");
                $("#div2").css("display","none");
                $("#div3").css("display","none");
                $("#div4").css("display","none");
                $("#div5").css("display","block");
            })

            $("#bu4").click(function () {
                $("#div1").css("display","none");
                $("#div2").css("display","block");
                $("#div3").css("display","none");
                $("#div4").css("display","none");
                $("#div5").css("display","none");
            })

            $("#st1").change(function () {
                $.ajax({
                    async:false,
                    type:"post",
                    dataType: "json",
                    url:"searchJobs",
                    data:{d_id:$("#st1").val()},
                    success:function (data) {
                        if($("#st1").val()==-1){
                            $("#st2").empty();
                            $("#st2").append("<option value=''>----选择职位----</option>");
                        }else {
                            $("#st2").empty();
                            $("#st2").append("<option value=''>----选择职位----</option>");
                            for(var i=0;i<data.length;i++){
                                $("#st2").append( "<option value='"+data[i].j_id+"'>"+data[i].j_name+"</option>");
                            }
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="toshowpersonalinfo">查看个人信息</a>
    <button id="btnpass">修改密码</button>
    <button id="bu1">培训信息</button>
    <button id="bu2">奖惩信息</button>
    <button id="bu3">考勤信息</button>
    <button id="bu4">薪资信息</button>

    <div style="display: none" id="div1">
        <form action="modifyPass" method="post">
            请输入原密码：<input id="oldpass"/><br>
            请输入新密码：<input name="e_password" id="newpass"/><br>
            <input type="submit" value="确认" id="sub"/>
        </form>
    </div>

    <div style="display: none" id="div2">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>员工姓名</th>
                <th>奖金</th>
                <th>罚款</th>
                <th>发放时间</th>
                <th>薪资</th>
                <th>最终薪资</th>
                <th>确认</th>
                <th>申诉</th>
            </tr>
            <c:forEach items="${sessionScope.salaries}" var="salary">
                <tr>
                    <td>
                        <c:if test="${salary.s_eid==sessionScope.employee.e_id}">
                            ${sessionScope.employee.e_realname}
                        </c:if>
                    </td>
                    <td>${salary.s_bonus}</td>
                    <td>${salary.s_punish}</td>
                    <td>${salary.s_date}</td>
                    <td>${salary.s_salary}</td>
                    <td>${salary.s_finalSalary}</td>
                    <td>
                        <form>
                            <input type="submit" value="确认"/>
                        </form>
                    </td>
                    <td>
                        <form>
                            <input type="submit" value="申诉"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div  style="display: none" id="div3">
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <th>培训员工</th>
                <th>培训地点</th>
                <th>培训时间</th>
                <th>培训内容</th>
            </tr>
            <c:forEach items="${sessionScope.trains}" var="train">
                <tr>
                    <td>
                        <c:if test="${train.t_eid==sessionScope.employee.e_id}">
                            ${sessionScope.employee.e_realname}
                        </c:if>
                    </td>
                    <td>${train.t_address}</td>
                    <td>${train.t_time}</td>
                    <td>${train.t_train}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div  style="display: none" id="div4">
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <th>员工姓名</th>
                <th>奖惩金额</th>
                <th>奖惩时间</th>
                <th>奖惩理由</th>
            </tr>
            <c:forEach items="${sessionScope.rewards}" var="reward">
                <tr>
                    <td>
                        <c:if test="${reward.re_eid==sessionScope.employee.e_id}">
                            ${sessionScope.employee.e_realname}
                        </c:if>
                    </td>
                    <td>${reward.re_money}</td>
                    <td>${reward.re_time}</td>
                    <td>${reward.re_reason}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div  style="display: none" id="div5">
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <th>员工姓名</th>
                <th>上班时间</th>
                <th>下班时间</th>
            </tr>
            <c:forEach items="${sessionScope.attendances}" var="attendance">
                <tr>
                    <td>
                        <c:if test="${attendance.at_eid==sessionScope.employee.e_id}">
                            ${sessionScope.employee.e_realname}
                        </c:if>
                    </td>
                    <td>${attendance.at_workTime}</td>
                    <td>${attendance.at_closeTime}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <select id="st1" name="d_id">
        <option value="-1">---请选择部门---</option>
        <c:forEach items="${sessionScope.departments}" var="department">
            <option value="${department.d_id}">${department.d_name}</option>
        </c:forEach>
    </select>
    <select id="st2" name="j_id">
        <option value="-2">---请选择职位---</option>
    </select>
</body>
</html>
