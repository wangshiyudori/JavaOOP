<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/17
  Time: 12:08 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%-- 取绝对路径 ${pageContext.request.contextPath}--%>
<%--/k52Servlet_war_exploded--%>
  <form action="/Login" method="post">
    用户名：<input type="text" name="userName">
    <br/>
    密码：<input type="text" name="userPwd">
    <input type="submit" value="登录">
  </form>
  </body>
</html>
