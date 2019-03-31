package com.system.entity;

/**
 * @Description 权限的菜单表
 * @Author WYR
 * @CreateTime 2019-03-31 14:29
 */
public class Menu {
    private int menuId;
    private String menuName;
    private String img;
    private String url;
    private int parentId = -1;

    public Menu() {
    }

    public Menu(String menuName, String img, String url, int parentId) {
        this.menuName = menuName;
        this.img = img;
        this.url = url;
        this.parentId = parentId;
    }

    public Menu(int menuId, String menuName, String img, String url, int parentId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.img = img;
        this.url = url;
        this.parentId = parentId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenu_id(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenu_name(String menuName) {
        this.menuName = menuName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParent_id(int parentId) {
        this.parentId = parentId;
    }
}
