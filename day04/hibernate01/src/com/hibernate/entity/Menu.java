package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/11
 * @Description: Menu
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu {

    private Integer id;
    private String name;

private Set<Role01> role01Set=new HashSet<Role01>();



@ManyToMany(mappedBy = "menu")
    public Set<Role01> getRole01Set() {
        return role01Set;
    }

    public void setRole01Set(Set<Role01> role01Set) {
        this.role01Set = role01Set;
    }

    @Id
    @GenericGenerator(name = "_native",strategy="native")
    @GeneratedValue(generator = "_native")
    @Column(name = "m_id")
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



}
