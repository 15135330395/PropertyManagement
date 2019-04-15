package com.web.entity;/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: PageBean
 */

public class PageBean {
 /*每页条数*/
    private int pageCount;
    /*页面索引值*/
    private int pageIndex;
    /* */
    private int count;


    public int getPages(){
        return (count+pageCount-1)/pageCount;
    }

    public int getIndex(){
        return (pageIndex-1)*pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public PageBean(int pageCount, int pageIndex, int count) {
        this.pageCount = pageCount;
        this.pageIndex = pageIndex;
        this.count = count;
    }

    public PageBean() {
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageCount=" + pageCount +
                ", pageIndex=" + pageIndex +
                ", count=" + count +
                '}';
    }
}
