package com.cp.dao.impl;

import com.bd.entity.News;
import com.cp.dao.UserDao;
import com.cp.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoMysqlImpl extends BaseDao implements UserDao {
    @Override
    public List<User> getAll() {
        List<User> lists = new ArrayList<User>();
        Connection connection = getConnection();
        String sql = "Select * from user";
        try {
            this.preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                lists.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAll();
        return lists;
    }

    @Override
    public User getById(int userID) {
        User result = null;

        getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from user where userID="+userID;
        try {
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                result = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeAll();

        return result;
    }

    @Override
    public void insert(User entity) {
        getConnection();
        String sql = "insert into user(userName,password) values(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,entity.getUserName());
            preparedStatement.setString(2,entity.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAll();
    }


    @Override
    public void deleteByID(int userID) {
        getConnection();
        String sql = "delete from user where userID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeAll();
    }

    @Override
    public void update(User entity) {
        getConnection();
        String sql = "update user set userName=?,password=? where userID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,entity.getUserName());
            preparedStatement.setString(2,entity.getPassword());
            preparedStatement.setInt(3,entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeAll();
    }
}
