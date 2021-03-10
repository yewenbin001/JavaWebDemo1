package com.demo.bean;

/**
 * @author ：小兵
 * @date ：2021-03-04 15:41
 * @Description:
 */
public class Good {
    private String Id;
    private String name;
    private double price;
    private String firm;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

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

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Override
    public String toString() {
        return "Good{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", firm='" + firm + '\'' +
                '}';
    }
}
