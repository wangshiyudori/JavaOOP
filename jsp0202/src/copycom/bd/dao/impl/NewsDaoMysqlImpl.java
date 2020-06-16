package copycom.bd.dao.impl;

import copycom.bd.dao.NewsDao;
import copycom.bd.entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoMysqlImpl implements NewsDao {

    public void getConnection(){

    }

    public List<News> getAll() {
        List<News> result = new ArrayList<News>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "Select * from news";
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "root";
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
                System.out.println(newsID+","+title+","+content);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //5. 释放资源
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public News getById(int newsID) {
        return null;
    }


}
