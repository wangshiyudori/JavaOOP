package com.cn.dao;

import com.cn.entity.Pets;

import java.util.List;

public interface PetsDao {
    //获取所有数据
    List<Pets> getAll();

    //获取全部数据中 某一页的数据
    List<Pets> getAllPage(int pageIndex,int pageSize);

    //根据ID查找
    Pets getByOwnerID(int ownerID);

    //新增
    boolean insert(Pets model);

    //删除
    boolean delete(int petID);

    //根据传进的实体进行更新 改
    Pets update(Pets model);
}
