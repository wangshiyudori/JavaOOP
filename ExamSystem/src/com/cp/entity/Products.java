package com.cp.entity;

public class Products {
    private int productID;
    private String productDesc;

    public Products() {
    }

    public Products(String productDesc) {
        this.productDesc = productDesc;
    }

    public Products(int productID, String productDesc) {
        this.productID = productID;
        this.productDesc = productDesc;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
