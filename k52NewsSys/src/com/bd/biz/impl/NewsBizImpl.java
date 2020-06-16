package com.bd.biz.impl;

import com.bd.biz.NewsBiz;
import com.bd.dao.NewsDao;
import com.bd.dao.impl.NewsDaoMysqlImpl;
import com.bd.entity.News;

import java.util.List;

public class NewsBizImpl implements NewsBiz {
    NewsDao dao = new NewsDaoMysqlImpl();

    @Override
    public List<News> findAll() {
        return dao.findAll();
    }

    @Override
    public List<News> findAllPage(int pageIndex, int pageSize) {
        return dao.findAllPage(pageIndex, pageSize);
    }

    @Override
    public News findOne(int newsID) {
        return dao.findOne(newsID);
    }

    @Override
    public boolean insert(News model) {
        return dao.insert(model);
    }

    @Override
    public boolean delete(int newsID) {
        return dao.delete(newsID);
    }

    @Override
    public News update(News model) {
        return dao.update(model);
    }
}
