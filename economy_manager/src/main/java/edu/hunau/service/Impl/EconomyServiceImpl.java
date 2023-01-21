package edu.hunau.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import edu.hunau.config.AlipayConfig;
import edu.hunau.entity.AliTradeCloseBean;
import edu.hunau.entity.AlipayBean;
import edu.hunau.entity.AlipayTradeRefundBean;
import edu.hunau.service.EconomyService;
import edu.hunau.util.MyPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static edu.hunau.util.FinalData.*;

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

    private MyPayUtil myPayUtil;

    /**日志对象*/
    private static final Logger logger = LoggerFactory.getLogger(EconomyServiceImpl.class);

    @Override
    public String aliPay(AlipayBean aliPayBean,String payType) throws AlipayApiException {
        String result = new String();
        AlipayClient alipayClient = myPayUtil.createAliPayClient();
        if (PAY_TYPE_WEB_PC.equals(payType)){
            AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
            //回调地址 结合业务更新我方数据库
            request.setNotifyUrl(alipayConfig.getNotifyUrl());
            //支付完 支付界面跳转的界面
            request.setReturnUrl(alipayConfig.getReturnUrl());
            request.setBizContent(JSON.toJSONString(aliPayBean));
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
            result = alipayClient.pageExecute(request).getBody();
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        }else if(PAY_TYPE_WEB_MOBILE.equals(payType)){
            AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
            //回调地址 结合业务更新我方数据库
            request.setNotifyUrl(alipayConfig.getNotifyUrl());
            //支付完 支付界面跳转的界面
            request.setReturnUrl(alipayConfig.getReturnUrl());
            request.setBizContent(JSON.toJSONString(aliPayBean));
            AlipayTradeWapPayResponse response = alipayClient.pageExecute(request);
            result = alipayClient.pageExecute(request).getBody();
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        }else if(PAY_TYPE_WEB_APP.equals(payType)){
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();

            //回调地址 结合业务更新我方数据库
            request.setNotifyUrl(alipayConfig.getNotifyUrl());
            //支付完 支付界面跳转的界面
            request.setReturnUrl(alipayConfig.getReturnUrl());
            request.setBizContent(JSON.toJSONString(aliPayBean));
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            result = alipayClient.pageExecute(request).getBody();
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        }
        return result;
    }

    @Override
    public String aliPayFullRefund(AlipayTradeRefundBean alipayTradeRefundBean) throws AlipayApiException {
        AlipayClient alipayClient = myPayUtil.createAliPayClient();
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(JSON.toJSONString(alipayTradeRefundBean));
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return alipayClient.pageExecute(request).getBody();
    }

    @Override
    public String aliPayTradeClose(AliTradeCloseBean aliTradeCloseBean) throws AlipayApiException {
        AlipayClient alipayClient = myPayUtil.createAliPayClient();
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizContent(JSON.toJSONString(aliTradeCloseBean));
        AlipayTradeCloseResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return alipayClient.pageExecute(request).getBody();
    }


}
