<%@ page import="com.bd.dao.NewsDao" %>
<%@ page import="com.bd.dao.impl.NewsDaoMysqlImpl" %>
<%@ page import="com.bd.entity.News" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/5
  Time: 4:20 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
    String strnewsID = request.getParameter("newsID");

        News entity = null;
    if (strnewsID!=null && strnewsID!=""){
        System.out.println(strnewsID);
        int newsID = Integer.parseInt(strnewsID);
        System.out.println(newsID);

        NewsDao dao = new NewsDaoMysqlImpl();
        entity = dao.getById(newsID);
    }
    %>

    <%
    if (entity!=null ){
    %>
    <h1><%=entity.getTitle()%></h1>
    <div>
        <%=entity.getContent()%>
    </div>
    <%}else {%>
        <h1>请输入新闻编号ID</h1>
    <%}%>
</body>
</html>
