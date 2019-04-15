package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/11
 * @Description: Role01
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role01")
public class Role01 {

    private Integer id;
    private String name;
    private Set<Menu> menu=new HashSet<Menu>();


    @Id
    @GenericGenerator(name="_native",strategy="native")
    @GeneratedValue(generator = "_native")
    @Column(name = "r_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
@Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_menu",
    joinColumns = {@JoinColumn(name="r_id")},
    inverseJoinColumns = {@JoinColumn(name="m_id")}
    )
    public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }

}
