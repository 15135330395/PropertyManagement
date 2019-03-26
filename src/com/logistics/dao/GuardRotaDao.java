package com.logistics.dao;

import com.entity.PageBean;
import com.logistics.entity.GuardRota;

import java.util.List;

/**
 * @Description GuardRotaDao
 * @Author WYR
 * @CreateTime 2019-03-26 22:46
 */
public interface GuardRotaDao {
    /**
     * 通过排班表ID查找
     *
     * @param rotaId
     * @return
     */
    GuardRota findRotaByRotaId(int rotaId);

    /**
     * 通过员工ID查找
     *
     * @param staffId
     * @return
     */
    List<GuardRota> findRotaByStaffId(int staffId);

    /**
     * 查询所有的值班表
     *
     * @return
     */
    List<GuardRota> getAllRota();

    /**
     * 查询所有值班表的分页
     *
     * @param pageBean
     * @return
     */
    List<GuardRota> getAllRotaByPage(PageBean pageBean);

    /**
     * 添加值班表
     *
     * @param guardRota
     * @return
     */
    int addRota(GuardRota guardRota);

    /**
     * 修改值班表
     *
     * @param guardRota
     * @return
     */
    int updateRota(GuardRota guardRota);

    /**
     * 删除值班表
     *
     * @param rotaId
     * @return
     */
    int deleteRota(int rotaId);
}
