package shouFei.dao.daoImpl;

import shouFei.dao.PayNormDao;
import shouFei.entity.PayNorm;
import shouFei.framewoek.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class PayNormDaoImpl implements PayNormDao {
    @Override
    public List<PayNorm> findAll() {
        return null;
    }

    @Override
    public int addPayNorm(PayNorm payNorm) {
        return 0;
    }

    @Override
    public int deletePayNorm(int id) {
        return 0;
    }

    @Override
    public int updatePayNorm(PayNorm payNorm) {
        return 0;
    }

    @Override
    public int findPayNormCountById(int id) {
        String sql="select count(*)  count from pay_norm where norm_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                int count = rs.getInt("count");
                return  count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return 0;
    }
}
