package com.example.aurora.lista;

/**
 * Created by Aurora on 2018/9/11.
 */

public class Order {

    private String orderNo,name,godate,city,buydate;
    private int count;

    public Order(String orderNo, String name, String goDate, String city, String buyDate, int count) {
        this.orderNo=orderNo;
        this.name=name;
        this.godate=goDate;
        this.city=city;
        this.buydate=buyDate;
        this.count=count;
    }


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGodate() {
        return godate;
    }

    public void setGodate(String godate) {
        this.godate = godate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }



}
