package com.cp.test;

import com.cp.biz.UserBiz;
import com.cp.biz.impl.UserBizImpl;
import com.cp.dao.UserDao;
import com.cp.dao.impl.UserDaoMysqlImpl;
import com.cp.entity.User;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserBiz biz = new UserBizImpl();

        //1、查找全部数据
//        List<User> lists = biz.getAll();
//        for (User u : lists){
//            System.out.println(u.getId()+"\t"+u.getUserName()+"\t"+u.getPassword());
//        }

        //2、通过ID查找一条数据
//        User entity = biz.getById(2);
//        System.out.println(entity.getId()+"\t"+entity.getUserName()+"\t"+entity.getPassword());

//3、添加一条数据
//        User entity = new User("bb","666");
//        biz.insert(entity);
//        List<User> lists = biz.getAll();
//        for (User u : lists){
//            System.out.println(u.getId()+","+u.getUserName()+",\t"+u.getPassword());
//        }
// 4、删除一条数据
//        biz.deleteByID(9);
//        List<User> lists = biz.getAll();
//        for (User u : lists) {
//            System.out.println(u.getId() + "," + u.getUserName() + ",\t" + u.getPassword());
//        }
//5、修改一条数据
        User entity = new User(7,"lisa","666");
        biz.update(entity);
        List<User> lists = biz.getAll();
        for (User u : lists) {
            System.out.println(u.getId() + "," + u.getUserName() + ",\t" + u.getPassword());
        }
    }
}
