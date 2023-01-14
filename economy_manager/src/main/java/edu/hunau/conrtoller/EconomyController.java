package edu.hunau.conrtoller;

import com.alipay.api.AlipayApiException;
import edu.hunau.entity.AliPayBean;
import edu.hunau.service.EconomyService;
import edu.hunau.util.MyPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = {"/test"})
    public void test(){
        MyPayUtil myPayUtil = new MyPayUtil();
        myPayUtil.myTest();
        System.out.println("配调用");
    }


    @PostMapping("/pay")
    @ResponseBody
    public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {

        logger.info("商户订单号为{},订单名称为{},付款金额为{},商品描述{}", outTradeNo, subject, totalAmount, body);
        AliPayBean alipayBean = new AliPayBean();
        alipayBean.setOutTradeNo(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotalAmount(totalAmount);
        alipayBean.setBody(body);
        return economyService.aliPay(alipayBean);
    }

    @RequestMapping(value = {"/pay/notify"})
    @ResponseBody
    public String payNotify(){
        return "交易成功！";
    }

    @RequestMapping(value = "/pay/redirect")
    public String payRedirect(){
        return "index.html";


    }

}
