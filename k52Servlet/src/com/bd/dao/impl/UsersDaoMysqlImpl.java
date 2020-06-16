package com.bd.dao.impl;

import com.bd.dao.UsersDao;
import com.bd.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoMysqlImpl extends BaseDao implements UsersDao {
    @Override
    public Users getUserByNameAndPwd(Users model) {
        Users result = null;
        String sql = "select * from users where userName=? and userPwd=?";
        Object[] objects = new Object[2];
        objects[0] = model.getUserName();
        objects[1] = model.getUserPwd();
        System.out.println("objects[0]"+objects[0]);
        System.out.println("objects[1]"+objects[1]);

        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }
}
