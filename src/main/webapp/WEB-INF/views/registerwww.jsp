<%--
  Created by IntelliJ IDEA.
  User: wyd
  Date: 2022/3/7
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script language="JavaScript">
    function on_submit()
    {
        let username=document.getElementById("U").value;
        if (username==null||username===''){
            alert("Username can not be null!")
            return false;
        }
        let password=document.getElementById("P").value;
        if (password==null||password===''){
            alert("Password can not be null!")
            return false;
        }
        if (password.length<8){
            alert("Length must be at least 8 characters!");
            return false;
        }
        let Email=document.getElementById("E").value;
        const reg=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(Email)){
            alert("invalid Email")
            return false;
        }
    }
</script>
<head>
    <title>New User Registration</title>
    <style type="text/css">
        *{
            /*初始化 清除页面元素的内外边距*/
            padding: 0;
            margin: 0;
            /*盒子模型*/
            box-sizing: border-box;
        }
        body {

            height: 100vh;
            background-color: white;

        }
        .login{
            /*弹性布局 让子元素称为弹性项目*/
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 400px;
            padding: 40px;
            background-color: rgb(241, 241, 240);
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.4);

        }

        .login h2{
            color: #111010;
            margin-bottom: 30px;
        }
        .login {
            /*相对定位*/
            position: relative;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
        }
        .login .login_box input{
            /*清除input框自带的边框和轮廓*/
            outline: none;
            border: none;
            width: 100%;
            padding: 10px 0;
            margin-bottom: 30px;
            color: #181717;
            font-size: 16px;
            border-bottom: 1px solid #0a0909;
            /*背景颜色为透明色*/
            background-color: transparent;
        }

        .login .login_box label{
            position:absolute;
            top: 0 ;
            left: 0;
            padding: 10px 0;
            color: #0e0c0c;
            pointer-events: none;
            /*加个过度*/
            transition: all 0.5s;
        }
        .login .login_box input:focus + label,
        .login  .login_box input:valid + label{
            top: -20px;
            color: #03e9f4;
            font-size: 12px;
        }

        .login a{
            /*overflow: hidden;*/
            position: relative;
            padding: 10px 20px;
            color: #03e9f4;
            /*取消a表现原有的下划线*/
            text-decoration: none;
            /*同样加个过渡*/
            transition: all 0.5s;
        }
        .login a:hover {
            color: #fff;
            border-radius: 5px;
            background-color: #03e9f4;
            box-shadow: 0 0 5px #03e9f4,0 0 25px #03e9f4,0 0 50px #03e9f4,0 0 100px #03e9f4;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="login">
<form action="${pageContext.request.contextPath}/register" align="center" name="form1" method="post" onsubmit="return on_submit()">
    <h2>New User Registration!</h2><br>
    <div class="login_box">
    <input type="text"  name="username"id="U" placeholder="Username" style="background-color: #ffffff;size:500px"><br>
    <input type="text" name="passwords" id="P" placeholder="password" style="background-color: #ffffff;size:500px"><br>
    <input type="text" name="emails" id="E" placeholder=Email style="background-color: #fcfcfc;size:500px"><br>
        <input type="date" name="birthdate" placeholder="Date of birth(years-mouths-days)" style="background-color: #f8f8f8;size:500px"><br>
    </div>
    <strong>Gender</strong> <input type="radio" name="gender" value="Male">Male
    <input type="radio" name="gender" value="Female">Female<br>
    <div class="login_box">
    <input type="submit" value="Register" style="background-color: #fcfbfa;size: 200px">
    </div>
</form>
    <%@include file="footer.jsp"%>
    </div>
</body>
</html>