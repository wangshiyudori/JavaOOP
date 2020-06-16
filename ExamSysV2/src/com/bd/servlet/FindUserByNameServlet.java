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

public class FindUserByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String userName = req.getParameter("userName");
        //2、通过biz对象进行数据的查找
        UsersBiz biz = new UsersBizImpl();
        Users users =new Users();
        users.setUserName(userName);

        //3、得到查找的数据
        users=biz.findByUserName(users);
//        System.out.println("servlet"+users);
        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset:UTF-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();


//        //4、true/false
//        if (users!=null){
//            out.print("{\n" +
//                    "    'result':\"'ok'\",\n" +
//                    "    'data':\"true\",\n" +
//                    "    'msg':\"用户已存在！\"\n" +
//                    "}");
//
//        }else {
//            out.print("{\n" +
//                    "    'result':\"'ok'\",\n" +
//                    "    'data':\"false\",\n" +
//                    "    'msg':\"\"\n" +
//                    "}");
//        }



        //替代之前的完成服务器端的json化
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        if (users!=null){
            stringBuilder.append("\"result\":\"ok\",");
            stringBuilder.append("\"data\":true,");
            stringBuilder.append("\"msg\":\"用户名已存在！\"");
        }else {
            stringBuilder.append("\"result\":\"ok\",");
            stringBuilder.append("\"data\":false,");
            stringBuilder.append("\"msg\":\"\"");
        }
        stringBuilder.append("}");
        out.print(stringBuilder.toString());
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        System.out.println("doPost");
//        PrintWriter out = resp.getWriter();
//        out.print("");
    }
}
