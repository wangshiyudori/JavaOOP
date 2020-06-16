package com.cp.dao;

import com.cp.entity.Users;

import java.util.List;

public interface UsersDao {
    List<Users> findAll();
    Users findOne(int userID);
    int deleteOne(int userID);
    int insert(Users entity);
    int update(Users entity);

    List<Users> getPage(int pageIndex);
    int getTotalSize();

    List<Users> getPageByWhere(String userName, String userPwd, int pageIndex);
    int getTotalSizeByWhere(String userName,String userPwd);
}
