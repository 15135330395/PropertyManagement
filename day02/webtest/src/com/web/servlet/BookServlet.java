package com.web.servlet;

import com.web.entity.Book;
import com.web.entity.PageBean;
import com.web.service.BookService;
import com.web.util.DateUtil;
import com.web.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: ${NAME}
 */
@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {

  BookService bookService=new BookService();


   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");


       String action = request.getParameter("action");
       System.out.println("bookServlet..."+action);

     if("query".equals(action)){
       query(request,response);
     }else if("add".equals(action)){
         add(request,response);
     }else if("update".equals(action)){
         update(request,response);
     }else if("delete".equals(action)){
         delete(request,response);
     }else if("queryOneBack".equals(action)){
         queryOneBack(request,response);
     } else if("queryPage".equals(action)){
         System.out.println("bookServlet..."+action);
         queryPage(request,response);
     }else if("toadd".equals(action)){
         System.out.println("bookServlet..."+action);
         toadd(request,response);
     }

   }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bId = request.getParameter("bId");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String publishDate = request.getParameter("publishDate");

        Book book = new Book(name, Float.parseFloat(price), DateUtil.formatString(publishDate, "yyyy-MM-dd HH:mm:ss"));
        int i = bookService.add(book);
        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bId = request.getParameter("bId");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String publishDate = request.getParameter("publishDate");

        Book book = new Book(name, Float.parseFloat(price), DateUtil.formatString(publishDate, "yyyy-MM-dd HH:mm:ss"));
        int i = bookService.update(book);
        response.getWriter().print(i);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bId = request.getParameter("bId");
        int i = bookService.delete(Integer.parseInt(bId));
        response.getWriter().print(i);

    }

    protected void queryOneBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bId = request.getParameter("bId");
        Book book = bookService.findByBId(Integer.parseInt(bId));
        request.setAttribute("book",book);
        request.getRequestDispatcher("/book/bookUpdate.jsp").forward(request,response);


    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String pageIndex = request.getParameter("page");
       PageBean pageBean=new PageBean();
       if(!StringUtil.isEmpty(pageIndex)){
           pageBean.setPageIndex(Integer.parseInt(pageIndex));
       }
        String limit = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(limit));

        pageBean.setCount(bookService.findAll().size());
        System.out.println("pageBean.."+pageBean);
        List<Book> bookList = bookService.queryPage(pageBean);
        request.setAttribute("bookList",bookList);
        System.out.println("bookList..."+bookList);

        request.setAttribute("bookList",bookList);
        request.getRequestDispatcher("/book/bookQuery.jsp").forward(request,response);
      /*  JSONObject jsonObject = JsonUtil.getJsonObject(bookList,pageBean);*/
       /* System.out.println("jsonObject.."+jsonObject);
        response.getWriter().print(jsonObject);*/

    }
    protected void toadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/book/bookAdd.jsp").forward(request,response);
    }


}
