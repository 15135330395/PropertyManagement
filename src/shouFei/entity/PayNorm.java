package shouFei.entity;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class PayNorm {
    //收费标准
    //与收费项目关联，收费名称直接就是收费项目名称
    private int payId;//收费项目id
    private String payName;//收费项目名称
    private String normName;//收费标准名称
    private String computeMode;//金额计算方式  单价*数量/每户单独输入/固定金额/自定义公式
    //随着计算方式的不同，下列属性随之改变
    //单价*数量1,2,5,6       每户单独输入5,6    固定金额3,5,6    自定义公式4,5,6
    private double price;//1单价
    private String fillingType;//2计量方式
    private int closeEnd;//3固定金额
    private String customFormula;//4自定义公式
    private int chargeCycle;//5收费周期
    private String note;//6备注

}
