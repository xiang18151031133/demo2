<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 11:08
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
    <link rel="stylesheet" type="text/css" href="css/02.css"/>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            var code;
            function createCode(){
                code = "";//首先默认code为空字符串
                var codeLength = 4;//设置长度为4
                var codeV = $("#sp4");
                var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
                for(var i = 0; i < codeLength; i++){
                    var index = Math.floor(Math.random()*36); //设置随机数范围,这设置为0 ~ 36
                    code += random[index]; //字符串拼接 将每次随机的字符 进行拼接
                }
                codeV.text(code);//将拼接好的字符串赋值给展示的Value
            }
            createCode();//页面开始加载验证码
            $("#name").blur(function () {
                var rex=/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
                var uname=$("#name").val();
                if(rex.test(uname)&&uname!=""){
                    $.ajax({
                        type:"post",
                        url:"checkName",
                        data:"u_name="+$("#name").val(),
                        /*statusCode:{
                            404:function () {
                                alert("error");
                            }
                        },*/
                        success:function (data) {
                            if(data=="ok"){
                                $("#sp1").text("√");
                                $("#sp1").css("color","green");
                            }else {
                                $("#sp1").text("用户已存在");
                                $("#sp1").css("color","red");
                            }
                        }
                    });
                }else {
                    $("#sp1").text("×")
                    $("#sp1").css("color","red");
                }
            })
            $("#pass").blur(function () {
                reg=/^[a-zA-Z]\w{5,17}$/;
                var value=$("#pass").val()
                if(reg.test(value)&&value!=""&&value!=null){
                    $("#sp2").text("√");
                    $("#sp2").css("color","green");
                }else{
                    $("#sp2").text("×");
                    $("#sp2").css("color","red");
                }
            })
            $("#ensurePass").blur(function () {
                var oldPass=$("#pass").val();
                var newPass=$("#ensurePass").val();
                if(newPass!=""&&newPass!=null&&oldPass==newPass){
                    $("#sp3").text("√");
                    $("#sp3").css("color","green");
                }else {
                    $("#sp3").text("密码不一致");
                    $("#sp3").css("color","red");
                }
            })
            $("#yzm").blur(function () {
                var yzm=$("#yzm").val();
                if(yzm.toUpperCase()==code.toUpperCase()){
                    $("#sp5").text("√");
                    $("#sp5").css("color","green");
                }else {
                    $("#sp5").text("验证码有误");
                    $("#sp5").css("color","red");
                }
            })
            $("#sp4").click(function () {
                createCode();
            })
            $("#signBtn").click(function () {
                if( $("#sp1").text()=="√"&&$("#sp2").text()=="√"&&$("#sp3").text()=="√"&&$("#sp5").text()=="√"){
                    $("#signBtn").attr("type","submit")
                }else {
                    $("#signBtn").attr("type","button")
                }
            })
        })

    </script>
</head>
<body>
    <div id="d1">
        <div id="d3">
            <p style="text-align: center;font-size: 30px;color: orange;">用户注册</p>
            <form action="register" method="post" id="form" style="color: black">
                用户名： </br><input type="text" name="u_name" class="inp" id="name" placeholder="请输入用户名,字母开头5-16位"/><span id="sp1"></span><br/>
                密码： </br><input type="password" name="u_pass" class="inp" id="pass" placeholder="以字母开头，长度在6~18之间，只能包含字母、数字和下划线"/><span id="sp2"></span><br/>
                确认密码： </br><input type="password" class="inp" id="ensurePass" placeholder="请输入和上面相同的密码"/><span id="sp3"></span><br/>
                验证码：</br><input id="yzm" style="width: 230px;height: 40px" placeholder="不区分大小写，点击可刷新"/><div id="sp4" style="background: aquamarine;font-size: 30px;position: relative;top: 6px;left: 15px;display: inline"></div><span id="sp5"></span><br/>
                <input type="submit" id="signBtn" value="注 册"/>
            </form>
        </div>
    </div>
</body>
</html>
