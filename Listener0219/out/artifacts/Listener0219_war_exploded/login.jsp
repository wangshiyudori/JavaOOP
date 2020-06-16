<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/19
  Time: 10:57 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Random random = new Random();
session.setAttribute("loginID",random.nextInt());
%>
当前用户的ID：${loginID}
<%=session.getId()%>
</body>
</html>
