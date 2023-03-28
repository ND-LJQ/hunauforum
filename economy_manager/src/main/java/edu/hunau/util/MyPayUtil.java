package edu.hunau.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import edu.hunau.config.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * 支付工具类
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */
public class MyPayUtil {

    public AlipayClient createAliPayClient(AlipayConfig alipayConfig){
        System.out.println(alipayConfig.getPrivateKey());
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getGatewayUrl(),alipayConfig.getAppId(),alipayConfig.getPrivateKey(),
                "json",alipayConfig.getCharset(),alipayConfig.getPublicKey(),alipayConfig.getSignType());
        return  alipayClient;
    }
}
