<%@ page import="com.bd.dao.impl.NewsDaoMysqlImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bd.entity.News" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/5
  Time: 12:19 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        NewsDaoMysqlImpl daoIml = new NewsDaoMysqlImpl();
        List<News> lists = daoIml.getAll();

    %>
    <ul>
        <% for ( News news : lists) { %>
            <li>
                <a href="newsDetails.jsp?newsID=<%=news.getNewsID()%>">
                <%=news.getTitle()%></a>
            </li>
        <%}%>

    </ul>
</body>
</html>
