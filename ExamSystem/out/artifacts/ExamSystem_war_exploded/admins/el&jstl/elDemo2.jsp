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
    Users users = new Users();
    request.setAttribute("users",users);
%>
<c:set target="${users}" property="userName" value="小王"></c:set>
<c:set target="${users}" property="userPwd" value="123"></c:set>
用户名： ${users.userName}
密码：${users.userPwd}
<c:remove var="users"/>
<br/>
------------------------------
<br/>
<%
    request.setAttribute("student",users);
    session.setAttribute("sessionKey","sessionValue");
%>
有值显示false：${empty requestScope.student}
<br/>
${sessionScope.sessionKey}
<br/>
------------------------------
<br/>
${param.uname}
${paramValues.hobbies[0]}
${paramValues.hobbies[1]}
${paramValues.hobbies[2]}
<br/>
${pageContext.request.serverName}
${pageContext.request.serverPort}



<br/>
<c:set var="a" value="aaa" > </c:set>
${a}
<br/>
a:<c:out value="${a}"></c:out>

<%--<c:set var="price" value="3000"></c:set>--%>
<%--<c:if test="$"--%>



</body>
</html>
