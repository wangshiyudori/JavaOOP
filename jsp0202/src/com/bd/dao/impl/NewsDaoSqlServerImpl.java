package com.bd.dao.impl;

import com.bd.dao.NewsDao;
import com.bd.entity.News;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class NewsDaoSqlServerImpl implements NewsDao {

    public void getConnection(){

        try {
            Class.forName("   ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DriverManager.getConnection("url","user","password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<News> getAll() {
        return null;
    }

    @Override
    public News getById(int newsID) {
        return null;
    }

    @Override
    public void insert(News entity) {

    }

    @Override
    public void deleteByID(int newsID) {

    }

    @Override
    public void update(News entity) {

    }
}
