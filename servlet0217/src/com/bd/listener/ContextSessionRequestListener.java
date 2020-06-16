package com.bd.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ContextSessionRequestListener implements ServletRequestListener, HttpSessionListener, ServletContextListener {
    //监听application（ServletContext）对象
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听application，创建application对象"+servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁application对象"+servletContextEvent);
    }

    //监听session对象
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("监听session，创建session对象"+httpSessionEvent);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("销毁session对象"+httpSessionEvent);
    }

    //监听request对象
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("监听request，创建request对象"+servletRequestEvent);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("销毁request对象"+servletRequestEvent);
    }




}
