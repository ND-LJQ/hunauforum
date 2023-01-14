package edu.hunau.entity;

import lombok.Data;

/**
 * 支付宝支付实体
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */
@Data
public class AliPayBean {
    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 订单名称
     */
    private String subject;

    /**
     * 付款金额
     */
    private String totalAmount;

    /**
     * 商品描述
     */
    private String body;

    /**
     * 超时时间参数
     */
    private String timeoutExpress = "60m";

    /**
     * 产品编号
     */
    private String productCode = "FAST_INSTANT_TRADE_PAY";
}
