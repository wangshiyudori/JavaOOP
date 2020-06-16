package com.cn.dao;

import com.cn.entity.Users;

import java.util.List;

public interface UsersDao {
    //根据用户姓名查询用户信息
    Users getByName(String userName);

    //根据ID查找
    Users getByID(int userID);

    //获取所有数据
    List<Users> getAll();

    //获取全部数据中 某一页的数据
    List<Users> getAllPage(int pageIndex,int pageSize);

    //新增
    boolean insert(Users model);

    //删除
    boolean delete(int userID);

    //根据传进的实体进行更新
    Users update(Users model);

}
