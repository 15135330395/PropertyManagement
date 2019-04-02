package com.shouFei.entity;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class PayNorm {
    //收费标准
    //与收费项目关联，收费名称直接就是收费项目名称
    private int normId;
    private String payName;//收费项目名称
    private String normName;//收费标准名称
    private String computeMode;//金额计算方式  单价*数量/每户单独输入/固定金额/自定义公式
    private int chargeCycle;//5收费周期


    public int getNormId() {
        return normId;
    }

    public void setNormId(int normId) {
        this.normId = normId;
    }

    public PayNorm(int normId) {
        this.normId = normId;
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

    public String getComputeMode() {
        return computeMode;
    }

    public void setComputeMode(String computeMode) {
        this.computeMode = computeMode;
    }

    public int getChargeCycle() {
        return chargeCycle;
    }

    public void setChargeCycle(int chargeCycle) {
        this.chargeCycle = chargeCycle;
    }

    public PayNorm() {
    }

    public PayNorm(int normId,String payName, String normName, String computeMode,  int chargeCycle) {
        this.normId = normId;
        this.payName = payName;
        this.normName = normName;
        this.computeMode = computeMode;
        this.chargeCycle = chargeCycle;
    }
    public PayNorm(String payName, String normName, String computeMode,  int chargeCycle) {
        this.payName = payName;
        this.normName = normName;
        this.computeMode = computeMode;
        this.chargeCycle = chargeCycle;
    }


}
