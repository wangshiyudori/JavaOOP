<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/11
  Time: 4:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 222</title>
</head>
<body>
<jsp:useBean id="users1" class="com.cp.entity.Users" >
    <jsp:setProperty name="users1" property="userName" value="u222"></jsp:setProperty>
</jsp:useBean>
<h2>jsp 222</h2>

<jsp:getProperty name="users1" property="userName"></jsp:getProperty>
</body>
</html>
