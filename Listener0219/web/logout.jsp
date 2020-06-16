<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/19
  Time: 11:09 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
我会消亡一个会话哦：
<%
//    System.out.println(session.getId());
    session.invalidate();
    System.out.println("之前消亡掉的会话ID："+session.getId());
%>
</body>
</html>
