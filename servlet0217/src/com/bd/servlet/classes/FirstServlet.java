package com.bd.servlet.classes;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化
        System.out.println("init.....");
        String userName = servletConfig.getInitParameter("userName");
        System.out.println(userName);

        String aaa = servletConfig.getServletContext().getInitParameter("aaa");
        System.out.println(aaa);
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("获取servletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("提供服务");
        ServletContext context = servletRequest.getServletContext();
        PrintWriter out = servletResponse.getWriter();
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
//        byte[] content = "中文".getBytes("iso-8859-1");
        out.write("k52第一个");
        out.close();
    }

    @Override
    public String getServletInfo() {
        System.out.println("获取信息");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁对象");

    }
}
