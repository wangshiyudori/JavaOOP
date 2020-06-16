<%@ page import="com.cp.dao.impl.UserDaoMysqlImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cp.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/7
  Time: 12:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        UserDaoMysqlImpl daoIml = new UserDaoMysqlImpl();
        List<User> lists = daoIml.getAll();
    %>

    <ul>
        <% for(User u:lists) { %>
        <li>
            <a href="userDetails.jsp?userID= <%=u.getId()%>">
                <%=u.getId()%>
                <%=u.getUserName()%>
                <%=u.getPassword()%>
            </a>
        </li>
        <%}%>

    </ul>

</body>
</html>
