package edu.hunau.entity;

import lombok.Data;

/**
 * 支付宝支付实体
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */
@Data
public class AlipayBean {
    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 订单名称
     */
    private String subject;

    /**
     * 付款金额
     */
    private String total_amount;

    /**
     * 商品描述
     */
    private String body;

    /**
     * 退款金额
     */
    private String refund_amount;

    /**
     * 退款请求号
     * 如需部分退款此参数必传
     */
    private String out_request_no;

    /**
     * 退款原因
     */
    private String refund_reason;

    /**
     * 超时时间参数
     */
    private String timeout_express = "60m";

    /**
     * 产品编号
     */
    private String product_code = "FAST_INSTANT_TRADE_PAY";

    public AlipayBean(String outTradeNo, String subject, String totalAmount, String body) {
        this.out_trade_no = outTradeNo;
        this.subject = subject;
        this.total_amount = totalAmount;
        this.body = body;
    }

    public AlipayBean(String out_trade_no, String refund_amount){
        this.out_trade_no = out_trade_no;
        this.refund_amount = refund_amount;
    }

    public AlipayBean(String out_trade_no, String refund_amount, String out_request_no) {
        this.out_trade_no = out_trade_no;
        this.refund_amount = refund_amount;
        this.out_request_no = out_request_no;
    }



    public AlipayBean(){}
}
