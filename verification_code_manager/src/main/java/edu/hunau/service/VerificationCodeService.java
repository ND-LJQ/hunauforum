package edu.hunau.service;

/**
 * 验证码服务
 *
 * @author ND_LJQ
 * @date 2023/01/06
 */
public interface VerificationCodeService {

    /**
     * 生成验证码
     * @param type 验证码类型 手机验证码为1 邮箱验证码为2
     * @return {@link String}
     */
    public String generateVerificationCode(Integer type);


    /**
     * 发送邮件
     *
     * @param receiver 收件人
     * @param subject  主题
     * @param verCode  验证码
     */
    void sendEmailVerCode(String receiver, String subject, String verCode);

    /**
     * 发送html邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     * @param serviceType 服务类型
     */
    void sendHtmlMail(String to, String subject, char[] content, String serviceType);

    /**
     * 发送附件邮件
     *
     * @param to       收件人
     * @param subject  主题
     * @param content  内容
     * @param filePath 附件文件路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);


    /**
     * 发送手机验证码
     *
     * @param phone 电话
     */
    void sendTelVcode(String phone,String code,String serviceType);
}
