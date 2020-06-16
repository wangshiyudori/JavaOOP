package com.bd.servlet.classes;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        ServletContext context = servletRequest.getServletContext();
        PrintWriter out = servletResponse.getWriter();
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
//        byte[] content = "中文".getBytes("iso-8859-1");
        out.write("kkkkk52第一个");
        out.close();
    }
}
