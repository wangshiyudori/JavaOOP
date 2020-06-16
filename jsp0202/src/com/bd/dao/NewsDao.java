package com.bd.dao;

import com.bd.entity.News;

import java.util.List;

public interface NewsDao {
    List<News> getAll();
    News getById(int newsID);
    void insert(News entity);
    void deleteByID(int newsID);
    void update(News entity);
}
