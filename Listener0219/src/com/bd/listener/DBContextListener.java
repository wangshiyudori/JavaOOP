package com.bd.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//application
public class DBContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("url", "aaaa");
        System.out.println("上下文初始化。。。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("毁灭。。。。");
    }
}
