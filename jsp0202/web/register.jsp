<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/19
  Time: 10:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="show.jsp" method="post">
        用户名: <input type="text" name="uname"/> <br/>
        密码:  <input type="password" name="upwd"/> <br/>
        年龄: <input type="text" name="uage"/> <br/>
        爱好:
        <input type="checkbox" name="uhobbies" value="足球"/>足球
        <input type="checkbox" name="uhobbies" value="篮球"/>篮球
        <input type="checkbox" name="uhobbies" value="乒乓球"/>乒乓球
        <br/>
        <input type="submit" value="注册"> <br/>

    </form>
</body>
</html>
