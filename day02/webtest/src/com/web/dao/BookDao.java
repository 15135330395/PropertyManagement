package com.web.dao;/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: BookDao
 */

import com.web.dao.impl.BookDaoImpl;
import com.web.entity.Book;
import com.web.entity.PageBean;

import java.util.List;

public interface BookDao {

    BookDao dao=new BookDaoImpl();

    public List<Book> findAll();

    public Book findByBId(int bId);

    public int add(Book  book);

    public int update(Book book);

    public int delete(int bId);

    public List<Book> queryPage(PageBean pageBean);






}
