package shouFei.entity;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class PayNorm {
    //收费标准
    //与收费项目关联，收费名称直接就是收费项目名称
    private int normId;
    private int payId;//收费项目id
    //private String payName;//收费项目名称
    private String normName;//收费标准名称
    private String computeMode;//金额计算方式  单价*数量/每户单独输入/固定金额/自定义公式
    //随着计算方式的不同，下列属性随之改变
    //单价*数量1,2,5,6       每户单独输入5,6    固定金额3,5,6    自定义公式4,5,6
    private double price;//1单价
    private String fillingType;//2计量方式
    private int closeEnd;//3固定金额
    private String customFormula;//4自定义公式
    private int chargeCycle;//5收费周期
    ////private String note;//6备注


    public int getNormId() {
        return normId;
    }

    public void setNormId(int normId) {
        this.normId = normId;
    }

    public PayNorm(int normId) {
        this.normId = normId;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFillingType() {
        return fillingType;
    }

    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
    }

    public int getCloseEnd() {
        return closeEnd;
    }

    public void setCloseEnd(int closeEnd) {
        this.closeEnd = closeEnd;
    }

    public String getCustomFormula() {
        return customFormula;
    }

    public void setCustomFormula(String customFormula) {
        this.customFormula = customFormula;
    }

    public int getChargeCycle() {
        return chargeCycle;
    }

    public void setChargeCycle(int chargeCycle) {
        this.chargeCycle = chargeCycle;
    }

    public PayNorm() {
    }

    public PayNorm(int normId,int payId, String normName, String computeMode, double price, String fillingType, int closeEnd, String customFormula, int chargeCycle) {
        this.normId = normId;
        this.payId = payId;
        this.normName = normName;
        this.computeMode = computeMode;
        this.price = price;
        this.fillingType = fillingType;//2计量方式   房屋建筑面积（m^2）。。。
        this.closeEnd = closeEnd;
        this.customFormula = customFormula;
        this.chargeCycle = chargeCycle;
    }
    public PayNorm(int payId,String normName, String computeMode, double price, String fillingType, int closeEnd, String customFormula, int chargeCycle) {
        this.payId = payId;
        this.normName = normName;
        this.computeMode = computeMode;
        this.price = price;
        this.fillingType = fillingType;//2计量方式   房屋建筑面积（m^2）。。。
        this.closeEnd = closeEnd;
        this.customFormula = customFormula;
        this.chargeCycle = chargeCycle;
    }
    //单价*数量
    public PayNorm(int payId, String normName, String computeMode, double price, String fillingType, int chargeCycle) {
        this.payId = payId;
        this.normName = normName;
        this.computeMode = computeMode;
        this.price = price;
        this.fillingType = fillingType;
        this.chargeCycle = chargeCycle;
    }
    //每户单独输入
    public PayNorm(int payId,String normName, String computeMode, int chargeCycle) {
        this.payId = payId;
        this.normName = normName;
        this.computeMode = computeMode;
        this.chargeCycle = chargeCycle;
    }
    //固定金额
    public PayNorm(int payId, String normName, String computeMode, int closeEnd, int chargeCycle) {
        this.payId = payId;
        this.normName = normName;
        this.computeMode = computeMode;
        this.closeEnd = closeEnd;
        this.chargeCycle = chargeCycle;
    }
    //自定义公式
    public PayNorm(int payId, String normName, String computeMode,  String customFormula, int chargeCycle) {
        this.payId = payId;
        this.normName = normName;
        this.computeMode = computeMode;
        this.customFormula = customFormula;//公式名称
        this.chargeCycle = chargeCycle;
    }

}
