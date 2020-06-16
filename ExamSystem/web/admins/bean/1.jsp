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
    <title>jsp 111</title>
</head>
<body>

<jsp:useBean id="users" class="com.cp.entity.Users" >
    <jsp:setProperty name="users" property="userName" value="u1"></jsp:setProperty>
</jsp:useBean>
<h1>jsp 111</h1>

<jsp:getProperty name="users" property="userName"></jsp:getProperty>
<jsp:include page="2.jsp"></jsp:include>

使用@include实现页面复用时，会先进行页面包含，所以两个jsp页面中useBean的名称不能一样。
<%--<%@include file="2.jsp" %>--%>

<%--<jsp:forward page="2.jsp"></jsp:forward>--%>
</body>
</html>
