package com.logistics.dao.impl;

import com.logistics.dao.CleanerDao;
import com.logistics.entity.Cleaner;
import com.mysql.cj.jdbc.JdbcConnection;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description CleanerDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-29 18:14
 */
public class CleanerDaoImpl implements CleanerDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<Cleaner> getAllCleaner() {
        String sql = "select * from staff where department_id=202";
        try {
            List<Cleaner> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Cleaner.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
