package com.客户关系管理.entity;

/**
 * @author：Ganlan；
 * @date：2019-03-18；
 */

public class PageBean {

    private int count;
    private int pageIndex = 1;
    private int pageCount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPegeCount() {
        return pageCount;
    }

    public void setPegeCount(int pegeCount) {
        this.pageCount = pegeCount;
    }

    public int getPages(){

        return (count+pageCount-1)/pageCount;
    }

    public int getIndex(){

        return (pageIndex-1)*pageCount;
    }
}
