package com.cn.entity;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private int userID;
    private String userRole;
    private String userName;
    private String userPwd;
    private String userTel;
    private String userAddress;
    private List<Pets> pets = new ArrayList<Pets>();

    public Users() {
    }

    public Users(int userID, String userRole, String userName, String userPwd, String userTel, String userAddress) {
        this.userID = userID;
        this.userRole = userRole;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userTel = userTel;
        this.userAddress = userAddress;
    }

    public Users(int userID, String userRole, String userName, String userPwd, String userTel, String userAddress, List<Pets> pets) {
        this.userID = userID;
        this.userRole = userRole;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.pets = pets;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public List<Pets> getPets() {
        return pets;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }
}
