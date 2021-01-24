package com.jiangyu.strategy;

public class Product {
    private String name;
    private double price;
    private int count;
    private DiscountType type;//优惠类型
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public DiscountType getType() {
        return type;
    }
    public void setType(DiscountType type) {
        this.type = type;
    }
    public Product(String name, double price, int count, DiscountType type) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.type = type;
    }
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

}
