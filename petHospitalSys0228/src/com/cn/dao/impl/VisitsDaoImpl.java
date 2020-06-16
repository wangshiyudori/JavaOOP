package com.cn.dao.impl;

import com.cn.dao.VisitsDao;
import com.cn.entity.Visits;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitsDaoImpl extends BaseDao implements VisitsDao {

    @Override
    public boolean insert(Visits model) {
        int result = -1;
        String sql = "insert into visits (petID,ownerID,vetID,visitDate,description,treatment) values(?,?,?,?,?,?)";
        Object[] objs = new Object[6];
        objs[0] = model.getPetID();
        objs[1] = model.getOwnerID();
        objs[2] = model.getVetID();
        objs[3] = model.getVisitDate();
        objs[4] = model.getDescription();
        objs[4] = model.getTreatment();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Visits getByPetID(int petID) {
        Visits result = null;
        String sql = "select * from visits where petID=?";
        Object[] objects = new Object[1];
        objects[0] = petID;
        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new Visits(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }
}
