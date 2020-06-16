package com.bd.listener;

import com.bd.entity.Users;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//单个在线人数统计   HttpSessionBindingListener必须实例化后放入某一个session中，才能监听。
public class MyFirstListener implements HttpSessionBindingListener {

    private Users users;

    public MyFirstListener(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("valueBound方法执行了。。。。");
        System.out.println("event.getName():"+event.getName());
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();

        Integer total = (Integer)application.getAttribute("total");
        if (users!=null){
            if (total==null){
                Integer integer = 1;
                application.setAttribute("total",integer);
            }else {
                total++;
                application.setAttribute("total",total);
            }
        }

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("event.getName():"+event.getName());
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
        Integer total = (Integer)application.getAttribute("total");
        if (this.users!=null){
            if (total==null){
                Integer integer=1;
                application.setAttribute("total",integer);
            }else {
                total--;
                application.setAttribute("total",total);
            }
        }

    }
}
