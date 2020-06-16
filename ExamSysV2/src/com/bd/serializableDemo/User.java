package com.bd.serializableDemo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String userName;
    private String userPwd;
    private Date birthday;

    public User() {
    }

    public User(int id, String userName, String userPwd, Date birthday) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.birthday = birthday;
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }



    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
