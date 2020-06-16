package com.bd.dao.impl;

import com.bd.dao.NewsDao;
import com.bd.entity.News;
import com.bd.entity.NewsType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoMysqlImpl extends BaseDao implements NewsDao {
    @Override
    public List<News> findAll() {
        List<News> lists = new ArrayList<News>();
        String sql = "select * from news";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                News news = new News(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
                lists.add(news);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public List<News> findAllPage(int pageIndex, int pageSize) {
        List<News> lists = new ArrayList<News>();
        String sql = "select * from news limit ?,?";

        Object[] objects = new Object[2];
        objects[0]=(pageIndex-1)*pageSize;
        objects[1]=pageSize;

        ResultSet resultSet = excuteQuery(sql,objects);
        try {
            while (resultSet.next()) {
                News news = new News(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
                lists.add(news);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public News findOne(int newsID) {
        News result = null;
        String sql = "select * from news where newsID=?";
        Object[] objects = new Object[1];
        objects[0] = newsID;
        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new News(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }

    @Override
    public boolean insert(News model) {
        int result = -1;
        String sql = "insert into news (newsTitle,newsContent,typeID) values(?,?,?)";
        Object[] objs = new Object[3];
        objs[0] = model.getNewsTitle();
        objs[1] = model.getNewsContent();
        objs[2] = model.getTypeID();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean delete(int newsID) {
        int result = -1;
        String sql = "delete from news where newsID=?";
        Object[] objs = new Object[1];
        objs[0] = newsID;
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public News update(News model) {
        int result = -1;
        String sql = "update news set newsTitle=?,newsContent=?,typeID=? where newsID=?";
        Object[] objs = new Object[4];
        objs[0] = model.getNewsTitle();
        objs[1] = model.getNewsContent();
        objs[2] = model.getTypeID();
        objs[3] = model.getNewsID();

        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return model;
        }else {
            return null;
        }
    }
}
