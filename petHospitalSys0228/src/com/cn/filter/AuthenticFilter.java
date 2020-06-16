package com.cn.filter;

import com.cn.entity.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("*.jsp")
public class AuthenticFilter implements Filter {
    private static List<String> adminAuths = new ArrayList<String>();
    static {
        adminAuths.add("/visitSearch_result.jsp");
        adminAuths.add("/visitAdd.jsp");
        adminAuths.add("/vetSearch_result.jsp");
        adminAuths.add("/vetSearch.html");
        adminAuths.add("/vetAdd.jsp");
        adminAuths.add("/petAdd.jsp");
        adminAuths.add("/customerSearch_result.jsp");
        adminAuths.add("/customerSearch.jsp");
        adminAuths.add("/customerDetail.jsp");
        adminAuths.add("/customerAdd.jsp");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("身份验证过滤器启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpreq = (HttpServletRequest)servletRequest;
        HttpSession session = httpreq.getSession(true);
        String requestURI = httpreq.getRequestURI();
        requestURI=requestURI.substring(requestURI.lastIndexOf("/")) ;
        if (adminAuths.contains(requestURI)){

            Users users = (Users) session.getAttribute("users");
            if (users==null){
                servletRequest.setAttribute("msg","请先登录");
                servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
            }else if (users.getUserRole().equals("admin")){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                servletRequest.setAttribute("msg","该页面只有管理员可以访问");
                servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
            }

        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("身份验证过滤器销毁");
    }
}
