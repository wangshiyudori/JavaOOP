package com.cp.dao;

import com.cp.entity.Products;

import java.util.List;

public interface ProductsDao {
    void insert(Products entity);
    List<Products> getAll();
    Products getOne(int productID);
}
