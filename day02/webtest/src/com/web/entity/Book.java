package com.web.entity;/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: Book
 */

import java.sql.Blob;
import java.util.Date;

public class Book {
    private int bId;

    private String name;
    private float price;
    private Date publishDate;

    public int getbId() {
        return bId;
    }

    public void setb_Id(int bId) {
        this.bId = bId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublish_date(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Book(int bId, Blob bookImage, String name, float price, Date publishDate) {
        this.bId = bId;

        this.name = name;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Book(String name, float price, Date publishDate) {
        this.name = name;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId=" + bId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
