package com.storage.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 14:39
 * Description: 出库表信息
 */
public class OutStorage {
    private int id;
    private String goodName;
    private int numbers;
    private String date;

    @Override
    public String toString() {
        return "OutStorage{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", numbers=" + numbers +
                ", date='" + date + '\'' +
                '}';
    }

    public OutStorage() {
    }

    public OutStorage(int id, String goodName, int numbers, String date) {
        this.id = id;
        this.goodName = goodName;
        this.numbers = numbers;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
