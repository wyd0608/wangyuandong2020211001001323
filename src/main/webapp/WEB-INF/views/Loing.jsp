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
<%
    Cookie[] allCookies=request.getCookies();
    String username="", passwords="", rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                passwords=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form action="${pageContext.request.contextPath}/login" method="post">

Username:<input type="text" name="username" value="<%=username%>"/>
<br>
Password:<input type="password"name="passwords" value="<%=passwords%>"/>
<br>
    <input type="checkbox" name="rememberMe" value="1"  <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RememberMe<br/>
<input type="submit" value="login"/>

</form>
<%@include file="/footer.jsp"%>

