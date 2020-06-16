package com.cn.dao.impl;

import com.cn.dao.DepartmentsDao;
import com.cn.entity.Departments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDaoImpl extends BaseDao implements DepartmentsDao {
    @Override
    public List<Departments> getAll() {
        List<Departments> lists = new ArrayList<Departments>();
        String sql = "select * from departments";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                Departments departments = new Departments(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                lists.add(departments);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }
}
