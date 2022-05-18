<%--
  Created by IntelliJ IDEA.
  User: wyd
  Date: 2022/5/18
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MYDEARJSP</title>
</head>
<body>
<h2>
    name:<%=request.getParameter("name")%><br>
    submit:<%=request.getParameter("submit")%><br>
    class:<%=request.getParameter("class")%><br>
    id:<%=request.getParameter("id")%><br>

</h2>
</body>
</html>
