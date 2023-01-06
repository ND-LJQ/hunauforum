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
     *
     * @return {@link String}
     */
    public String generateVerificationCode();

    /**
     * 发送邮件
     *
     * @param receiver 接收机
     * @param subject  主题
     * @param verCode  版本代码
     */
    void sendEmailVerCode(String receiver, String subject, String verCode);

    /**
     * 发送html邮件
     *
     * @param to      来
     * @param subject 主题
     * @param content 内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送附件邮件
     *
     * @param to       来
     * @param subject  主题
     * @param content  内容
     * @param filePath 文件路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);
}
