package com.bd.servlet;

import com.bd.biz.UsersBiz;
import com.bd.biz.impl.UsersBizImpl;
import com.bd.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doGet");

        UsersBiz biz = new UsersBizImpl();
        List<Users> lists = biz.findAll();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"result\":\"ok\",");
        stringBuilder.append("\"data\":[");

        for (Users u : lists) {
            stringBuilder.append("{");
            stringBuilder.append("\"userID\":" + u.getUserID() + ",");
            stringBuilder.append("\"userName\":\"" + u.getUserName() + "\",");
            stringBuilder.append("\"userPwd\":\"" + u.getUserPwd() + "\"");
            stringBuilder.append("},");
        }
        //删掉最后一个大括号的逗号
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("],");
        stringBuilder.append("\"msg\":\"已经获取到全部数据！\"");
        stringBuilder.append("}");

        out.print(stringBuilder.toString());
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doPost");
//        PrintWriter out = resp.getWriter();
//        out.print("");
//    }
}
