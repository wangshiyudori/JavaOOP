package com.bd.biz.impl;

import com.bd.biz.NewsBiz;
import com.bd.dao.NewsDao;
import com.bd.dao.impl.NewsDaoMysqlImpl;
import com.bd.entity.News;

import java.util.List;

public class NewsBizImpl implements NewsBiz {
    @Override
    public List<News> getAll() {
        NewsDao dao = new NewsDaoMysqlImpl();
        return dao.getAll();
    }


}
