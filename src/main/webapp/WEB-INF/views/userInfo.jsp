<%@ page import="wangyuandong.model.User" %><%--
  Created by IntelliJ IDEA.
  User: wyd
  Date: 2022/4/4
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User InFo</h1>
<%
    User user=(User)request.getAttribute("user");
%>
<table>
    <tr>
        <td>username:</td><td><%=user.getUsername()%></td>
    </tr><tr>
        <td>passwords:</td><td><%=user.getPasswords()%></td>
</tr><tr>
        <td>emails:</td><td><%=user.getEmails()%></td>
</tr><tr>
        <td>gender:</td><td><%=user.getGender()%></td>
</tr><tr>
        <td>birthdate:</td><td><%=user.getBirthdate()%></td>
    </tr>
</table>


<%@include file="footer.jsp"%>
