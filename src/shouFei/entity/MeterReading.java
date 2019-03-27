package shouFei.entity;

import java.util.Date;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class MeterReading {
    //抄表录入  水电费
    private int meterReadingId;//小区名
    private String plotName;//小区名
    private String roomNumber;//房间号
    private String payName;//收费项目名称
    private String normName;//收费标准名称
    private Date month;//月份
    private double price;//单价
    private double start;//起度
    private double stop;//止度
    private double pooled;//公摊
    private String note;//6备注

}
