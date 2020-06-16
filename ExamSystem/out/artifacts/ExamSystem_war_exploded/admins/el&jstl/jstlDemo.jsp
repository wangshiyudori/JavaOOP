<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/17
  Time: 9:22 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${10>9}" var="result" scope="request">
    真11
    ${requestScope.result}
</c:if>

<c:set var="role" value="学生" scope="request"></c:set>

<c:choose>
    <c:when test="${requestScope.role == '老师'}">
        老师代码。。。
    </c:when>
    <c:when test="${requestScope.role eq '学生'}">
        学生代码。。。
    </c:when>
    <c:otherwise>
        其他人员。。。
    </c:otherwise>
</c:choose>

=================================
<c:forEach begin="0" end="3" step="1" varStatus="status">
    ${status.index}
    test...
</c:forEach>


<br/>
===============================
<br/>
<%
    String[] names = new String[]{"aa","bb","cc"};
    request.setAttribute("names",names);
%>
<c:forEach var="name" items="${requestScope.names}">
    ${name}
</c:forEach>
</body>
</html>
