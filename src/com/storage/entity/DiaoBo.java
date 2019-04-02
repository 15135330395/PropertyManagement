package com.storage.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 14:30
 * Description: 调拨信息，包括出入库的仓库ID，货物名字和数量，日期
 */
public class DiaoBo {
    private int outStorage;
    private int inStorage;
    private String goodName;
    private int numbers;
    private String date;

    @Override
    public String toString() {
        return "DiaoBo{" +
                "outStorage=" + outStorage +
                ", inStorage=" + inStorage +
                ", goodName='" + goodName + '\'' +
                ", numbers=" + numbers +
                ", date='" + date + '\'' +
                '}';
    }

    public DiaoBo(int outStorage, int inStorage, String goodName, int numbers, String date) {
        this.outStorage = outStorage;
        this.inStorage = inStorage;
        this.goodName = goodName;
        this.numbers = numbers;
        this.date = date;
    }

    public int getOutStorage() {
        return outStorage;
    }

    public void setOutStorage(int outStorage) {
        this.outStorage = outStorage;
    }

    public int getInStorage() {
        return inStorage;
    }

    public void setInStorage(int inStorage) {
        this.inStorage = inStorage;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
