package com.bd.dao.impl;

import com.bd.dao.NewsDao;
import com.bd.entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoMysqlImpl implements NewsDao {

    //把作用域/变量的范围 提到外面
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    private String url = "jdbc:mysql://localhost:3306/jdbc";
    private String user = "root";
    private String password = "root";


    public void getConnection(){
        //1. 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 获取连接

        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        //6. 释放资源
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<News> getAll() {
        List<News> result = new ArrayList<News>();
        String sql = "Select * from news";
        getConnection();

        //3. 创建statement命令对象
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //4. 执行sql语句

        try {
            resultSet = statement.executeQuery(sql);
            //5. 处理 Resultset

            while(resultSet.next()){
                News entity = new News();
                int newsID = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String content = resultSet.getString(3);

                entity.setNewsID(newsID);
                entity.setTitle(title);
                entity.setContent(content);

                result.add(entity);
                //System.out.println(newsID+","+title+","+content);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();

        return result;
    }



    @Override
    public News getById(int newsID) {
        String sql = "Select * from news where newsID="+newsID;
        News result = null;
        //jdbc操作的5个步骤走
        getConnection();
        //3. 创建statement命令对象
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //4. 执行sql语句
        try {
            resultSet = statement.executeQuery(sql);
            //5. 处理 Resultset
            //next 下移并判断有数据以后   get获取指向行的数据
            if (resultSet.next()){
                //遍历查询结果中的每一行
                result = new News(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close();
        return result;
    }

    @Override
    public void insert(News entity) {
        PreparedStatement preparedStatement = null;
        getConnection();
        String sql = "insert into news(title,content) values(?,?)";
        //3. 创建statement命令对象
        try {
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1,entity.getTitle());
             preparedStatement.setString(2,entity.getContent());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }


    @Override
    public void deleteByID(int newsID) {
        PreparedStatement preparedStatement = null;
        getConnection();
        String sql = "delete from news where newsID=?";
        //3. 创建statement命令对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,newsID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    @Override
    public void update(News entity) {
        PreparedStatement preparedStatement = null;
        getConnection();
        String sql = "update news set title=?,content=? where newsID=?";
        //3. 创建statement命令对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,entity.getTitle());
            preparedStatement.setString(2,entity.getContent());
            preparedStatement.setInt(3,entity.getNewsID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }


}
