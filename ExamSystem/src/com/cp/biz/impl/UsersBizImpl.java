package com.cp.biz.impl;

import com.cp.biz.UsersBiz;
import com.cp.dao.UsersDao;
import com.cp.dao.impl.UsersDaoMysqlImpl;
import com.cp.entity.Users;

import java.util.List;

public class UsersBizImpl implements UsersBiz {
    UsersDao dao = new UsersDaoMysqlImpl();
    @Override
    public List<Users> findAll() {
        return dao.findAll();
    }

    @Override
    public Users findOne(int userID) {
        return dao.findOne(userID);
    }

    @Override
    public int deleteOne(int userID) {
        return dao.deleteOne(userID);
    }

    @Override
    public int insert(Users entity) {
        return dao.insert(entity);
    }

    @Override
    public int update(Users entity) {
        return dao.update(entity);
    }

    @Override
    public List<Users> getPage(int pageIndex) {
        return dao.getPage(pageIndex);
    }

    @Override
    public int getTotalSize() {
        return dao.getTotalSize();
    }

    @Override
    public List<Users> getPageByWhere(String userName, String userPwd, int pageIndex) {
        return dao.getPageByWhere(userName, userPwd, pageIndex);
    }

    @Override
    public int getTotalSizeByWhere(String userName,String userPwd) {
        return dao.getTotalSizeByWhere(userName,userPwd);
    }
}
