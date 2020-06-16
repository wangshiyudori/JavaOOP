<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/17
  Time: 5:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

监听器
当前登录用户的ID：${loginUser.users.userID}
<br/>
当前登录用户的用户名：${loginUser.users.userName}








<%--    当前登录用户的ID：${loginUser}--%>
<%--直接获取对象，因为可以获取到密码，会存在风险 最好使用上面方法的取ID--%>

<%--过滤器登录成功后--%>
<%--    当前登录用户的ID：${loginUser.userID}--%>
<%--    <br/>--%>
<%--    当前用户名：${loginUser.userName}--%>

</body>
</html>
