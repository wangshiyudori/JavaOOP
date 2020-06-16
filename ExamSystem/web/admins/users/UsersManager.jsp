<%@ page import="com.cp.biz.UsersBiz" %>
<%@ page import="com.cp.biz.impl.UsersBizImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cp.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/9
  Time: 6:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="../../css/UsersManager.css">

    <script src="../../js/jquery.js"></script>
    <script src="../../js/UsersManager.js"></script>
</head>
<body>
<%--将数据已table形式展示出来--%>
<%
    UsersBiz biz = new UsersBizImpl();
    List<Users> lists = biz.findAll();
%>

<table style="width: 100%; border: 1px solid black;" >
    <caption>用户管理表</caption>
    <tr>
        <td>
            <a href="javascript:void(0)" id="btnNew">新增</a>
        </td>
    </tr>
    <tr>
        <td>用户ID</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>操作</td>
    </tr>
    <% for (Users users : lists){ %>
    <tr>
        <td class="cuserID"> <%=users.getUserID()%> </td>
        <td class="cuserName"> <%=users.getUserName()%> </td>
        <td class="cuserPwd"> <%=users.getUserPwd()%> </td>
        <td>
            <a href="#" class="btnEdit">编辑</a> &nbsp;&nbsp;
            <a href="deleteUser.jsp?userID=<%=users.getUserID()%>"
               onclick="javascript:return confirm('你确定要删除吗？')">删除</a>
        </td>
    </tr>
    <%}%>
</table>

<div id="editUser">
    <form action="editUser.jsp" method="post">
        <input type="hidden" name="userID" id="userID" value="">

        <table>
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="userName" id="userName">
                </td>
            </tr>
            <tr>
                <td>用户密码：</td>
                <td>
                    <input type="text" name="userPwd" id="userPwd">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" id="btnSubmit" value="修改用户">
                </td>
            </tr>
        </table>
    </form>
</div>




</body>
</html>
