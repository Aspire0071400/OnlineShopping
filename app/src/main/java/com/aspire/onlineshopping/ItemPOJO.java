package com.aspire.onlineshopping;

public class ItemPOJO {
    private final int productView;
    private final String brandName;
    private final String productDescription;
    private final String price;
    private final int cart;

    public int getCart() {
        return cart;
    }

    public int getProductView() {
        return productView;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getPrice() {
        return price;
    }

    public ItemPOJO(int productView, String brandName, String productDescription, String price,int cart) {
        this.productView = productView;
        this.brandName = brandName;
        this.productDescription = productDescription;
        this.price = price;
        this.cart = cart;
    }
}
