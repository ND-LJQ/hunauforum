package edu.hunau.service;

import com.alipay.api.AlipayApiException;
import edu.hunau.config.AlipayConfig;
import edu.hunau.entity.AlipayBean;

import javax.annotation.Resource;

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
     * @param payType    支付类型
     * @return {@link String}
     * @throws AlipayApiException 支付宝api例外
     */
    String aliPay(AlipayBean aliPayBean,String payType) throws AlipayApiException;

}
