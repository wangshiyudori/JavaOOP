package com.cn.entity;

import java.util.ArrayList;
import java.util.List;

public class Vets {
    private int vetID;
    private String vetName;
    private int departmentID;

    public Vets() {
    }

    public Vets(int vetID, String vetName, int departmentID) {
        this.vetID = vetID;
        this.vetName = vetName;
        this.departmentID = departmentID;
    }

    public int getVetID() {
        return vetID;
    }

    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
}
