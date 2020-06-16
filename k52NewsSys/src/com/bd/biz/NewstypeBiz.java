package com.bd.biz;

import com.bd.entity.NewsType;

import java.util.List;

public interface NewstypeBiz {
    /**
     * 获取所有新闻类别
     * @return
     */
    List<NewsType> findAll();

    /**
     * 获取全部数据中 某一页的数据
     * @param pageIndex
     * @return
     */
    List<NewsType> findAllPage(int pageIndex, int pageSize);

    /**
     * 根据ID查找新闻类别
     * @param typeID
     * @return
     */
    NewsType findOne(int typeID);

    /**
     * 新增一个新闻类别
     * @param model
     * @return
     */
    boolean insert(NewsType model);

    /**
     * 删除一个新闻类别
     * @param typeID
     * @return
     */
    boolean delete(int typeID);

    /**
     * 根据传进的实体进行更新
     * @param model
     * @return
     */
    NewsType update(NewsType model);
}
