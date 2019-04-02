package shouFei.entity;

import java.util.Date;

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
public class Pay {
    private int pid;
    private String department;
    private int staffId;
    private String staffName;
    private double monery;
    private String reason;//原因
    private String transactor;//办理人
    private Date shijian;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public double getMonery() {
        return monery;
    }

    public void setMonery(double monery) {
        this.monery = monery;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTransactor() {
        return transactor;
    }

    public void setTransactor(String transactor) {
        this.transactor = transactor;
    }

    public Date getShijian() {
        return shijian;
    }

    public void setShijian(Date shijian) {
        this.shijian = shijian;
    }


    public Pay() {
    }

    public Pay(int pid, String department, int staffId, String staffName, double monery, String reason, String transactor, Date shijian) {
        this.pid = pid;
        this.department = department;
        this.staffId = staffId;
        this.staffName = staffName;
        this.monery = monery;
        this.reason = reason;
        this.transactor = transactor;
        this.shijian = shijian;
    }
    public Pay( String department, int staffId, String staffName, double monery, String reason, String transactor, Date shijian) {
        this.department = department;
        this.staffId = staffId;
        this.staffName = staffName;
        this.monery = monery;
        this.reason = reason;
        this.transactor = transactor;
        this.shijian = shijian;
    }
}
