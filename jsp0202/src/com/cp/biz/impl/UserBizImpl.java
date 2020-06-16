package com.cp.biz.impl;

import com.cp.biz.UserBiz;
import com.cp.dao.UserDao;
import com.cp.dao.impl.UserDaoMysqlImpl;
import com.cp.entity.User;

import java.util.List;

public class UserBizImpl implements UserBiz {
    @Override
    public List<User> getAll() {
        UserDao dao =new UserDaoMysqlImpl();
        return dao.getAll();
    }

    @Override
    public User getById(int userID) {
        UserDao dao =new UserDaoMysqlImpl();
        return dao.getById(2);
    }

    @Override
    public void insert(User entity) {
        UserDao dao = new UserDaoMysqlImpl();
        dao.insert(entity);
    }

    @Override
    public void deleteByID(int userID) {
        UserDao dao = new UserDaoMysqlImpl();
        dao.deleteByID(userID);
    }

    @Override
    public void update(User entity) {
        UserDao dao = new UserDaoMysqlImpl();
        dao.update(entity);
    }
}
