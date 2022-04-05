<%--
  Created by IntelliJ IDEA.
  User: wyd
  Date: 2022/3/29
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1>LOGIN</h1>
<%
    if(!(request.getAttribute("message")==null)){
        //error
        out.println(request.getAttribute("message"));
    }
%>
<form action="${pageContext.request.contextPath}/login" method="post">

账号:<input type="text" name="username"/>
<br>
密码:<input type="password"name="passwords"/>
<br>
<input type="submit" value="login"/>

</form>
<%@include file="/footer.jsp"%>

