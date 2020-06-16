<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/4
  Time: 4:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String nn = request.getParameter("uname");
    String pw = request.getParameter("upwd");
    out.println("Your name is: "+ nn + "<br>");
    out.println("Your passwd is: "+ pw);
%>
恭喜你，骚年，<%=session.getAttribute("uname") %>,成功登陆了！

</body>
</html>
