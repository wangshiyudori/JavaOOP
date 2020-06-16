package com.bd.biz.impl;

import com.bd.biz.NewstypeBiz;
import com.bd.dao.NewsTypeDao;
import com.bd.dao.impl.NewsTypeDaoMysqlImpl;
import com.bd.entity.NewsType;

import java.util.List;

public class NewsTypeBizImpl implements NewstypeBiz {
    NewsTypeDao dao = new NewsTypeDaoMysqlImpl();

    public List<NewsType> findAll() {
        return dao.findAll();
    }

    @Override
    public List<NewsType> findAllPage(int pageIndex, int pageSize) {
        return dao.findAllPage(pageIndex, pageSize);
    }

    public NewsType findOne(int typeID) {
        return dao.findOne(typeID);
    }

    public boolean insert(NewsType model) {
        return dao.insert(model);
    }

    public boolean delete(int typeID) {
        return dao.delete(typeID);
    }

    public NewsType update(NewsType model) {
        return dao.update(model);
    }
}
