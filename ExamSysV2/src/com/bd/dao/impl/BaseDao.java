package com.bd.dao.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    //连接池
    public Connection getConnection() {
        Context ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        DataSource ds = null;
        try {
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        Context ctx=new InitialContext();
//        DataSource ds=(DataSource)ctx.lookup("java:comp/env/名称")
//        connection= ds.getConnection();


//        String url = "jdbc:mysql://localhost:3306/ExamSystem";
//        String user = "root";
//        String password = "root";
//        //1、加载驱动
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return connection;
    }

    public void closeAll() {
        try {
            if (resultSet!=null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        int result = -1;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeUpdate();
//            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int excuteUpdate(String sql, Object[] objs) {
        int result = -1;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (objs != null) {
                for (int i = 0; i < objs.length; i++) {
                    preparedStatement.setObject(i+1,objs[i]);
                }
            }
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        closeAll();
        return result;
    }

    public ResultSet excuteQuery(String sql){
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet excuteQuery(String sql,Object[] objs){
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (objs != null) {
                for (int i = 0; i < objs.length; i++) {
//                    System.out.println("param:"+objs[i]);
                    preparedStatement.setObject(i+1, objs[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


}
