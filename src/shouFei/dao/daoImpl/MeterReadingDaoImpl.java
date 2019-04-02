package shouFei.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import shouFei.dao.MeterReadingDao;
import shouFei.entity.MeterReading;
import shouFei.entity.PageBean;
import shouFei.framewoek.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/29;
 */
public class MeterReadingDaoImpl implements MeterReadingDao {
    final static String colname="meter_reading_id meterReadingId, plot_name plotName, room_number roomNumber, riqi, price, start, stop, pooled,moneysum";
    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<MeterReading> findAll() {
        List<MeterReading> list = new ArrayList<>();
        String sql="select "+colname+" from meter_reading";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MeterReading meterReading =  new MeterReading();
                int meterReadingId = rs.getInt("meterReadingId");
                String plotName = rs.getString("plotName");
                String roomNumber = rs.getString("roomNumber");
                Date riqi = rs.getDate("riqi");
                Double price = rs.getDouble("price");
                Double start = rs.getDouble("start");
                Double stop = rs.getDouble("stop");
                Double pooled = rs.getDouble("pooled");
                Double moneysum = rs.getDouble("moneysum");
                meterReading.setMeterReadingId(meterReadingId);
                meterReading.setPlotName(plotName);
                meterReading.setRoomNumber(roomNumber);
                meterReading.setRiqi(riqi);
                meterReading.setPrice(price);
                meterReading.setStart(start);
                meterReading.setStop(stop);
                meterReading.setPooled(pooled);
                meterReading.setMoneysum(moneysum);
                list.add(meterReading);
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
    public List<MeterReading> queryByPage(PageBean pageBean) {
        List<MeterReading> list = new ArrayList<>();
        String sql="select "+colname+" from meter_reading limit ?,?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                MeterReading meterReading =  new MeterReading();
                int meterReadingId = rs.getInt("meterReadingId");
                String plotName = rs.getString("plotName");
                String roomNumber = rs.getString("roomNumber");
                Date riqi = rs.getDate("riqi");
                Double price = rs.getDouble("price");
                Double start = rs.getDouble("start");
                Double stop = rs.getDouble("stop");
                Double pooled = rs.getDouble("pooled");
                Double moneysum = rs.getDouble("moneysum");
                meterReading.setMeterReadingId(meterReadingId);
                meterReading.setPlotName(plotName);
                meterReading.setRoomNumber(roomNumber);
                meterReading.setRiqi(riqi);
                meterReading.setPrice(price);
                meterReading.setStart(start);
                meterReading.setStop(stop);
                meterReading.setPooled(pooled);
                meterReading.setMoneysum(moneysum);
                list.add(meterReading);
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
    public int deleteMeterReading(int id) {
        String sql="delete from meter_reading where meter_reading_id=? ";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateMeterReading(MeterReading meterReading) {
        String sql="update meter_reading set plot_name=?, room_number=?, riqi=?, price=?, start=?, stop=?, pooled=? where meter_reading_id=?";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, meterReading.getPlotName(),meterReading.getRoomNumber()
                    ,meterReading.getRiqi(),meterReading.getPrice(),meterReading.getStart(),
                    meterReading.getStop(),meterReading.getPooled(),meterReading.getMeterReadingId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public MeterReading findMeterReadingById(int id) {
        MeterReading meterReading =  new MeterReading();
       // String sql="select * from meter_reading where meter_reading_id=?";
        String sql="select "+colname+" from meter_reading where meter_reading_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            //queryRunner.query(JdbcUtils.getConnection(),sql,new BeanListHandler<MeterReading>(MeterReading.class),id);
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                int meterReadingId = rs.getInt("meterReadingId");
                String plotName = rs.getString("plotName");
                String roomNumber = rs.getString("roomNumber");
                Date riqi = rs.getDate("riqi");
                Double price = rs.getDouble("price");
                Double start = rs.getDouble("start");
                Double stop = rs.getDouble("stop");
                Double pooled = rs.getDouble("pooled");
                Double moneysum = rs.getDouble("moneysum");
                meterReading.setMeterReadingId(meterReadingId);
                meterReading.setPlotName(plotName);
                meterReading.setRoomNumber(roomNumber);
                meterReading.setRiqi(riqi);
                meterReading.setPrice(price);
                meterReading.setStart(start);
                meterReading.setStop(stop);
                meterReading.setPooled(pooled);
                meterReading.setMoneysum(moneysum);
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
        return meterReading;
    }

    @Override
    public int addMeterReading(MeterReading meterReading) {
        String sql="insert into meter_reading (plot_name,room_number,riqi,price,start,stop,pooled) values (?,?,?,?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql,
                    meterReading.getPlotName(),meterReading.getRoomNumber(),
                    meterReading.getRiqi(),meterReading.getPrice(),
                    meterReading.getStart(),meterReading.getStop(),meterReading.getPooled());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
