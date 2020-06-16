package com.bd.entity;

import java.io.Serializable;
import java.util.List;

//VO:view object. UsersVO类作为FindAllUsersServlet类的json输出类
public class UsersVO implements Serializable {
    private String result;
    private List<Users> data;
    private String msg;

    public UsersVO() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Users> getData() {
        return data;
    }

    public void setData(List<Users> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
