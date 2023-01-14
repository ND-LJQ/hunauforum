package edu.hunau.service.Impl;

import com.alipay.api.AlipayApiException;
import edu.hunau.config.Alipay;
import edu.hunau.entity.AliPayBean;
import edu.hunau.service.EconomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 经济服务实现类
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */

@Service
public class EconomyServiceImpl implements EconomyService {

    @Autowired
    private Alipay alipay;

    /**日志对象*/
    private static final Logger logger = LoggerFactory.getLogger(EconomyServiceImpl.class);

    @Override
    public String aliPay(AliPayBean aliPayBean) throws AlipayApiException {
        logger.info("调用支付服务接口...");
        return alipay.pay(aliPayBean);
    }
}
