package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: NativeEntity
 */

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "native", schema = "test", catalog = "")
public class NativeEntity {
    private Long nextVal;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "next_val")
    public Long getNextVal() {
        return nextVal;
    }

    public void setNextVal(Long nextVal) {
        this.nextVal = nextVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NativeEntity that = (NativeEntity) o;
        return Objects.equals(nextVal, that.nextVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextVal);
    }
}
