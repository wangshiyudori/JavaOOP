<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/11
  Time: 10:55 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="accept.jsp" method="post" enctype="multipart/form-data">
    <p>姓名：<input type="text" name="userName"></p>
    <p>照片：<input type="file" name="upfile"></p>
    <p>身份证照片：<input type="file" name="upfile2"></p>
    <input type="submit" value="提交">

</form>

</body>
</html>
