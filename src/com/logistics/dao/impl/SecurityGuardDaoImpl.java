package com.logistics.dao.impl;

import com.logistics.dao.SecurityGuardDao;
import com.logistics.entity.SecurityGuard;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description SecurityGuardDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-30 16:37
 */
public class SecurityGuardDaoImpl implements SecurityGuardDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<SecurityGuard> getAllGuard() {
        String sql = "select * from staff where department_id=201";
        try {
            List<SecurityGuard> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(SecurityGuard.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
