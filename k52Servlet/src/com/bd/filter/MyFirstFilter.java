package com.bd.filter;

import com.bd.entity.Users;
import com.bd.listener.MyFirstListener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getInitParameter("");
        System.out.println("Filter启动init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        servletRequest.setCharacterEncoding("utf-8");
//        servletResponse.setCharacterEncoding("utf-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Users loginUser =  ((MyFirstListener)request.getSession().getAttribute("loginUser")).getUsers();
        if (loginUser == null) {
            servletRequest.getRequestDispatcher("/1.jsp").forward(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }





  //过滤器
//        Users loginUser = (Users)servletRequest.getServletContext().getAttribute("loginUser");
//        if (loginUser == null) {
//            servletRequest.getRequestDispatcher("/1.jsp").forward(servletRequest, servletResponse);
//        }else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//
//        System.out.println("doFilter");


    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
