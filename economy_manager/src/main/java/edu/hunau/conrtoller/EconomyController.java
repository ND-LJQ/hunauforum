package edu.hunau.conrtoller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import edu.hunau.config.AlipayConfig;
import edu.hunau.entity.AliTradeCloseBean;
import edu.hunau.entity.AlipayBean;
import edu.hunau.entity.AlipayTradeRefundBean;
import edu.hunau.service.EconomyService;
import edu.hunau.util.MyPayUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 经济控制器
 *
 * @author ND_LJQ
 * @date 2023/01/07
 */

@RestController
@RequestMapping(value = {"/economy"})
public class EconomyController {

    /**日志对象*/
    private static final Logger logger = LoggerFactory.getLogger(EconomyController.class);

    @Autowired
    private EconomyService economyService;

    @Resource
    private AlipayConfig alipayConfig;

    @Value("${alipay.appId}")
    private String test;


    /**
     * 支付宝支付
     *
     * @param outTradeNo  商户订单号
     * @param subject     订单名称
     * @param totalAmount 付款金额
     * @param notice      商品描述
     * @param payType     支付类型
     * @return {@link String}
     * @throws AlipayApiException 支付宝api例外
     */
    @PostMapping("/alipay")
    @ResponseBody
    public String alipay(@RequestParam String outTradeNo,@RequestParam String subject, @RequestParam String totalAmount, @RequestParam String notice,@RequestParam String payType) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean(outTradeNo,subject,totalAmount,notice);
        return economyService.aliPay(alipayBean,payType);
    }

    @PostMapping("/alipay/trade/close")
    public String aliTradeClose(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException, AlipayApiException {
        AliTradeCloseBean aliTradeCloseBean = new AliTradeCloseBean();
        Map<String,String[]> params = request.getParameterMap();
        BeanUtils.populate(aliTradeCloseBean ,params);
        return economyService.aliPayTradeClose(aliTradeCloseBean);
    }

    @PostMapping("/alipay/trade/refund")
    public String aliTradeRefund(HttpServletRequest request ) throws InvocationTargetException, IllegalAccessException, AlipayApiException {
        AlipayTradeRefundBean alipayTradeRefundBean = new AlipayTradeRefundBean();
        Map<String,String[]> params = request.getParameterMap();
        BeanUtils.populate(alipayTradeRefundBean ,params);
        return economyService.aliPayFullRefund(alipayTradeRefundBean);
    }

    @RequestMapping(value = {"/pay/alinotify"})
    @ResponseBody
    public String aliPayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException {
        //支付后回调 整合实际业务更新订单数据
        //获取支付宝发送过来的信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        //循环获取到所有的值
        for(String str:requestParams.keySet()) {
            String name =str;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.getPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
        //boolean类型signVerified为true时 则验证成功
        if(signVerified) {
            //获取到支付的状态 TRADE_SUCCESS则支付成功
            String trade_status =request.getParameter("trade_status");
            if (trade_status.equals("TRADE_SUCCESS")){
                System.out.println("支付成功");
            }else {
                System.out.println("支付失败");
            }
        }
        //签名验证失败
        else {
            System.out.println(AlipaySignature.getSignCheckContentV1(params));
        }
        return "交易成功！";
    }

    @RequestMapping(value = "/pay/redirect")
    public String payRedirect(){
        //模拟支付后成功界面
        return "index.html";
    }

}
