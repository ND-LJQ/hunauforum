package edu.hunau.config;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import edu.hunau.entity.AliPayBean;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Data
@Configuration
public class Alipay {

    /**日志对象*/
    private static final Logger logger = LoggerFactory.getLogger(Alipay.class);

    private final String format = "json";

    /**
     * 支付宝网关地址
     */
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * appid
     */
    private String appId = "2021000122603405";

    /**
     * 支付宝应用私钥
     */
    private String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCSk69V8lMt3iGNHMhw/MsXnI8c/fbuYzCVcv6KKfcP/1d2ll3vmWt/57nL1xFprwjHgk71IOQUHcpiFb6BYPttH0uz7TYW5xcaRLsyrerpj72Qi8UsXrvEIXmApvIugoJTE24+ryhOw0Wu8dcNJgtPbO3cQxmFcEwHCNHx4LJGVI/WLhJdSXgkNi8xNEEqdBWSyHGFDwRqm3FNQS3/aoNhOEdfnnVpZBTtl4OjfaAmWPlZhDf/VqyftKK8AIi4BEcXmY97BLE0Hmg2ngtTEO4m4++YmJYc5/wL9EkaQzDQAACUygF6zYoaTnj1JBXafGDkN8GYzcxpCY0yQUcdySVLAgMBAAECggEAQMb5zu7n6bZod3eH8b8WdhnfeX2XOmUlnHaUnTTMlgpPef4cB35y7rTW/InQjTcolxs0j8p4YZeE0HIxnfXhR6l0CFFF/Tslj5tea5hG3++BZDcQ7Xn0W0o76ypcj0doFxTYPOWl16Ee06DXXF061GAcgqI4zisBvn4cYlveDYw3b84UX3FmELM6Y6znTiM8IQihC13znMNObuFfMutmU+HbHA8cJ590eKndUO8czirDPK+l8GhDkAGqcMVy+/vDhhuZ8mfhmX94NQG1HIPuPLw/2Jj9BeyopR7mc+/B8AUZEQ/0GNXNMvAbmB5lMQuE9/0/+AGjEqFjshGL/jP+IQKBgQDWAJAcHYDiLcolpO8D4GW6hTlrrLsulFcW0JfJVnwprTAbj3YLjZEQqZgnQBRN5fdxwXYyd5Gi9uoIUzjqQ7sbChSTI9St/4w6JaA9KVGWGoix7mvv3t7tQzPeQBYPzwfaJgB1PcrPY77QA9Z+pW66t0Hswy9w/8rpN6JMUltaewKBgQCvV69og2uoiDvxumFWnL0mkwKOD4/DUnQpQLoiII9NzbvUd91RDyeu7OM1lCLi/obDpCf8EoCv47NPDdr4KjWkfgc8Fh4LBj70sGjwrUc3lgj7NOkh9e5FXbnRiynwb6q9FLgW8s8uSJga7TOy6cZ4Ogo0kN+WUdyfngypG6sPcQKBgGiZc9baMOHcob7OpCkP6IlHju5rSj6VMRAsutQlWqEATtBZycgR1QMA8ibVMld0/QJ0HjLCsMOnznJtQxd2LaEkxzO4Qr8ddkwBkhXy+TbWF1RpBgcDt5De1R5f0qi9d8gP5Q9pOZUu2thP1+qlL79BzY5NRQYFcQeXMtP9OTu7AoGAXkXixWqDY6V7tUfkNdEn0amQ4hhzzyxx0AxBB0BCTC6lImMf1wky6NXsg04WQ71db6q+5MR99BOUwJhOdsca+EnaUfACTyMYji6a/WvssnI0efvErMGxThJKaeNMtT0Uq3yMTapWwie9wBxwg201jEaIXiLWU9fHqvorDHEX08ECgYBQl1cLNpccyLw4j6LETnJu47J+eA0McmQwL60rOeS4rsHrso1EMmdAqhdL2PlDBDhtLp28spaUXRLymYAcRDlMgYImYDmejU097wA684Pq8oASyeApoeQA8ieLo/4/nXWZJJspOozyCSrAjVOpYbMF99fMGxMJTaCnD39RXg4OZg==";

    /**
     * 支付宝应用公钥
     */
    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkpOvVfJTLd4hjRzIcPzLF5yPHP327mMwlXL+iin3D/9XdpZd75lrf+e5y9cRaa8Ix4JO9SDkFB3KYhW+gWD7bR9Ls+02FucXGkS7Mq3q6Y+9kIvFLF67xCF5gKbyLoKCUxNuPq8oTsNFrvHXDSYLT2zt3EMZhXBMBwjR8eCyRlSP1i4SXUl4JDYvMTRBKnQVkshxhQ8EaptxTUEt/2qDYThHX551aWQU7ZeDo32gJlj5WYQ3/1asn7SivACIuARHF5mPewSxNB5oNp4LUxDuJuPvmJiWHOf8C/RJGkMw0AAAlMoBes2KGk549SQV2nxg5DfBmM3MaQmNMkFHHcklSwIDAQAB";


    /**
     * 通知地址
     */
    private String notifyUrl = "https://d66400h317.goho.co/economy/test";


    /**
     * 返回url
     */
    private String returnUrl;

    /**
     * 签名方式
     */
    private String signType = "RSA2";

    /**
     * 字符集
     */
    private  String charset = "utf-8";



    public String pay(AliPayBean aliPayBean) throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient(
                gatewayUrl, appId, privateKey, format, charset, publicKey, signType);

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);
        alipayRequest.setBizContent(JSON.toJSONString(aliPayBean));
        logger.info("封装请求支付宝付款参数为:{}", JSON.toJSONString(alipayRequest));

        String result = alipayClient.pageExecute(alipayRequest).getBody();
        logger.info("请求支付宝付款返回参数为:{}", result);

        return result;
    }

}
