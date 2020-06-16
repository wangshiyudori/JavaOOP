package com.cn.servlet;

import com.cn.dao.UsersDao;
import com.cn.dao.impl.UsersDaoImpl;
import com.cn.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url=null;
        String msg=null;
        String realcode= req.getSession(true).getAttribute("realcode").toString();
        String inputcode = req.getParameter("checkcode");
        if (realcode.equalsIgnoreCase(inputcode)){
            UsersDao usersDao = new UsersDaoImpl();
             Users users = usersDao.getByName(req.getParameter("userName"));

            if (users==null){
                url="/index.jsp";
                msg="用户不存在";
            }else if (!users.getUserPwd().equals(req.getParameter("userPwd"))){
                url="/index.jsp";
                msg="密码错误";
            }else {
                req.getSession(true).setAttribute("users",users);
                if (users.getUserRole().equals("admin")){
                    url="/vetSearch.html";
                }else if (users.getUserRole().equals("customer")){
                    url="/customerSearch.jsp";
                }
                msg="登录成功";
            }


        }else {
            url="/index.jsp";
            msg="验证码有误";
        }

        req.setAttribute("msg",msg);
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
