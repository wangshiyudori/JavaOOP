package com.cn.dao.impl;

import com.cn.dao.PetsDao;
import com.cn.entity.Pets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetsDaoImpl extends BaseDao implements PetsDao {
    @Override
    public List<Pets> getAll() {
        List<Pets> lists = new ArrayList<Pets>();
        String sql = "select * from pets";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                Pets pets = new Pets(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
                lists.add(pets);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public List<Pets> getAllPage(int pageIndex, int pageSize) {
        List<Pets> lists = new ArrayList<Pets>();
        String sql = "select * from pets limit ?,?";

        Object[] objects = new Object[2];
        objects[0]=(pageIndex-1)*pageSize;
        objects[1]=pageSize;

        ResultSet resultSet = excuteQuery(sql,objects);
        try {
            while (resultSet.next()) {
                Pets pets = new Pets(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
                lists.add(pets);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public Pets getByOwnerID(int ownerID) {
        Pets result = null;
        String sql = "select * from pets where ownerID=?";
        Object[] objects = new Object[1];
        objects[0] = ownerID;
        ResultSet resultSet = excuteQuery(sql, objects);
        try {
            if (resultSet.next()) {
                result = new Pets(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return result;
    }

    @Override
    public boolean insert(Pets model) {
        int result = -1;
        String sql = "insert into pets (petName,birthDate,breed,ownerID) values(?,?,?,?)";
        Object[] objs = new Object[4];
        objs[0] = model.getPetName();
        objs[1] = model.getBirthDate();
        objs[2] = model.getBreed();
        objs[3] = model.getOwnerID();
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean delete(int petID) {
        int result = -1;
        String sql = "delete from pets where petID=?";
        Object[] objs = new Object[1];
        objs[0] = petID;
        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Pets update(Pets model) {
        int result = -1;
        String sql = "update pets set petName=?,birthDate=?,breed=?,ownerID=? where petID=?";
        Object[] objs = new Object[5];
        objs[0] = model.getPetName();
        objs[1] = model.getBirthDate();
        objs[2] = model.getBreed();
        objs[3] = model.getOwnerID();
        objs[4] = model.getPetID();

        connection = getConnection();
        result = excuteUpdate(sql, objs);
        if (result>0){
            return model;
        }else {
            return null;
        }
    }

}
