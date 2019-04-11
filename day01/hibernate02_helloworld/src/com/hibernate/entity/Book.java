package com.hibernate.entity;
/*
 * @author :张
 * Date  : 2019/4/8
 * @Description: Book
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name="BOOK")
public class Book {
    private Integer bid;
    private String name;
    private float price;
    private Date publishDate;   //数据库默认date格式为yyyy-MM-dd。
    private Blob bookImage;     //二进制文件

    @Id
    @GenericGenerator(name="_native",strategy="native")//注解---自定义主键生成策略
    @GeneratedValue(generator = "native")//注解---JPA通用策略生成器
    @Column(name = "b_id")  //列名，写在get方法上
    public Integer getBid() {
        return bid;
    }



    public void setBid(Integer bid) {
        this.bid = bid;
    }
@Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
@Column(name="publish_date" )     //注解上没有类型，自动识别
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
@Column(name="book_image")
    public Blob getBookImage() {
        return bookImage;
    }

    public void setBookImage(Blob bookImage) {
        this.bookImage = bookImage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", bookImage=" + bookImage +
                '}';
    }
}
