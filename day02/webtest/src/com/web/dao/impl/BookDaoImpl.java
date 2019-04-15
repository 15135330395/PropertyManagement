package com.web.dao.impl;/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: BookDaoImpl
 */

import com.web.dao.BookDao;
import com.web.entity.Book;
import com.web.entity.PageBean;
import com.web.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
    QueryRunner qr=new QueryRunner();
    @Override
    public List<Book> findAll() {
    String sql="select * from book";
       List<Book> list=new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              Book book=new Book();
               book.setb_Id(rs.getInt("b_id"));

                book.setName(rs.getString("name"));
                book.setPrice(rs.getFloat("price"));
                book.setPublish_date(rs.getDate("publish_date"));
              list.add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Book findByBId(int bId) {
        String sql="select * from book where b_id=?";
       Book book=new Book();
        try {
             book = qr.query(sql, new BeanHandler<>(Book.class), bId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public int add(Book book) {
       String sql="insert into book (name,price,publish_date) values(?,?,?)";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, book.getName(), book.getPrice(), book.getPublishDate());
        return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Book book) {
        String sql="update book set(name=? , price=? , publish_date=? ) where b_id=? ";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, book.getName(), book.getPrice(), book.getPublishDate(),book.getbId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int bId) {
       String sql="delete from book where b_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, bId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> queryPage(PageBean pageBean){
      String sql="select * from book order by publish_date desc limit ?,?";
      List<Book> list=new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getPageIndex());
            ps.setInt(2,pageBean.getPageCount());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Book book=new Book();
                book.setb_Id(rs.getInt("b_id"));

                book.setName(rs.getString("name"));
                book.setPrice(rs.getFloat("price"));
                book.setPublish_date(rs.getDate("publish_date"));
                list.add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}
