<%--
  Created by IntelliJ IDEA.
  User: wyd
  Date: 2022/4/4
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User InFo</h1>
<table>
    <tr>
        <td>username:</td><td><%=request.getAttribute("username")%></td>
    </tr><tr>
        <td>passwords:</td><td><%=request.getAttribute("passwords")%></td>
</tr><tr>
        <td>emails:</td><td><%=request.getAttribute("emails")%></td>
</tr><tr>
        <td>gender:</td><td><%=request.getAttribute("gender")%></td>
</tr><tr>
        <td>birthdate:</td><td><%=request.getAttribute("birthdate")%></td>
    </tr>
</table>


<%@include file="footer.jsp"%>
