package com.bd.biz;

import com.bd.entity.News;

import java.util.List;

public interface NewsBiz {
    /**
     * 获取所有新闻类别
     * @return
     */
    List<News> findAll();


    /**
     * 获取全部数据中 某一页的数据
     * @param pageIndex
     * @return
     */
    List<News> findAllPage(int pageIndex,int pageSize);

    /**
     * 根据ID查找新闻类别
     * @param newsID
     * @return
     */
    News findOne(int newsID);

    /**
     * 新增一个新闻类别
     * @param model
     * @return
     */
    boolean insert(News model);

    /**
     * 删除一个新闻类别
     * @param newsID
     * @return
     */
    boolean delete(int newsID);

    /**
     * 根据传进的实体进行更新
     * @param model
     * @return
     */
    News update(News model);
}
