package com.bd.biz;

import com.bd.entity.Users;

public interface UsersBiz {
    //登录 为上层提供服务，谁调用biz谁就是上层，之前是jsp，现在是servlet
    Users login(Users model);
}
