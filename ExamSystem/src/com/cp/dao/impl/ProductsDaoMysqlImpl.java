package com.cp.dao.impl;

import com.cp.dao.ProductsDao;
import com.cp.entity.Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDaoMysqlImpl extends BaseDao implements ProductsDao {
    @Override
    public void insert(Products entity) {
        int result = -1;
        String sql = "insert into products (productDesc) values(?)";
        Object[] objs = new Object[1];
        objs[0] = entity.getProductDesc();
        connection = getConnection();
        result = excuteUpdate(sql,objs);
    }

    @Override
    public List<Products> getAll() {

        List<Products> lists = new ArrayList<Products>();
        String sql = "select * from products";
        ResultSet resultSet = excuteQuery(sql);
        try {
            while (resultSet.next()) {
                Products products = new Products(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                lists.add(products);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return lists;
    }

    @Override
    public Products getOne(int productID) {
        Products products = null;
        String sql = "select * from products where productID=?";
        Object[] objs = new Object[1];
        objs[0] = productID;
        ResultSet resultSet = excuteQuery(sql,objs);
        try {
            if (resultSet.next()) {
                products = new Products(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        closeAll();
        return products;
    }
}
