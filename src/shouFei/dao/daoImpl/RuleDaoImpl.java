package shouFei.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import shouFei.dao.RuleDao;
import shouFei.entity.PageBean;
import shouFei.entity.Rule;
import shouFei.framewoek.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/1;
 */
public class RuleDaoImpl implements RuleDao {
    final static String colname="rule_id ruleId,plot_name plotName,room_number roomNumber,pay_name payName," +
            "norm_name normName,price,area,close_end closeEnd,riqi,money,money1,money2,moneysum";
    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<Rule> findAll() {
        List<Rule> list = new ArrayList<>();
        String sql="select "+colname+" from rule";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Rule rule =  new Rule();
                int ruleId = rs.getInt("ruleId");
                String plotName = rs.getString("plotName");
                String roomNumber = rs.getString("roomNumber");
                String payName = rs.getString("payName");
                String normName=rs.getString("normName");
                Double price = rs.getDouble("price");
                Double area = rs.getDouble("area");
                int closeEnd = rs.getInt("closeEnd");
                Date riqi = rs.getDate("riqi");
                Double money = rs.getDouble("money");
                Double money1 = rs.getDouble("money1");
                Double money2 = rs.getDouble("money2");
                Double moneysum = rs.getDouble("moneysum");
                rule.setRuleId(ruleId);
                rule.setPlotName(plotName);
                rule.setRoomNumber(roomNumber);
                rule.setPayName(payName);
                rule.setNormName(normName);
                rule.setPrice(price);
                rule.setArea(area);
                rule.setCloseEnd(closeEnd);
                rule.setRiqi(riqi);
                rule.setMoney(money);
                rule.setMoney1(money1);
                rule.setMoney2(money2);
                rule.setMoneysum(moneysum);
                list.add(rule);
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
        return list;
    }

    @Override
    public List<Rule> queryByPage(PageBean pageBean) {
        List<Rule> list = new ArrayList<>();
        String sql="select "+colname+" from rule limit ?,?";
        PreparedStatement ps=null;
        ResultSet rs = null;

        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                Rule rule =  new Rule();
                int ruleId = rs.getInt("ruleId");
                String plotName = rs.getString("plotName");
                String roomNumber = rs.getString("roomNumber");
                String payName = rs.getString("payName");
                String normName=rs.getString("normName");
                Double price = rs.getDouble("price");
                Double area = rs.getDouble("area");
                int closeEnd = rs.getInt("closeEnd");
                Date riqi = rs.getDate("riqi");
               Double money = rs.getDouble("money");
                Double money1 = rs.getDouble("money1");
                Double money2 = rs.getDouble("money2");
                Double moneysum = rs.getDouble("moneysum");
                rule.setRuleId(ruleId);
                rule.setPlotName(plotName);
                rule.setRoomNumber(roomNumber);
                rule.setPayName(payName);
                rule.setNormName(normName);
                rule.setPrice(price);
                rule.setArea(area);
                rule.setCloseEnd(closeEnd);
                rule.setRiqi(riqi);
                rule.setMoney(money);
                rule.setMoney1(money1);
                rule.setMoney2(money2);
                rule.setMoneysum(moneysum);
                list.add(rule);
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
        return list;
    }

    @Override
    public int deleteRule(int id) {
        String sql="delete from rule where rule_id=? ";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRule(Rule rule) {
        String sql="update rule set plot_name=?, room_number=?, pay_name=?, norm_name=?, " +
                "price=?, area=?, close_end=?, riqi=?, money2=? where rule_id=?";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, rule.getPlotName(),rule.getRoomNumber(),rule.getPayName(),rule.getNormName()
                    ,rule.getPrice(),rule.getArea(),
                    rule.getCloseEnd(),rule.getRiqi(),rule.getMoney2(),rule.getRuleId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Rule findRuleById(int id) {
        Rule rule =  new Rule();
        // String sql="select * from meter_reading where meter_reading_id=?";
        String sql="select "+colname+" from rule where rule_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            //queryRunner.query(JdbcUtils.getConnection(),sql,new BeanListHandler<MeterReading>(MeterReading.class),id);
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                int ruleId = rs.getInt("ruleId");
                String plotName = rs.getString("plotName");
                String roomNumber = rs.getString("roomNumber");
                String payName = rs.getString("payName");
                String normName=rs.getString("normName");
                Double price = rs.getDouble("price");
                Double area = rs.getDouble("area");
                int closeEnd = rs.getInt("closeEnd");
                Date riqi = rs.getDate("riqi");
                Double money = rs.getDouble("money");
                Double money1 = rs.getDouble("money1");
                Double money2 = rs.getDouble("money2");
                Double moneysum = rs.getDouble("moneysum");
                rule.setRuleId(ruleId);
                rule.setPlotName(plotName);
                rule.setRoomNumber(roomNumber);
                rule.setPayName(payName);
                rule.setNormName(normName);
                rule.setPrice(price);
                rule.setArea(area);
                rule.setCloseEnd(closeEnd);
                rule.setRiqi(riqi);
                rule.setMoney(money);
                rule.setMoney1(money1);
                rule.setMoney2(money2);
                rule.setMoneysum(moneysum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return rule;
    }

    @Override
    public int addRule(Rule rule) {
        String sql="insert into rule (plot_name,room_number,pay_name,norm_name,price,area,close_end,riqi,money2) values (?,?,?,?,?,?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql,
                    rule.getPlotName(),rule.getRoomNumber(),rule.getPayName(),rule.getNormName()
                    ,rule.getPrice(),rule.getArea(),
                    rule.getCloseEnd(),rule.getRiqi(),rule.getMoney2());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
