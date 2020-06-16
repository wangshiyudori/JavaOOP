package com.cn.dao;

import com.cn.entity.Visits;

public interface VisitsDao {
    boolean insert(Visits model);
    Visits getByPetID(int petID);
}
