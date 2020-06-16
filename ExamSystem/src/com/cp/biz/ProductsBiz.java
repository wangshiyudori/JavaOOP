package com.cp.biz;

import com.cp.entity.Products;

import java.util.List;

public interface ProductsBiz {
    void insert(Products entity);
    List<Products> getAll();
    Products getOne(int productID);
}

