package com.cn.dao.impl;

import com.cn.dao.VetsDao;
import com.cn.entity.Vets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VetsDaoImpl extends BaseDao implements VetsDao {
    @Override
    public List<Vets> getAll() {
        List<Vets> lists = new ArrayList<Vets>();
        String sql = "select * from vets";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                Vets vets = new Vets(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)
                );
                lists.add(vets);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public boolean insert(Vets model) {
        int result = -1;
        String sql = "insert into vets (vetName,departmentID) values(?,?)";
        Object[] objs = new Object[2];
        objs[0] = model.getVetName();
        objs[1] = model.getDepartmentID();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Vets getByVetName(String vetName) {
        Vets result = null;
        String sql = "select * from vets where vetName=?";
        Object[] objects = new Object[1];
        objects[0] = vetName;
        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new Vets(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }
}
