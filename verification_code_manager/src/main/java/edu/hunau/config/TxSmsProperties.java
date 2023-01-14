package edu.hunau.config;

/**
 * 短信属性
 *
 * @author ND_LJQ
 * @date 2023/01/06
 */
public class TxSmsProperties {

    /**
     * 腾讯云账户密钥对 secretId
     */
    private String secretId = "";
    /**
     * 腾讯云账户密钥对 secretKey
     */
    private String secretKey = "";
    /**
     * 短信应用appId和appKey
     */
    private String appId = "";
    /**
     * 短信应用appId和appKey
     */
    private String appKey = "";
    /**
     * 签名
     */
    private String smsSign = "";
    /**
     * 到期时间
     */
    private String expireTime = "";
    /**
     * redis存储前缀
     */
    private String phonePrefix = "";
    /**
     * 短信模板id
     */
    private String templateIds = "";

    public String getSecretId() {
        return secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getSmsSign() {
        return smsSign;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public String getTemplateIds() {
        return templateIds;
    }


}
