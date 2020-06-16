<%@ page import="com.cp.biz.UsersBiz" %>
<%@ page import="com.cp.biz.impl.UsersBizImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cp.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/13
  Time: 11:02 上午
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
        String cpageIndex = request.getParameter("pageIndex");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        if (userName==null){
            userName="";
        }
        if (userPwd==null){
            userPwd="";
        }
        int pageIndex = 1;
        int pageSize = 5;
        if (cpageIndex!=null){
            pageIndex = Integer.parseInt(cpageIndex);
        }


        UsersBiz biz = new UsersBizImpl();
        //总页数：totalPage     总条数：totalSize
        //计算总页数:  总条数/pagetSize+1
//        int totalSize = biz.getTotalSize();
        int totalSize = biz.getTotalSizeByWhere(userName,userPwd);
        int totalPage =1;

        if (totalSize%pageSize==0){
            totalPage = totalSize/pageSize;
        }else {
            totalPage = totalSize/pageSize +1;
        }
        //处理pageIndex > totolPage   pagendex<1
        if (pageIndex>totalPage){
            pageIndex=totalPage;
        }
        if (pageIndex<1){
            pageIndex=1;
        }
//        List<Users> lists = biz.getPage(pageIndex);
        List<Users> lists = biz.getPageByWhere(userName,userPwd,pageIndex);

    %>

    <table width="100%" border="1px solid red">
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

    </tr>
    <%}%>
    <tr>

        <td colspan="4">
            共<%=totalSize%>条记录
            <%=pageIndex%> / <%=totalPage%>页
            <a href="UsersPage.jsp?pageIndex=1&userName=<%=userName%>">首页</a>
            <a href="UsersPage.jsp?pageIndex=<%=(pageIndex-1)>0?(pageIndex-1):1%>&userName=<%=userName%>&userPwd=<%=userPwd%>">上一页</a>
            <a href="UsersPage.jsp?pageIndex=<%=(pageIndex+1)>totalPage?totalPage:(pageIndex+1)%>&userName=<%=userName%>&userPwd=<%=userPwd%>">下一页</a>
            <a href="UsersPage.jsp?pageIndex=<%=totalPage%>&userName=<%=userName%>">尾页</a>


            <form action="UsersPage.jsp" method="get">
                <input type="text" name="pageIndex" size="3" value="<%=pageIndex%>">
                <input type="submit" value="go">
            </form>

            <form action="UsersPage.jsp" method="post">
                <input type="hidden" name="pageIndex" size="3" value="<%=pageIndex%>">
                请输入要查询的用户名：
                <input type="text" name="userName" value="<%=userName%>">
                请输入要查询的密码：
                <input type="text" name="userPwd" value="<%=userPwd%>">
                <input type="submit" value="查询">

            </form>


        </td>

    </tr>

    </table>
</body>
</html>
