package com.cn.dao;

import com.cn.entity.Vets;

import java.util.List;

public interface VetsDao {
    List<Vets> getAll();
    boolean insert(Vets model);
    Vets getByVetName(String vetName);
}
