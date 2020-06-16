<%@ page import="com.cp.biz.UsersBiz" %>
<%@ page import="com.cp.biz.impl.UsersBizImpl" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/9
  Time: 6:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String struserID = request.getParameter("userID");
    if (struserID!=null){
        int userID = Integer.parseInt(struserID);
        UsersBiz biz = new UsersBizImpl();
        biz.deleteOne(userID);
    }
    request.getRequestDispatcher("UsersManager.jsp").forward(request,response);

%>

</body>
</html>
