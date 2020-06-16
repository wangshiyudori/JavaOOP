<%@ page import="com.cp.dao.UserDao" %>
<%@ page import="com.cp.dao.impl.UserDaoMysqlImpl" %>
<%@ page import="com.cp.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/7
  Time: 11:42 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
    String suserID = request.getParameter("uerID");

        User entity = null;
    if (suserID!=null && suserID!=""){
        System.out.println(suserID);
        int userID = Integer.parseInt(suserID);
        System.out.println(userID);

        UserDao dao = new UserDaoMysqlImpl();
        entity = dao.getById(userID);

    }
    %>

    <%
        if (entity!=null){
    %>

    <h2> <%=entity.getUserName()%> </h2>
    <h2> <%=entity.getPassword()%> </h2>

    <%}else{%>
        <h1>请输入查找的用户ID</h1>
    <%}%>
</body>
</html>
