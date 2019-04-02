package com.storage.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 14:29
 * Description:仓库信息
 */
public class Storage {
    private int id;
    private String principal;
    private String contactPhone;

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", principal='" + principal + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }

    public Storage(int id, String principal, String contactPhone) {
        this.id = id;
        this.principal = principal;
        this.contactPhone = contactPhone;
    }

    public Storage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
