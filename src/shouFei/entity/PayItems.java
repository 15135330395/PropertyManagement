package shouFei.entity;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class PayItems {
    //收费项目
    private int payId;
    private String payName;//收费项目名称
    private String payType;//收费类别   周期性（有滞纳金设置）/临时性/押金性
    private String billingAccuracy;//计费精度，元角分
    private String note;//备注

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getBillingAccuracy() {
        return billingAccuracy;
    }

    public void setBillingAccuracy(String billingAccuracy) {
        this.billingAccuracy = billingAccuracy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PayItems() {
    }

    public PayItems(int payId, String payName, String payType, String billingAccuracy, String note) {
        this.payId = payId;
        this.payName = payName;
        this.payType = payType;
        this.billingAccuracy = billingAccuracy;
        this.note = note;
    }
    public PayItems(String payName, String payType, String billingAccuracy, String note) {
        this.payName = payName;
        this.payType = payType;
        this.billingAccuracy = billingAccuracy;
        this.note = note;
    }
    public PayItems(int payId, String payName, String payType) {
        this.payId = payId;
        this.payName = payName;
        this.payType = payType;
    }
    public PayItems( String payName, String payType) {
        this.payName = payName;
        this.payType = payType;
    }
}
