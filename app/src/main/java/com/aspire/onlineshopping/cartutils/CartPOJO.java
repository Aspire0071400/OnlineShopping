package com.aspire.onlineshopping.cartutils;

public class CartPOJO {
    private final String productView;
    private final String brandName;
    private final String productDescription;
    private final String price;


    public String getProductView() {
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


    public CartPOJO(String productView, String brandName, String productDescription, String price) {
        this.productView = productView;
        this.brandName = brandName;
        this.productDescription = productDescription;
        this.price = price;
    }
}
