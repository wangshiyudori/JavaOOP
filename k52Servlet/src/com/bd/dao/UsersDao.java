package com.bd.dao;

import com.bd.entity.Users;

public interface UsersDao {
    Users getUserByNameAndPwd(Users model);
}
