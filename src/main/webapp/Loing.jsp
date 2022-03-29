<%--
  Created by IntelliJ IDEA.
  User: wyd
  Date: 2022/3/29
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
<%@include file="header.jsp"%>
账号:<input type="text" name="username"/>
<br>
密码:<input type="password"name="passwords"/>
<br>
<input type="submit" value="login"/>

<%@include file="/footer.jsp"%>
</form>
</body>
</html>
