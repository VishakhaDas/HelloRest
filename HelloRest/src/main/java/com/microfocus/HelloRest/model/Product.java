package com.microfocus.HelloRest.model;

public class Product {

    int productId;
    String produtName;
    String productCategory;
    double productPrice;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Product(int productId, String produtName, String productCategory, double productPrice) {
        this.productId = productId;
        this.produtName = produtName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }
}
