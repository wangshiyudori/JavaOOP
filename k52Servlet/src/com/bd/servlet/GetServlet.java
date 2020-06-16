package com.bd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("req:"+req.getCharacterEncoding());
//        System.out.println("resp:"+resp.getCharacterEncoding());

        String userName = req.getParameter("userName");
        req.setAttribute("userName",userName);
        req.getRequestDispatcher("./list.jsp").forward(req,resp);
    }
}
