package edu.hunau.service;

import com.alipay.api.AlipayApiException;
import edu.hunau.config.AlipayConfig;
import edu.hunau.entity.AliTradeCloseBean;
import edu.hunau.entity.AlipayBean;
import edu.hunau.entity.AlipayTradeRefundBean;

import javax.annotation.Resource;

/**
 * 经济服务
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */
public interface EconomyService {

    /**
     * 支付宝支付
     *
     * @param aliPayBean 支付宝支付实体
     * @param payType    支付类型
     * @return {@link String}
     * @throws AlipayApiException 支付宝api例外
     */
    String aliPay(AlipayBean aliPayBean,String payType) throws AlipayApiException;

    /**
     * 阿里支付全额退款
     * 支付宝全额退款
     *
     * @param alipayTradeRefundBean 支付宝交易退款实体
     * @return {@link String}
     * @throws AlipayApiException 支付宝api例外
     */
    String aliPayFullRefund(AlipayTradeRefundBean alipayTradeRefundBean) throws AlipayApiException;


    /**
     * 支付宝超时关闭订单
     *
     * @param aliTradeCloseBean 支付宝关闭支付实体
     * @return {@link String}
     * @throws AlipayApiException 支付宝api例外
     */
    String aliPayTradeClose(AliTradeCloseBean aliTradeCloseBean) throws AlipayApiException;

}
