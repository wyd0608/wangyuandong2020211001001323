<%@ page import="wangyuandong.model.User" %><%--
  Created by IntelliJ IDEA.
  User: wyd
  Date: 2022/4/19
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
    <input type="hidden" name="ID" value="<%=u.getID()%>">
    username<input type="text" name="username" value="<%=u.getUsername()%>"><br/>
    passwords<input type="password" name="passwords"><br/>
    Emails<input type="text" name="emails" value="<%=u.getEmails()%>"><br/>
    Gender<input type="radio" name="gender" value="<%= "male".equals(u.getGender())?"checked" :""%>">Male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender())?"checked" :""%>>Female
    Date of Birth<input type="text name=" name="birthdate" value="<%=u.getBirthdate()%>"><br/>
    <input type="submit" value="Save Changes"/>
</form>
<%@include file="footer.jsp"%>
