package com.bd.servlet;

import com.bd.biz.UsersBiz;
import com.bd.biz.impl.UsersBizImpl;
import com.bd.entity.Users;
import com.bd.listener.MyFirstListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        Users users = new Users(userName,userPwd);
        UsersBiz biz =  new UsersBizImpl();
        users = biz.login(users);
        if (users==null){
            //登录失败
            System.out.println("登录失败");
            resp.sendRedirect("/index.jsp");
        }
        //else前面的共用。 整个else接if后面，走的是监听器，实现在线人数的统计
        else {
            System.out.println("登录成功");
            MyFirstListener myFirstListener = new MyFirstListener(users);
            req.getSession().setAttribute("loginUser",myFirstListener);
            req.getRequestDispatcher("./welcome.jsp").forward(req,resp);
        }











//        //整个else接if后面，走的是login登录业务
//        else {
//            //至少要记录user ID
//            System.out.println("登录成功");
//            //log4j
//
//            //通过用户名和密码登录后获取ID 1.session 记录用户ID
//            //req.getServletContext().setAttribute("loginUser",users.getUserID());
//            //2.session 记录用户对象user: 后续操作方便，但需要更多的储存空间
//            req.getServletContext().setAttribute("loginUser",users);
//            req.getRequestDispatcher("./welcome.jsp").forward(req,resp);
//        }


    }
}
