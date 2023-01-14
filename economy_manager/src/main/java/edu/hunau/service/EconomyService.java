package edu.hunau.service;

import com.alipay.api.AlipayApiException;
import edu.hunau.entity.AliPayBean;

/**
 * 经济服务
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */
public interface EconomyService {

    /**
     * 阿里支付
     *
     * @param aliPayBean 支付宝支付实体
     * @return {@link String}
     * @throws AlipayApiException 支付宝api例外
     */
    String aliPay(AliPayBean aliPayBean) throws AlipayApiException;
}
