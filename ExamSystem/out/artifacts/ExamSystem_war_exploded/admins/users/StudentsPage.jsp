
<%@ page import="java.util.List" %>
<%@ page import="com.stu.biz.StudentsBiz" %>
<%@ page import="com.stu.biz.impl.StudentsBizImpl" %>
<%@ page import="com.stu.entity.Students" %><%--
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
        response.setCharacterEncoding("utf-8");
        String cpageIndex = request.getParameter("pageIndex");
        String studentName = request.getParameter("studentName");
        String studentAddr = request.getParameter("studentAddr");
        if (studentName==null){
            studentName="";
        }
        if (studentAddr==null){
            studentAddr="";
        }
        int pageIndex = 1;
        int pageSize = 5;
        if (cpageIndex!=null){
            pageIndex = Integer.parseInt(cpageIndex);
        }


        StudentsBiz biz = new StudentsBizImpl();
        //总页数：totalPage     总条数：totalSize
        //计算总页数:  总条数/pagetSize+1
//        int totalSize = biz.getTotalSize();
        int totalSize = biz.getTotalSizeByWhere(studentName,studentAddr);
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

        List<Students> lists = biz.getPageByWhere(studentName,studentAddr,pageIndex);

    %>

    <table width="100%" border="1px solid red">
        <tr>
            <td>学生ID</td>
            <td>学生姓名</td>
            <td>学生住址</td>
            <td>操作</td>
        </tr>
    <% for (Students students : lists){ %>
    <tr>
        <td class="cstudentID"> <%=students.getStudentID()%> </td>
        <td class="cstudentName"> <%=students.getStudentName()%> </td>
        <td class="cstudentAddr"> <%=students.getStudentAddr()%> </td>

    </tr>
    <%}%>
    <tr>

        <td colspan="4">
            共<%=totalSize%>条记录
            <%=pageIndex%> / <%=totalPage%>页
            <a href="StudentsPage.jsp?pageIndex=1&studentName=<%=studentName%>">首页</a>
            <a href="StudentsPage.jsp?pageIndex=<%=(pageIndex-1)>0?(pageIndex-1):1%>&studentName=<%=studentName%>&studentAddr=<%=studentAddr%>">上一页</a>
            <a href="StudentsPage.jsp?pageIndex=<%=(pageIndex+1)>totalPage?totalPage:(pageIndex+1)%>&studentName=<%=studentName%>&studentAddr=<%=studentAddr%>">下一页</a>
            <a href="StudentsPage.jsp?pageIndex=<%=totalPage%>&studentName=<%=studentName%>">尾页</a>


            <form action="StudentsPage.jsp" method="get">
                <input type="text" name="pageIndex" size="3" value="<%=pageIndex%>">
                <input type="submit" value="go">
            </form>

            <form action="StudentsPage.jsp" method="post">
                <input type="hidden" name="pageIndex" size="3" value="<%=pageIndex%>">
                请输入要查询的学生姓名：
                <input type="text" name="studentName" value="<%=studentName%>">
                请输入要查询的学生住址：
                <input type="text" name="studentAddr" value="<%=studentAddr%>">
                <input type="submit" value="查询">

            </form>


        </td>

    </tr>

    </table>
</body>
</html>
