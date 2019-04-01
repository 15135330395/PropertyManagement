package shouFei.entity;

import java.util.Date;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class MeterReading {
    //抄表录入  水电费
    private int meterReadingId;//抄表id
    private String plotName;//小区名
    private String roomNumber;//房间号
    private String payName;//收费项目名称
    private String normName;//收费标准名称
    private Date riqi;//月份
    private double price;//单价
    private double start;//起度
    private double stop;//止度
    private double pooled;//公摊

    public int getMeterReadingId() {
        return meterReadingId;
    }

    public void setMeterReadingId(int meterReadingId) {
        this.meterReadingId = meterReadingId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getNormName() {
        return normName;
    }

    public void setNormName(String normName) {
        this.normName = normName;
    }

    public Date getRiqi() {
        return riqi;
    }

    public void setRiqi(Date riqi) {
        this.riqi = riqi;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getStop() {
        return stop;
    }

    public void setStop(double stop) {
        this.stop = stop;
    }

    public double getPooled() {
        return pooled;
    }

    public void setPooled(double pooled) {
        this.pooled = pooled;
    }

    public MeterReading() {
    }

    public MeterReading(int meterReadingId, String plotName, String roomNumber, String payName, String normName, Date riqi, double price, double start, double stop, double pooled) {
        this.meterReadingId = meterReadingId;
        this.plotName = plotName;
        this.roomNumber = roomNumber;
        this.payName = payName;
        this.normName = normName;
        this.riqi = riqi;
        this.price = price;
        this.start = start;
        this.stop = stop;
        this.pooled = pooled;
    }
    public MeterReading( String plotName, String roomNumber, String payName, String normName, Date riqi, double price, double start, double stop, double pooled) {
        this.plotName = plotName;
        this.roomNumber = roomNumber;
        this.payName = payName;
        this.normName = normName;
        this.riqi = riqi;
        this.price = price;
        this.start = start;
        this.stop = stop;
        this.pooled = pooled;
    }
}
