<%@ page import="com.cp.entity.Products" %>
<%@ page import="com.cp.biz.ProductsBiz" %>
<%@ page import="com.cp.biz.impl.ProductsBizImpl" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/12
  Time: 11:26 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String content = request.getParameter("content");
    content = content.replace("<","&lt;").replace(">","&gt;");
    System.out.println(content);

    Products entity = new Products();
    entity.setProductDesc(content);
    ProductsBiz biz = new ProductsBizImpl();
    biz.insert(entity);
    System.out.println("插入成功！");
%>
<%=content.replace("&gt;",">").replace("&lt;","<")%>
</body>
</html>
