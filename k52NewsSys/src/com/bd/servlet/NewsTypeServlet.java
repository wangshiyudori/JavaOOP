package com.bd.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bd.biz.NewstypeBiz;
import com.bd.biz.impl.NewsTypeBizImpl;
import com.bd.entity.DataGridVO;
import com.bd.entity.NewsType;
import com.bd.entity.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class NewsTypeServlet extends HttpServlet {

    //get findAll      /newsType  得到所有的类型列表
    //get findOne     /newsType/*  根据ID得到一个类型对象
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getPathInfo());
        String path = req.getPathInfo();
        NewstypeBiz biz = new NewsTypeBizImpl();
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String result = "";
        if (path != null) {
            //findOne
            String typeID = path.replace("/", "");
            NewsType model = biz.findOne(Integer.parseInt(typeID));
            result = JSON.toJSONString(model, SerializerFeature.WriteNullListAsEmpty);
        } else {
            //对获取的全部数据进行分页
            //java.lang.NumberFormatException: null 对空值进行处理
            String sPage = req.getParameter("page");
            if (sPage==null){
                sPage="1";
            }
            int pageIndex = Integer.parseInt(sPage);

            String sRows = req.getParameter("rows");
            if (sRows==null){
                sRows="5";
            }
            int pageSize = Integer.parseInt(sRows);

            if (pageIndex == 0) {
                pageIndex = 1;
            }

            //findAll
//            List<NewsType> lists = biz.findAll();
            List<NewsType> lists = biz.findAllPage(pageIndex, pageSize);
            DataGridVO<NewsType> dataGridVO = new DataGridVO<NewsType>();

//            dataGridVO.setTotal(lists.size());
            //集合的总数固定了每页写入5条，无法实现分页效果。所以通过获取全部数据的总数来灵活实现分页。
            dataGridVO.setTotal(biz.findAll().size());
            dataGridVO.setRows(lists);

            result = JSON.toJSONString(dataGridVO, SerializerFeature.WriteNullListAsEmpty);

        }
        out.print(result);
        out.flush();
        out.close();

    }


    //post insert   /newsType  新增一个newsTpe对象
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeName = req.getParameter("typeName");
        NewsType model = new NewsType();
        model.setTypeName(typeName);

        NewstypeBiz biz = new NewsTypeBizImpl();
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String result = "";
        boolean isInsert = biz.insert(model);

        Result result1 = null;
        if (isInsert) {
            result1 = new Result("OK");
        } else {
            result1 = new Result("ERROR");
        }
        result = JSON.toJSONString(result1, SerializerFeature.WriteNullListAsEmpty);

        out.print(result);
        out.flush();
        out.close();
    }


    //delete   delete   /newsType?typeID  删除一个对象
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeID = req.getParameter("typeID");

        NewstypeBiz biz = new NewsTypeBizImpl();
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String result = "";
        boolean isInsert = biz.delete(Integer.parseInt(typeID));
        //做空值判断
        Result result1 = null;
        if (isInsert) {
            result1 = new Result("OK");
        } else {
            result1 = new Result("ERROR");
        }
        result = JSON.toJSONString(result1, SerializerFeature.WriteNullListAsEmpty);

        out.print(result);
        out.flush();
        out.close();
    }


    //put  update    /newsType  修改一个对象

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("req.getQueryString:"+req.getQueryString());

        String typeID = req.getParameter("typeID");
        String typeName = req.getParameter("typeName");
        //做空值判断
        NewsType model = new NewsType();
        model.setTypeID(Integer.parseInt(typeID));
        model.setTypeName(typeName);


        NewstypeBiz biz = new NewsTypeBizImpl();
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String result = "";
        model = biz.update(model);

        result = JSON.toJSONString(model, SerializerFeature.WriteNullListAsEmpty);
        out.print(result);
        out.flush();
        out.close();
    }
}
