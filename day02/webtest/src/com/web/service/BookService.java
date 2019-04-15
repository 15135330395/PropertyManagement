package com.web.service;/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: BookService
 */

import com.web.dao.BookDao;
import com.web.dao.impl.BookDaoImpl;
import com.web.entity.Book;
import com.web.entity.PageBean;

import java.util.List;

public class BookService {

BookDao dao=new BookDaoImpl();

    public List<Book> findAll(){
        return dao.findAll();
    }

    public Book findByBId(int bId){
        return dao.findByBId(bId);
    }

    public int add(Book  book){
        return dao.add(book);
    }

    public int update(Book book) {

        return dao.update(book);
    }

    public int delete(int bId){
        return dao.delete(bId);
    }

    public List<Book> queryPage(PageBean pageBean){
        return dao.queryPage(pageBean);
    }

}
