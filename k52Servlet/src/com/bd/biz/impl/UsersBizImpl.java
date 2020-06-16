package com.bd.biz.impl;

import com.bd.biz.UsersBiz;
import com.bd.dao.UsersDao;
import com.bd.dao.impl.UsersDaoMysqlImpl;
import com.bd.entity.Users;

public class UsersBizImpl implements UsersBiz {
    UsersDao dao = new UsersDaoMysqlImpl();
    @Override
    public Users login(Users model) {
        Users users = dao.getUserByNameAndPwd(model);
        return users;
    }
}
