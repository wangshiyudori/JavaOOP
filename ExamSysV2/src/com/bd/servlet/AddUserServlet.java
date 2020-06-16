package com.bd.servlet;

import com.bd.biz.UsersBiz;
import com.bd.biz.impl.UsersBizImpl;
import com.bd.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        Users users = new Users(userName,userPwd);
        UsersBiz biz = new UsersBizImpl();
        biz.insert(users);
        PrintWriter out = resp.getWriter();
        out.print("添加成功");
        out.flush();
        out.close();

    }
}
