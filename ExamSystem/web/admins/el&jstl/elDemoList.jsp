<%@ page import="com.cp.entity.Users" %>
<%@ page import="com.cp.biz.UsersBiz" %>
<%@ page import="com.cp.biz.impl.UsersBizImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/14
  Time: 11:44 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //p r s a


    UsersBiz biz = new UsersBizImpl();
    List<Users> lists = biz.getPage(1);
//    request.setAttribute("lists",lists);

%>

<table>
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>密码</td>
    </tr>
    <tr>

        <td>${lists[0].userID}</td>
<%--        <td>${lists[0].userName}</td>--%>
        <td><c:out value="${lists[0].userName}" default="<a href='#'>aaa</a>" escapeXml="true">  </c:out> </td>
        <td>${lists[0].userPwd}</td>
    </tr>
    <tr>
        <td>${lists[1].userID}</td>
        <td>${lists[1].userName}</td>
        <td>${lists[1].userPwd}</td>
    </tr>
</table>


</body>
</html>
