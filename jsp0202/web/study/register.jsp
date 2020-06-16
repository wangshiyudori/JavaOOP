<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/4
  Time: 11:13 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
    %>

<%=name%>
<%=pwd%>

</body>
</html>
