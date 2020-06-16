package com.bd.dao.impl;

import com.bd.dao.NewsTypeDao;
import com.bd.entity.NewsType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsTypeDaoMysqlImpl extends BaseDao implements NewsTypeDao {

    @Override
    public List<NewsType> findAll() {
        List<NewsType> lists = new ArrayList<NewsType>();
        String sql = "select * from newsType";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                NewsType newsType = new NewsType(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                lists.add(newsType);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public List<NewsType> findAllPage(int pageIndex,int pageSize) {
        List<NewsType> lists = new ArrayList<NewsType>();
        String sql = "select * from newsType limit ?,?";

        Object[] objects = new Object[2];
        objects[0]=(pageIndex-1)*pageSize;
        objects[1]=pageSize;

        ResultSet resultSet = excuteQuery(sql,objects);
        try {
            while (resultSet.next()) {
                NewsType newsType = new NewsType(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                lists.add(newsType);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public NewsType findOne(int typeID) {

        NewsType result = null;
        String sql = "select * from newsType where typeID=?";
        Object[] objects = new Object[1];
        objects[0] = typeID;
        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new NewsType(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }

    @Override
    public boolean insert(NewsType model) {
        int result = -1;
        String sql = "insert into newsType (typeName) values(?)";
        Object[] objs = new Object[1];
        objs[0] = model.getTypeName();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean delete(int typeID) {
        int result = -1;
        String sql = "delete from newsType where typeID=?";
        Object[] objs = new Object[1];
        objs[0] = typeID;
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public NewsType update(NewsType model) {

        int result = -1;
        String sql = "update newsType set typeName=? where typeID=?";
        Object[] objs = new Object[2];
        objs[0] = model.getTypeName();
        objs[1] = model.getTypeID();

        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return model;
        }else {
            return null;
        }

    }

}
