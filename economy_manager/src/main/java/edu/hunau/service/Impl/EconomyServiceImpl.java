package edu.hunau.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import edu.hunau.config.AlipayConfig;
import edu.hunau.entity.AlipayBean;
import edu.hunau.service.EconomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static edu.hunau.util.FinalData.PAY_TYPE_APP;
import static edu.hunau.util.FinalData.PAY_TYPE_WEB;

/**
 * 经济服务实现类
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */

@Service
public class EconomyServiceImpl implements EconomyService {


    @Resource
    private AlipayConfig alipayConfig;

    /**日志对象*/
    private static final Logger logger = LoggerFactory.getLogger(EconomyServiceImpl.class);

    @Override
    public String aliPay(AlipayBean aliPayBean,String payType) throws AlipayApiException {
        if (PAY_TYPE_WEB.equals(payType)){

        }else if(PAY_TYPE_APP.equals(payType)){

        }
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getGatewayUrl(),alipayConfig.getAppId(),alipayConfig.getPrivateKey(),
                "json",alipayConfig.getCharset(),alipayConfig.getPublicKey(),alipayConfig.getSignType());
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //回调地址 结合业务更新我方数据库
        request.setNotifyUrl(alipayConfig.getNotifyUrl());
        //支付完 支付界面跳转的界面
        request.setReturnUrl(alipayConfig.getReturnUrl());
        request.setBizContent(JSON.toJSONString(aliPayBean));
        String result = alipayClient.pageExecute(request).getBody();
        return result;
    }


}
