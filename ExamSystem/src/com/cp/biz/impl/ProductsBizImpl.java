package com.cp.biz.impl;

import com.cp.biz.ProductsBiz;
import com.cp.dao.ProductsDao;
import com.cp.dao.impl.ProductsDaoMysqlImpl;
import com.cp.entity.Products;

import java.util.List;

public class ProductsBizImpl implements ProductsBiz {
    ProductsDao dao = new ProductsDaoMysqlImpl();
    @Override
    public void insert(Products entity) {
        dao.insert(entity);
    }

    @Override
    public List<Products> getAll() {
        return dao.getAll();
    }

    @Override
    public Products getOne(int productID) {
        return dao.getOne(productID);
    }
}
