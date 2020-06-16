<%@ page import="com.cp.entity.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/11
  Time: 4:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    Users users = new Users(1, "aaa", "bbb");
//    request.setAttribute("users", users);
%>


<%--useBean标签分离了服务端代码和客户端代码--%>
<%
    List<Users> list = new ArrayList<Users>();
%>

<jsp:useBean id="users" class="com.cp.entity.Users" scope="request">
    <jsp:setProperty name="users" property="userID" value="1"></jsp:setProperty>
    <jsp:setProperty name="users" property="userName" value="aaaa1111"></jsp:setProperty>
    <jsp:setProperty name="users" property="userPwd" value="bbbb1111"></jsp:setProperty>

</jsp:useBean>

<jsp:getProperty name="users" property="userName"></jsp:getProperty>
<%--<%=users.getUserName()%>--%>
</body>
</html>
