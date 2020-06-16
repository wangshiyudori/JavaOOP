package com.cp.dao.impl;

import java.sql.*;

public class BaseDao {
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "root";

        if (connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connection = DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public static void closeAll(){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
//            if (connection!=null){
//                connection.close();
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
