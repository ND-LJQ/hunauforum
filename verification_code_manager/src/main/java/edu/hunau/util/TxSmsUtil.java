package edu.hunau.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

//导入可选配置类
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;

// 导入对应SMS模块的client
import com.tencentcloudapi.sms.v20210111.SmsClient;

// 导入要请求接口对应的request response类
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import edu.hunau.config.TxSmsProperties;

// 导入要请求接口对应的request response类
import com.tencentcloudapi.sms.v20210111.models.SendStatusStatisticsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendStatusStatisticsResponse;
import com.tencentcloudapi.sms.v20210111.models.PullSmsSendStatusRequest;
import com.tencentcloudapi.sms.v20210111.models.PullSmsSendStatusResponse;
import com.tencentcloudapi.sms.v20210111.models.AddSmsTemplateRequest;
import com.tencentcloudapi.sms.v20210111.models.AddSmsTemplateResponse;


/**
 * tx sms工具
 *
 * @author ND_LJQ
 * @date 2023/01/06
 */
public class TxSmsUtil {

    public static SmsClient createClient(){
        TxSmsProperties properties = new TxSmsProperties();
        /* 必要步骤：
         * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
         * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
         * 您也可以直接在代码中写入密钥对，但需谨防泄露，不要将代码复制、上传或者分享给他人
         * SecretId、SecretKey 查询：https://console.cloud.tencent.com/cam/capi
         */
        Credential cred = new Credential(properties.getSecretId(), properties.getSecretKey());
        // 实例化一个 http 选项，可选，无特殊需求时可以跳过
        HttpProfile httpProfile = new HttpProfile();
        // 设置代理
        // httpProfile.setProxyHost("真实代理ip");
        // httpProfile.setProxyPort(真实代理端口);
        /* SDK 默认使用 POST 方法
         * 如需使用 GET 方法，可以在此处设置，但 GET 方法无法处理较大的请求 */
        httpProfile.setReqMethod("POST");
        /* SDK 有默认的超时时间，非必要请不要进行调整
         * 如有需要请在代码中查阅以获取最新的默认值 */
        httpProfile.setConnTimeout(60);
        /* 指定接入地域域名，默认就近地域接入域名为 sms.tencentcloudapi.com ，也支持指定地域域名访问，例如广州地域的域名为 sms.ap-guangzhou.tencentcloudapi.com */
        httpProfile.setEndpoint("sms.tencentcloudapi.com");
        /* 非必要步骤:
         * 实例化一个客户端配置对象，可以指定超时时间等配置 */
        ClientProfile clientProfile = new ClientProfile();
        /* SDK 默认使用 TC3-HMAC-SHA256 进行签名
         * 非必要请不要修改该字段 */
        clientProfile.setSignMethod("HmacSHA256");
        clientProfile.setHttpProfile(httpProfile);
        /* 实例化 SMS 的 client 对象
         * 第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
        SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
        return client;
    }

    /**
     * 发送短信
     *
     * @param properties  属性
     * @param phone       电话
     * @param code        验证码
     * @param serviceType 服务类型
     */
    public void sendSms(TxSmsProperties properties,String phone,String code,String serviceType){

        try {
            SmsClient client = createClient();

            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 你可以直接查询SDK源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */
            SendSmsRequest req = new SendSmsRequest();

            /* 填充请求参数,这里request对象的成员变量即对应接口的入参
             * 你可以通过官网接口文档或跳转到request对象的定义处查看请求参数的定义
             * 基本类型的设置:
             * 帮助链接：
             * 短信控制台: https://console.cloud.tencent.com/smsv2
             * 腾讯云短信小助手: https://cloud.tencent.com/document/product/382/3773#.E6.8A.80.E6.9C.AF.E4.BA.A4.E6.B5.81 */

            /* 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId，示例如1400006666 */
            // 应用 ID 可前往 [短信控制台](https://console.cloud.tencent.com/smsv2/app-manage) 查看
            String sdkAppId = properties.getAppId();
            req.setSmsSdkAppId(sdkAppId);

            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名 */
            // 签名信息可前往 [国内短信](https://console.cloud.tencent.com/smsv2/csms-sign) 或 [国际/港澳台短信](https://console.cloud.tencent.com/smsv2/isms-sign) 的签名管理查看
            String signName = properties.getSmsSign();
            req.setSignName(signName);

            /* 模板 ID: 必须填写已审核通过的模板 ID */
            // 模板 ID 可前往 [国内短信](https://console.cloud.tencent.com/smsv2/csms-template) 或 [国际/港澳台短信](https://console.cloud.tencent.com/smsv2/isms-template) 的正文模板管理查看
            String templateId = properties.getTemplateIds();
            req.setTemplateId(templateId);

            /* 模板参数: 模板参数的个数需要与 TemplateId 对应模板的变量个数保持一致，若无模板参数，则设置为空 */
            String[] templateParamSet = {code,serviceType};
            req.setTemplateParamSet(templateParamSet);

            /* 下发手机号码，采用 E.164 标准，+[国家或地区码][手机号]
             * 示例如：+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号 */
//            String[] phoneNumberSet = {"+8621212313123", "+8612345678902", "+8612345678903"};
            String[] phoneNumberSet = {phone};
            req.setPhoneNumberSet(phoneNumberSet);


            /* 用户的 session 内容（无需要可忽略）: 可以携带用户侧 ID 等上下文信息，server 会原样返回 */
            String sessionContext = "";
            req.setSessionContext(sessionContext);

            /* 短信码号扩展号（无需要可忽略）: 默认未开通，如需开通请联系 [腾讯云短信小助手] */
            String extendCode = "";
            req.setExtendCode(extendCode);

            /* 国际/港澳台短信 SenderId（无需要可忽略）: 国内短信填空，默认未开通，如需开通请联系 [腾讯云短信小助手] */
            String senderid = "";
            req.setSenderId(senderid);

            /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
            SendSmsResponse res = client.SendSms(req);

            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(res));

            // 也可以取出单个值，你可以通过官网接口文档或跳转到response对象的定义处查看返回字段的定义
            // System.out.println(res.getRequestId());



        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拉取回执状态
     *
     * @param properties 属性
     */
    public void pullSmsSendStatus(TxSmsProperties properties){
        try {

            SmsClient client = createClient();
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 你可以直接查询SDK源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */
            PullSmsSendStatusRequest req = new PullSmsSendStatusRequest();

            /* 填充请求参数,这里request对象的成员变量即对应接口的入参
             * 你可以通过官网接口文档或跳转到request对象的定义处查看请求参数的定义
             * 基本类型的设置:
             * 帮助链接：
             * 短信控制台: https://console.cloud.tencent.com/smsv2
             * 腾讯云短信小助手: https://cloud.tencent.com/document/product/382/3773#.E6.8A.80.E6.9C.AF.E4.BA.A4.E6.B5.81 */

            /* 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId，示例如1400006666 */
            String sdkAppId = properties.getAppId();
            req.setSmsSdkAppId(sdkAppId);

            // 设置拉取最大条数，最多100条
            Long limit = 5L;
            req.setLimit(limit);

            /* 通过 client 对象调用 PullSmsSendStatus 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 PullSmsSendStatusResponse 类的实例，与请求对象对应 */
            PullSmsSendStatusResponse res = client.PullSmsSendStatus(req);

            // 输出json格式的字符串回包
            System.out.println(PullSmsSendStatusResponse.toJsonString(res));

        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送状态统计
     *
     * @param properties 属性
     * @param beginTime  开始时间 格式yyyymmddhh
     * @param endTime    结束时间 格式yyyymmddhh
     */
    public  void sendStatusStatistics(TxSmsProperties properties,String beginTime,String endTime){
        try {

            SmsClient client = createClient();
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 你可以直接查询SDK源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */
            SendStatusStatisticsRequest req = new SendStatusStatisticsRequest();

            /* 填充请求参数,这里request对象的成员变量即对应接口的入参
             * 你可以通过官网接口文档或跳转到request对象的定义处查看请求参数的定义
             * 基本类型的设置:
             * 帮助链接：
             * 短信控制台: https://console.cloud.tencent.com/smsv2
             * 腾讯云短信小助手: https://cloud.tencent.com/document/product/382/3773#.E6.8A.80.E6.9C.AF.E4.BA.A4.E6.B5.81 */

            /* 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId，示例如1400006666 */
            String sdkAppId = properties.getAppId();
            req.setSmsSdkAppId(sdkAppId);

            // 设置拉取最大条数，最多100条
            Long limit = 5L;
            req.setLimit(limit);
            /* 偏移量 注：目前固定设置为0 */
            Long offset = 0L;
            req.setOffset(offset);
            /* 开始时间，yyyymmddhh 需要拉取的起始时间，精确到小时 */
//            String beginTime = "2019071100";
            req.setBeginTime(beginTime);
            /* 结束时间，yyyymmddhh 需要拉取的截止时间，精确到小时
             * 注：EndTime 必须大于 beginTime */
//            String endTime = "2019071123";
            req.setEndTime(endTime);

            /* 通过 client 对象调用 SendStatusStatistics 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 SendStatusStatisticsResponse 类的实例，与请求对象对应 */
            SendStatusStatisticsResponse res = client.SendStatusStatistics(req);

            // 输出json格式的字符串回包
            System.out.println(SendStatusStatisticsResponse.toJsonString(res));

        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加短信模板
     *
     * @param templatename    模板名称
     * @param templatecontent 模板内容
     * @param smstype         短信类型：0表示普通短信, 1表示营销短信
     * @param international   是否国际/港澳台短信：0：表示国内短信，1：表示国际/港澳台短信
     * @param remark          备注
     */
    public  void addSmsTemplate(String templatename,String templatecontent,Long smstype,Long international,String remark){
        try {
            SmsClient client = createClient();
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 您可以直接查询 SDK 源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用 IDE 进行开发，可以方便地跳转查阅各个接口和数据结构的文档说明 */
            AddSmsTemplateRequest req = new AddSmsTemplateRequest();
            /* 填充请求参数，这里 request 对象的成员变量即对应接口的入参
             * 您可以通过官网接口文档或跳转到 request 对象的定义处查看请求参数的定义
             * 基本类型的设置:
             * 帮助链接：
             * 短信控制台：https://console.cloud.tencent.com/smsv2
             * 腾讯云短信小助手：https://cloud.tencent.com/document/product/382/3773#.E6.8A.80.E6.9C.AF.E4.BA.A4.E6.B5.81 */
            /* 模板名称*/
//            String templatename = "腾讯云";
            req.setTemplateName(templatename);
            /* 模板内容 */
//            String templatecontent = "{1}为您的登录验证码，请于{2}分钟内填写，如非本人操作，请忽略本短信。";
            req.setTemplateContent(templatecontent);
            /* 短信类型：0表示普通短信, 1表示营销短信 */
//            long smstype = 0;
            req.setSmsType(smstype);
            /* 是否国际/港澳台短信：0：表示国内短信，1：表示国际/港澳台短信。 */
//            long international = 0;
            req.setInternational(international);
            /* 模板备注：例如申请原因，使用场景等 */
//            String remark = "xxx";
            req.setRemark(remark);
            /* 通过 client 对象调用 AddSmsTemplate 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 AddSmsTemplateResponse 类的实例，与请求对象对应 */
            AddSmsTemplateResponse res = client.AddSmsTemplate(req);
            // 输出 JSON 格式的字符串回包
            System.out.println(AddSmsTemplateResponse.toJsonString(res));
            // 可以取出单个值，您可以通过官网接口文档或跳转到 response 对象的定义处查看返回字段的定义
            System.out.println(res.getRequestId());
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }

}

