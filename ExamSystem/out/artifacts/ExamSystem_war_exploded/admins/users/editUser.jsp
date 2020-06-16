<%@ page import="com.cp.biz.UsersBiz" %>
<%@ page import="com.cp.biz.impl.UsersBizImpl" %>
<%@ page import="com.cp.entity.Users" %><%--
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

    String strUserID = request.getParameter("userID");
    
    String a = strUserID.trim();
    
    String userName = request.getParameter("userName");
    String userPwd = request.getParameter("userPwd");
    int userID = -1;
    if (strUserID != null){

        userID = Integer.parseInt(a);
        UsersBiz biz = new UsersBizImpl();
        
        Users entity = new Users(userID,userName,userPwd);
        if (userID==0){
            //代表所需要的insert
            biz.insert(entity);
        }else if (userID>0){
            biz.update(entity);
        }
        
        response.sendRedirect("UsersManager.jsp");
    }
%>
</body>
</html>
