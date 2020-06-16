<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/20
  Time: 10:04 上午
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

    String name = request.getParameter("uname");
    String pwd = request.getParameter("upwd");
    int age = Integer.parseInt(request.getParameter("uage"));
    String[] hobbies = request.getParameterValues("uhobbies");
%>

注册成功，信息如下：<br/>
姓名：<%=name%> <br/>
年龄：<%=age%> <br/>
密码：<%=pwd%> <br/>
爱好：

<%--    遍历集合不能为空，否则不填hobbies会报空指针异常，所以加一个if条件进行排空设置。--%>
<%
    if (hobbies != null) {
        for (String hobby : hobbies) {
            out.print(hobby + "&nbsp;");
        }
    }

%>

</body>
</html>
