package com.bd.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bd.biz.UsersBiz;
import com.bd.biz.impl.UsersBizImpl;
import com.bd.entity.DataGridVO;
import com.bd.entity.Users;
import com.bd.entity.UsersVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersBiz biz = new UsersBizImpl();
        int pageIndex =Integer.parseInt(req.getParameter("page"));
        int pageSize = Integer.parseInt(req.getParameter("rows"));
        if (pageIndex==0){
            pageIndex=1;
        }

        //按照页数取结果
//        String sPageIndex = req.getParameter("pageIndex");
//        if (sPageIndex == null) {
//            sPageIndex = "1";
//        }
//        Integer pageIndex = Integer.parseInt(sPageIndex);


        List<Users> lists = biz.getPage(pageIndex);

//        List<Users> lists = biz.findAll();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        DataGridVO<Users> dataGridVO = new DataGridVO<Users>();
        int total = biz.getTotalSize();
        dataGridVO.setTotal(total);
        dataGridVO.setRows(lists);

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        //序列化
        String result = JSON.toJSONString(dataGridVO, SerializerFeature.WriteNullListAsEmpty);
        out.write(result);
        out.flush();









        //通过fastJSON 获取到数据库对应表的全部json数据
//        UsersBiz biz = new UsersBizImpl();
//        List<Users> lists = biz.findAll();
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("application/json");
//        PrintWriter out = resp.getWriter();
//
//        UsersVO usersVO = new UsersVO();
//        usersVO.setResult("ok");
//        usersVO.setData(lists);
//        usersVO.setMsg("已经获取到全部数据");
//
//        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
//        //如果Lists集合是空的话，写成一个null值
//        String result= JSON.toJSONString(usersVO, SerializerFeature.WriteNullListAsEmpty);
//        out.write(result);
//        out.flush();
//        out.close();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
