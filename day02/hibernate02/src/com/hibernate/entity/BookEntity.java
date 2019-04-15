package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: BookEntity
 */

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "book", schema = "test", catalog = "")
public class BookEntity {
    private int bId;
    private byte[] bookImage;
    private String name;
    private Double price;
    private Timestamp publishDate;

    @javax.persistence.Id
    @javax.persistence.Column(name = "b_id")
    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "book_image")
    public byte[] getBookImage() {
        return bookImage;
    }

    public void setBookImage(byte[] bookImage) {
        this.bookImage = bookImage;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "publish_date")
    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bId == that.bId &&
                Arrays.equals(bookImage, that.bookImage) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(publishDate, that.publishDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bId, name, price, publishDate);
        result = 31 * result + Arrays.hashCode(bookImage);
        return result;
    }
}
