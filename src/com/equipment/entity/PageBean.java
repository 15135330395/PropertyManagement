/*
package com.equipment.entity;
*/
/*
 * @author :张
 * Date  : 2019/3/28
 * @Description: PageBean
 *//*


public class PageBean {
  */
/**总条数*//*

    private int count;
   */
/**每页的条数 *//*

    private int pageCount;
   */
/**当前页码*//*

    private int pageIndex;

*/
/**获取总页数*//*

    public int getPages(){
        return (count+pageCount-1)/pageCount;
    }
*/
/**获取某条数据的索引位置*//*

    public int getIndex(){
        return (pageIndex-1)*pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public PageBean(int count, int pageCount, int pageIndex) {
        this.count = count;
        this.pageCount = pageCount;
        this.pageIndex = pageIndex;
    }

    public PageBean() {
    }


}
*/
