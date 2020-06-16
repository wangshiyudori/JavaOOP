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

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

//        String id = req.getParameter("userID");
//        System.out.println(id);

        int userID = Integer.parseInt(req.getParameter("userID")) ;

        UsersBiz biz =new UsersBizImpl();
        biz.deleteOne(userID);
        PrintWriter out = resp.getWriter();
        out.print("删除成功。");
        out.flush();
        out.close();
    }
}
