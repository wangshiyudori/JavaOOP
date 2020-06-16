package com.cp.dao.impl;

import com.cp.dao.UsersDao;
import com.cp.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoMysqlImpl extends BaseDao implements UsersDao {

    @Override
    public List<Users> findAll() {
        List<Users> lists = new ArrayList<Users>();
        String sql = "select * from users";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
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
    public Users findOne(int userID) {
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
                        resultSet.getString(3)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }

    @Override
    public int deleteOne(int userID) {
        int result = -1;
        String sql = "delete from users where userID=?";
        Object[] objs = new Object[1];
        objs[0] = userID;
        connection = getConnection();
        result = excuteUpdate(sql, objs);

        return result;
    }

    @Override
    public int insert(Users entity) {
        int result = -1;
        String sql = "insert into users (userName,userPwd) values(?,?)";
        Object[] objs = new Object[2];
        objs[0] = entity.getUserName();
        objs[1] = entity.getUserPwd();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        return result;
    }

    @Override
    public int update(Users entity) {
        int result = -1;
        String sql = "update users set userName=?,userPwd=? where userID=?";
        Object[] objs = new Object[3];
        objs[0] = entity.getUserName();
        objs[1] = entity.getUserPwd();
        objs[2] = entity.getUserID();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        return result;
    }

    @Override
    public List<Users> getPage(int pageIndex) {
        int pageSize = 5;
        List<Users> lists = new ArrayList<Users>();
        String sql = "select * from users limit ?,?";
        Object[] objs = new Object[2];
        objs[0] = (pageIndex - 1) * pageSize;
        objs[1] = pageSize;
        ResultSet resultSet = excuteQuery(sql, objs);
        try {
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
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
    public int getTotalSize() {
        int result = 0;
        String sql = "select count(*) from users";
        ResultSet resultSet = excuteQuery(sql);
        try {
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }



    @Override
    public List<Users> getPageByWhere(String userName, String userPwd, int pageIndex) {
        int pageSize = 5;
        List<Users> lists = new ArrayList<Users>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from users where 1=1");
        List<Object> list = new ArrayList<Object>();

        ResultSet resultSet = null;
        if (userName != null) {
            stringBuffer.append(" and userName like concat(?,'%')");
            list.add(userName);
        }
        if (userPwd != null) {
            stringBuffer.append(" and userPwd like concat(?,'%')");
            list.add(userPwd);
        }
        stringBuffer.append(" limit ?,?");
        list.add((pageIndex - 1) * pageSize);
        list.add(pageSize);

        Object[] objs = list.toArray();
        resultSet = excuteQuery(stringBuffer.toString(), objs);


        //模糊查询 一个条件
//        int pageSize = 5;
//        List<Users> lists = new ArrayList<Users>();
//        String sql = "select * from users where 1=1";
//        ResultSet resultSet = null;
//        if (userName!=""){
//            sql +=" and userName like ? limit ?,?";
//            Object[] objs = new Object[3];
//            objs[0] = "%" + userName + "%";
//            objs[1] = (pageIndex-1)*pageSize;
//            objs[2] = pageSize;
//            resultSet = excuteQuery(sql,objs);
//        }else {
//            sql +=" limit ?,?";
//            Object[] objs = new Object[2];
//            objs[0] = (pageIndex-1)*pageSize;
//            objs[1] = pageSize;
//            resultSet = excuteQuery(sql,objs);
//        }

        try {
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
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
    public int getTotalSizeByWhere(String userName, String userPwd) {
        int result = -1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select count(*) from users where 1=1");
        List<Object> list = new ArrayList<Object>();

        ResultSet resultSet = null;
        if (userName != null) {
            stringBuffer.append(" and userName like concat(?,'%')");
            list.add(userName);
        }
        if (userPwd != null) {
            stringBuffer.append(" and userPwd like concat(?,'%')");
            list.add(userPwd);
        }
        Object[] objs = list.toArray();
        if (objs.length > 0) {
            resultSet = excuteQuery(stringBuffer.toString(), objs);
        } else {
            resultSet = excuteQuery(stringBuffer.toString());
        }

//        int result = 0;
//        String sql = "select count(*) from users where 1=1";
//        ResultSet resultSet = null;
//        if (userName!=""){
//            if (userPwd!=""){
//                sql +=" and userName like ? and userPwd like ?";
//                Object[] objs = new Object[2];
//                objs[0] = "%" + userName + "%";
//                objs[1] = "%" + userPwd + "%";
//                resultSet = excuteQuery(sql,objs);
//            }else {
//                sql +=" and userName like ?";
//                Object[] objs = new Object[1];
//                objs[0] = "%" + userName + "%";
//                resultSet = excuteQuery(sql,objs);
//            }
//
//        }else {
//            if (userPwd!=""){
//                sql +=" and userPwd like ?";
//                Object[] objs = new Object[1];
//                objs[0] = "%" + userPwd + "%";
//                resultSet = excuteQuery(sql,objs);
//            }else {
//                resultSet = excuteQuery(sql);
//            }
//
//        }

        try {
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }
}
