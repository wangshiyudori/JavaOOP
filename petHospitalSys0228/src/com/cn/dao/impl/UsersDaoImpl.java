package com.cn.dao.impl;

import com.cn.dao.UsersDao;
import com.cn.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl extends BaseDao implements UsersDao {
    @Override
    public Users getByName(String userName) {
        Users result = null;
        String sql = "select * from users where userName=?";
        Object[] objects = new Object[1];
        objects[0] = userName;
        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }

    @Override
    public Users getByID(int userID) {
        Users result = null;
        String sql = "select * from users where userID=?";
        Object[] objects = new Object[1];
        objects[0] = userID;
        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }

    @Override
    public List<Users> getAll() {
        List<Users> lists = new ArrayList<Users>();
        String sql = "select * from users";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                lists.add(users);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public List<Users> getAllPage(int pageIndex, int pageSize) {
        List<Users> lists = new ArrayList<Users>();
        String sql = "select * from users limit ?,?";

        Object[] objects = new Object[2];
        objects[0]=(pageIndex-1)*pageSize;
        objects[1]=pageSize;

        ResultSet resultSet = excuteQuery(sql,objects);
        try {
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                lists.add(users);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public boolean insert(Users model) {
        int result = -1;
        String sql = "insert into users (userRole,userName,userPwd,userTel,userAddress) values(?,?,?,?,?)";
        Object[] objs = new Object[5];
        objs[0] = model.getUserRole();
        objs[1] = model.getUserName();
        objs[2] = model.getUserPwd();
        objs[3] = model.getUserTel();
        objs[4] = model.getUserAddress();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(int userID) {
        int result = -1;
        String sql = "delete from users where userID=?";
        Object[] objs = new Object[1];
        objs[0] = userID;
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Users update(Users model) {
        int result = -1;
        String sql = "update users set userRole=?,userName=?,userPwd=?,userTel=?,userAddress=? where userID=?";
        Object[] objs = new Object[6];
        objs[0] = model.getUserRole();
        objs[1] = model.getUserName();
        objs[2] = model.getUserPwd();
        objs[3] = model.getUserTel();
        objs[4] = model.getUserAddress();
        objs[6] = model.getUserID();

        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return model;
        }else {
            return null;
        }
    }

}
