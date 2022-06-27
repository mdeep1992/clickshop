package com.example.clickshop;


public class ProductOrder  {
    final String title;
    final String imageUrl;
    final double price;
    final double rating;
    final String id;

    public ProductOrder(String title, String imageUrl, double price, double rating, String id) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
        this.rating = rating;
        this.id = id;
    }
}
