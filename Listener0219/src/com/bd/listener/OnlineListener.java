package com.bd.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//监听在线总人数  HttpSessionListener只需要设置到web.xml就可以监听整个应用中的所有session
public class OnlineListener implements HttpSessionListener {
    private int total=0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        total++;
        System.out.println("create total"+total);
        se.getSession().getServletContext().setAttribute("online",total);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        total--;
        System.out.println("destroy total"+total);
        se.getSession().getServletContext().setAttribute("online",total);
    }
}
