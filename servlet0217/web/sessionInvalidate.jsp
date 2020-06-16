<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/19
  Time: 4:04 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("session销毁页面 sessionInvalidate.jsp");
        session.invalidate();
    %>
</body>
</html>
