package com.cp.biz;

import com.cp.entity.User;

import java.util.List;

public interface UserBiz {
    List<User> getAll();
    User getById(int userID);
    void insert(User entity);
    void deleteByID(int userID);
    void update(User entity);
}
