package com.cp.test;

import com.cp.biz.UsersBiz;
import com.cp.biz.impl.UsersBizImpl;
import com.cp.entity.Users;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        UsersBiz biz = new UsersBizImpl();

//        Users users = biz.findOne(3);
//        System.out.println(users.getUserName()+"\t"+users.getUserPwd());

        Users users = new Users(6,"kgccc","kgccc");
//        biz.insert(users);
//        biz.update(users);
        biz.deleteOne(7);

        List<Users> lists = biz.findAll();
        for (Users u : lists ){
            System.out.println(u.getUserID()+"\t"+u.getUserName()+"\t"+u.getUserPwd());
        }

    }
}
